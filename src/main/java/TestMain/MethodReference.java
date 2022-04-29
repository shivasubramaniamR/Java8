package TestMain;

import lambda.Greeting_Method_Reference;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {

    public static void main(String[] args) {
        //Greeting_Method_Reference gmr = n -> System.out.println(n);

       // Greeting_Method_Reference gmr = System.out::println;

        //Greeting_Method_Reference gmr = String::toUpperCase;

        //Greeting_Method_Reference gmr = String::concat;
       // System.out.println(gmr.greet("lambda"," method ref"));

        List<String> list = new ArrayList<>();
        //Greeting_Method_Reference gmr = s -> list.add(s);

        Greeting_Method_Reference gmr = list::add;

        gmr.greet("lambda");
        gmr.greet("lambda_new");

        System.out.println(list);


    }
}
