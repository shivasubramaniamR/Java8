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

