package fuctionalInterface;

import org.testng.annotations.Test;

import java.util.function.Function;

public class Function_Interface {

    @Test
    public void functionInterface() {
        Function<Integer,Integer> f1 = a -> a+2;
        Function<Integer,Integer> f2 = b -> b*b;

        System.out.println(f1.apply(3));
        System.out.println(f2.apply(3));

        System.out.println(f1.andThen(f2).apply(5));
        System.out.println(f1.compose(f2).apply(5));


    }
}
