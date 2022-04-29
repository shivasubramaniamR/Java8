package TestMain;

import lambda.Greeting;

public class LambdaasMethod {

    public static void main(String[] args) {

        System.out.println(getLambda().greet("shiva"));
    }

    public static Greeting getLambda() {

        return n -> n.toUpperCase();

    }
}
