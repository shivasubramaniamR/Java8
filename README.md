# Java8
All the Java 8 Related codes

Lamda - It is the implemtation of interface and the only condition is that interface should have only one abstract method

SAM - Single Abstract Method

Java 8 - Functional Interface - keyword

multiple line lamda s- should be written with { };

multiple parameters - more than one parameters can be passed to lambda with ()

Return Values - Lambda can also return values like a function

functional programming - it should not depend on any variable

function as first class objects - assigning a function to a variable 

higher order functions - it is the reverse of the normal function where in we create a function to store the data and we call that function with different actions

ex : consider a scenario of string uppercase, lowercase and then length

general approach is 

public String toUppercase(String input) {
  return input.toUpperCase();
}

public String toLowercase(String input) {
  return input.toLowerCase();
}

public String lengthFinder(String input) {
  return input.length();
}

and then 

we write a main method to invoke 

main() {
  toLowerCase("LambDA");
  toUpperCase("LambDA");
  lengthFinder("LambDA");
}

whereas in lambda

consider the interface called welcome

public interface welcome {
  String greet(String name);
}

in the main method

main ()
{
  test(n) -> n.toUpperCase();
  test(x) -> x.toLowerCase();
  test(h) -> h.length();
}

public static void test(welcome w) {
  System.out.println(w.greet("lambda");
}


Method References - shorter way of writing the clean code for the lambda

public interface methodref {

  String change(String input);
}

main() {
  //methodref mr = n -> n.toUpperCase();
  
  methodref mr = String::toUpperCase;
  System.out.println(mr.change("lambda"));
  
  below are some of the ways
  //System.out::println
  //String::concat - with two parameters
  
}

Method reference can even add to the list

consider the below example

public interface lamda_list {
    void add(String input);
}

main () {
    List<String> list = new ArrayList<>();
  
  lamda_list ll = x -> list.add(x); -- without method reference
  
  lamda_list ll = list::add; - with method reference
  
  ll.add("Anyname");
}
  
  | Description | Lambda Expression | Lambda using method reference |
| --- | --- | --- |
| Static Method call - pass as parameter- <br/> method accepts data and prints using System.out.println | (data) -> System.out.println(data) | System.out::println |
| Static Method call - pass as parameter- <br/> method accepts data and we pass it to another method to check if it is null  | (o) -> Objects.isNull(o) | Objects::isNull |
| Given Object - Instance method call- <br/> for example, call the toUpperCase for the given string | (data) -> data.toUpperCase() | String::toUpperCase |
| Given Object - Instance method call with parameter - <br/> for example, call the concat for the given string | (s1,s2) -> s1.contact(s2) | String::Concat |
| Given Object - Instance method call with parameters- <br/> for example, call the replaceAll for the given string with given parameters | (s1,s2,s3) -> s1.replaceAll(s2,s3) | String::replaceAll |
| Given Object - Pass as parameter- <br/> pass the given object to another object method as parameter | (data) -> list.add(data) | list::add |
| Create New Object - New Cat() | () -> new cat() | cat::new |
  
  
The above table reference is taken from Vinoth Selvaraj blog (https://www.vinsguru.com/vinoth-selvaraj/)
  
  
  Functional Interfaces
  ----------------------
  
  1. Supplier - The Supplier Interface is a part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java. It represents a function which does not take in any argument but produces a value of type T.
  
  The Supplier interface consists of only one function:

1. get()
          Supplier<Double> randomValue = () -> Math.random();
          Supplier<Double> randomValue = Math::random;
  
  
        // Print the random value using get()
        System.out.println(randomValue.get());
  
  it is useful in implemeting the driver factory in test automation 
  
  sample code below
  
    
    private static final Supplier<WebDriver> chromeSupplier = () -> {
        System.setProperty("webdriver.chrome.driver","D:\\Technology\\Tools\\drivers\\chrome\\chromedriver.exe");
        return new ChromeDriver();
    };

    private  static final Supplier<WebDriver> firefoxsupplier = () -> {
        System.setProperty("webdriver.gecko.driver","D:\\Technology\\Tools\\drivers\\firefox\\geckodriver.exe");
        return new FirefoxDriver();
    };

    private static Map<String,Supplier<WebDriver>> MAP = new HashMap<>();

    static {
        MAP.put("chrome",chromeSupplier);
        MAP.put("firefox",firefoxsupplier);
    }

    public static WebDriver getDriver(String Browser) {
        return MAP.get(Browser).get();
    }
  
  
  2. The Consumer Interface is a part of the java.util.function package which has been introduced since Java 8, to implement functional programming in Java. It represents a function which takes in one argument and produces a result. However these kind of functions don’t return any value.
Hence this functional interface which takes in one generic namely:- 
 

T: denotes the type of the input argument to the operation
The lambda expression assigned to an object of Consumer type is used to define its accept() which eventually applies the given operation on its argument. Consumers are useful when it not needed to return any value as they are expected to operate via side-effects. 
 

Functions in Consumer Interface
The Consumer interface consists of the following two functions:
 

1. accept()
  
  Consumer<String> c = (s) -> System.out::println;
  c.accept("sample"); 
  
  
  
  
  
  
  
  ![Functional Interface](https://user-images.githubusercontent.com/67018853/166186192-4d2c62d0-b5a8-48e6-835d-147fc3243790.png)
  
  image taken from https://www.waytoeasylearn.com/learn/supplier-functional-interface/
  
  

