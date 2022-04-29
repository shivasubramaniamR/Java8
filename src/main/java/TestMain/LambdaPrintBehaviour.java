package TestMain;

import lambda.Greeting;

public class LambdaPrintBehaviour {

    public static void main(String[] args) {

        System.out.println("Starting");
        //test(n -> n.toUpperCase());
        //printOrder();
        test( s -> {
            System.out.println("inside lambda");
            return s.toUpperCase();
        });
        System.out.println("Ending");
    }

    public static void printOrder() {
        System.out.println("inside test method");
    }


    public static void test(Greeting g) {
        System.out.println("inside greet method");
        System.out.println(g.greet("drishith"));
    }
}
