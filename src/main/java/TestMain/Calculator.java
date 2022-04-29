package TestMain;

import lambda.MathOperation;

public class Calculator {

    public static void main(String[] args) {

        //calculate((add1,add2) -> add1+add2);
        calculate(Integer::sum);
        calculate(Math::subtractExact);
        calculate(Math::multiplyExact);
        calculate(Math::floorDiv);

    }

    public static void calculate(MathOperation mo) {
        System.out.println(mo.operate(10,20));
    }
}
