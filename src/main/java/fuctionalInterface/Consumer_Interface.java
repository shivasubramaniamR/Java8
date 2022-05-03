package fuctionalInterface;

import org.testng.annotations.Test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Consumer_Interface {

    @Test(enabled=false)
    public void consumerTest() {
        List<String> list = new ArrayList<>();
        list.add("Shiva");
        list.add("Pramu");
        list.add("Drish");
        list.add("Drith");


        list.forEach(n -> System.out.println(n.toUpperCase()));

        Consumer<String> myName = s ->System.out.println(s);
        myName.accept("shiva");


        Consumer<Integer> i = e -> System.out.println(e);
        i.accept(35);

        Consumer<String> mySonName = t -> System.out.println(t);
        mySonName.accept("Drish");

        //we cannot chain the different data types
        //System.out.println(c.andThen(i));

        //System.out.println(c.andThen(c1));




    }

    @Test
    public void biConsumer() {



        Consumer<String> maths = m -> System.out.println(m);

        Consumer<String> science = s -> System.out.println(s.toUpperCase());

        maths.andThen(science).accept("first");


    }


}

