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
  
  
