package fuctionalInterface;

import org.testng.annotations.Test;
import java.util.function.Predicate;

public class PredicateTest {

    @Test
    public void predicateCheck() {

        Predicate<Integer> i1 = i -> i > 2;
        Predicate<Integer> i2 = o -> o < 10;
        Predicate<Integer> i3 = k -> k > 2;
        Predicate<Integer> i4 = i1;

        System.out.println(i1.test(5));
        System.out.println(i1.equals(i2));
        System.out.println(i4.equals(i1));

        System.out.println(i1.negate().test(5));

        System.out.println(i1.or(i3).test(1));

        System.out.println(i1.and(i3).test(15));


    }
}

