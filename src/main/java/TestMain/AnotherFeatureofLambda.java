package TestMain;

import lambda.Greeting;

public class AnotherFeatureofLambda {

    public static void main(String[] args) {
        Greeting g1 = (n) -> n.toLowerCase();


        test(n -> n.toLowerCase() + n.toUpperCase());


    }

// higher order functions are the opposite of traditional approaches

    public String toUpperCase(String s) {
        return s.toUpperCase();
    }

    public String toLowerCase(String s) {
        return s.toLowerCase();
    }

    public static void test(Greeting g) {
        String result = g.greet("shiva");
        System.out.println("result");
    }
}
