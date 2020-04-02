object LearningScala3 {
  // Functions
  
  // Format is def <function name>(parameter name: type...) : return type = { expression }
  // Don't forget the = before the expression!
  def squareIt(x: Int) : Int = {
  	x * x
  }                                               //> squareIt: (x: Int)Int
  
  def cubeIt(x: Int): Int = {x * x * x}           //> cubeIt: (x: Int)Int
  
  println(squareIt(2))                            //> 4
  
  println(cubeIt(2))                              //> 8
  
  // Functions can take other functions as parameters
  
  def transformInt(x: Int, l: Int => Int) : Int = {
  	l(x) // treats as a function of x
  }                                               //> transformInt: (x: Int, l: Int => Int)Int
  
  val result = transformInt(2, squareIt)          //> result  : Int = 4
  println (result)                                //> 4
  
  // "Lambda functions", "anonymous functions", "function literals"
  // You can declare functions inline without even giving them a name
  // This happens a lot in Spark.
  transformInt(3, x => x * x * x)                 //> res0: Int = 27
  
  transformInt(10, x => x / 2)                    //> res1: Int = 5
  
  transformInt(2, x => {val y = x * 2; y * y})    //> res2: Int = 16
  
  
  // This is really important!
  
  // EXERCISE
  // Strings have a built-in .toUpperCase method. For example, "foo".toUpperCase gives you back FOO.
  // Write a function that converts a string to upper-case, and use that function of a few test strings.
  // Then, do the same thing using a function literal instead of a separate, named function.
  
  def uppercasing(x: String, l: String => String) : String = {   l(x)   }
                                                  //> uppercasing: (x: String, l: String => String)String
  
  def TOUppercase(anyString: String) : String ={  anyString.toUpperCase   }
                                                  //> TOUppercase: (anyString: String)String
  val result_string = uppercasing( "Amar naam Shuvo", TOUppercase)
                                                  //> result_string  : String = AMAR NAAM SHUVO
  println(result_string)                          //> AMAR NAAM SHUVO
 
  println(uppercasing("I love you", x => x.toUpperCase))
                                                  //> I LOVE YOU
}