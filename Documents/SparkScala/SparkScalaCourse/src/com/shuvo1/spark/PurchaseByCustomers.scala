
package com.shuvo1.spark

import org.apache.spark._
import org.apache.spark.SparkContext._
import org.apache.log4j._


object PurchaseByCustomers {
  
  def parseLine(line:String)= {
    val fields = line.split(",")
    val ID = fields(0)
    val ProductID = fields(1)
    val SpentMoney = fields(2).toFloat 
    (ID, SpentMoney)
  }
  
  def main(args: Array[String]) {
    
    // Set the log level to only print errors
    Logger.getLogger("org").setLevel(Level.ERROR)
        
    // Create a SparkContext using every core of the local machine, named RatingsCounter
    val sc = new SparkContext("local[*]", "PurchaseByCustomers")
   
    // Load up each line of the ratings data into an RDD
    val lines = sc.textFile("../customer-orders.csv")
    
    val parsedLines = lines.map(parseLine)
    
    val mapped = parsedLines.reduceByKey(_+_)
    
    val purchaseSorted = mapped.map( x => (x._2, x._1) ).sortByKey().collect
    
   for (result <- purchaseSorted) {
      val amount = result._1
      val customer = result._2
      val formattedAmount = f"$amount%.2f USD"
      println(s"$formattedAmount: $customer")
    }
    
   // mapped.foreach(println)
    

    
    
    
    
    
    
  }
  
}