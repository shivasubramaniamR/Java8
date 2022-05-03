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
  
  Java 8 Streams
1) What Are Streams?
Streams can be defined as a sequences of elements from a source which support data processing operations. You can treat streams as operations on data. You will get to know as you go through this article.

2) Why Streams?
Almost every Java application use Collections API to store and process the data. Despite being the most used Java API, it is not easy to write the code for even some common data processing operations like filtering, finding, matching, sorting, mapping etc using Collections API . So, there needed Next-Gen API to process the data. So Java API designers have come with Java 8 Streams API to write more complex data processing operations with much of ease.

3) Characteristics Of Java 8 Streams
3.1) Streams are not the data structures
Streams doesn’t store the data. You can’t add or remove elements from streams. Hence, they are not the data structures. They are the just operations on data.

3.2) Stream Consumes a data source
Stream consumes a source, performs operations on it and produces the result. Source may be a collection or an array or an I/O resource. Remember, stream doesn’t modify the source.

3.3) Intermediate And Terminal Operations
Most of the stream operations return another new stream and they can be chained together to form a pipeline of operations.

The operations which return stream themselves are called intermediate operations. For example – filter(), distinct(), sorted() etc.

The operations which return other than stream are called terminal operations. count(). min(), max() are some terminal operations.

3.4) Pipeline Of Operations
A pipeline of operations consists of three things – a source, one or more intermediate operations and a terminal operation. Pipe-lining of operations let you to write database-like queries on a data source. In the below example, int array is the source, filter() and distinct() are intermediate operations and forEach() is a terminal operation.

1
IntStream.of(new int[] {4, 7, 1, 8, 3, 9, 7}).filter((int i) -> i > 5).distinct().forEach(System.out::println);
3.5) Internal Iteration
Collections need to be iterated explicitly. i.e you have to write the code to iterate over collections. But, all stream operations do the iteration internally behind the scene for you. You need not to worry about iteration at all while writing the code using Java 8 Streams API.

3.6) Parallel Execution
To gain the performance while processing the large amount of data, you have to process it in parallel and use multi core architectures. Java 8 Streams can be processed in parallel without writing any multi threaded code. For example, to process the collections in parallel, you just use parallelStream() method instead of stream() method.

1
2
3
4
5
6
7
8
9
10
11
12
13
14
15
16
17
18
19
List<String> names = new ArrayList<>();
         
names.add("David");
         
names.add("Johnson");
         
names.add("Samontika");
         
names.add("Brijesh");
         
names.add("John"); 
         
//Normal Execution
         
names.stream().filter((String name) -> name.length() > 5).skip(2).forEach(System.out::println);
         
//Parallel Execution
         
names.parallelStream().filter((String name) -> name.length() > 5).skip(2).forEach(System.out::println);
3.7) Streams are lazily populated
All elements of a stream are not populated at a time. They are lazily populated as per demand because intermediate operations are not evaluated until terminal operation is invoked.

3.8) Streams are traversable only once
You can’t traverse the streams more than once just like iterators. If you traverse the stream first time, it is said to be consumed.

1
2
3
4
5
6
7
8
9
List<String> nameList = Arrays.asList("Dinesh", "Ross", "Kagiso", "Steyn");
         
Stream<String> stream = nameList.stream();
         
stream.forEach(System.out::println);
         
stream.forEach(System.out::println);    
         
//Error : stream has already been operated upon or closed
3.9) Short Circuiting Operations
Short circuiting operations are the operations which don’t need the whole stream to be processed to produce a result. For example – findFirst(), findAny(), limit() etc.
  
  ![terminalvsintermediate](https://user-images.githubusercontent.com/67018853/166392083-a388749a-bac2-4037-a4c9-680bd0baa5f3.png)

  
  ![Java8StreamIntermediateVsTerminalOperations](https://user-images.githubusercontent.com/67018853/166392140-61cb657b-73e3-4f96-8852-76c41d2d4ba2.png)

  
image  and streams content taken from https://www.waytoeasylearn.com/learn/supplier-functional-interface/
