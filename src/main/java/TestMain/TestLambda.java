package TestMain;

import lambda.Greeting;
import lambda.Greeting_multiple;

public class TestLambda  {

    public static void main(String[] args) {
       /* Greeting GoodMorning = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Good Morning "+name);
            }
        };*/

       /* Greeting GoodMorning = (String name) -> {
                System.out.println("Good Morning "+name);
            };*/


        //if it is one line then we can remove the braces as well
//        Greeting GoodMorning = (String name) -> System.out.println("Good Morning "+name);

        //we can also remove the parameter identifier and also remove the brackets if the parameter is only one
        Greeting GoodMorning = name -> System.out.println("Good Morning "+name);
        Greeting GoodEvening = name -> System.out.println("Good Evening "+name);
        Greeting moreOperations = name -> {
            System.out.println("uppercase "+name.toUpperCase());
            System.out.println("count "+name.length());
        };

        Greeting_multiple moreParams = (fn,ln,age) -> System.out.println("Name "+fn+ln+" age "+age);

        /*Greeting GoodEvening = new Greeting() {
            @Override
            public void greet(String name) {
                System.out.println("Good Evening "+name);
            }
        };*/

        GoodMorning.greet("Shiva");
        GoodEvening.greet("Shiva");
        moreOperations.greet("shiva");
        moreParams.greet("shiva","subramaniam",100);
    }
}
