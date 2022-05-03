package TestMain;

import lambda.MathOperation;

public class Calculator_old {

    public static void main(String[] args) {

        MathOperation add = (a,b) -> a+b;
        MathOperation subtract = (a,b) -> a-b;
        MathOperation multiply = (a,b) -> a*b;
        MathOperation divide = (a,b) -> a/b;

//        System.out.println(calculate(add));
//        System.out.println(calculate(subtract));
//        System.out.println(calculate(multiply));
//        System.out.println(calculate(divide));


        System.out.println(calculate(3,add,8));
        System.out.println(calculate(8,subtract,4));
        System.out.println(calculate(6,multiply,4));
        System.out.println(calculate(10,divide,2));


    }

    public static int calculate(MathOperation mo) {
        return mo.operate(20,5);
    }

    public static int calculate(int onScreenNumber,MathOperation mo, int enteredNumber) {
        return mo.operate(onScreenNumber,enteredNumber);
    }
}
