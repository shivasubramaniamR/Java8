package testStreamsJava;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class StreamsIntro {

    @Test(enabled = false)
    public void traditionalApproach() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        for(int i=0;i<list.size();i++) {

            if(list.get(i) % 2 == 0) {
                System.out.println("Squared Number of "+list.get(i)+" is=> "+(list.get(i) * list.get(i)));
            }
        }


    }

    @Test(enabled = false)
    public void usingStreams() {

        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.stream()
                .filter(
                        i -> {
                            System.out.println("Filter Recieved :: "+i);
                            return i%2==0;
                })
//                .sorted()
                .limit(3)
//                .sorted()
                .map(j -> {


                    System.out.println("Map Recieved :: "+j);
                      return  j*j;
                })
//                .sorted()
                .forEach(System.out::println);


    }

    @Test(enabled = false)
    public void streamPeek() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.stream()
                .peek(p-> System.out.println("Filter Recieved :: "+p))
                .filter(i-> i%2==0)
                .limit(3)
                .peek(b -> System.out.println("Map Recieved :: "+b))
                .map(j->j*j)
                .forEach(System.out::println);

    }

    @Test(enabled = false)
    public void streamSkip() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);

        list.stream()
                .filter(i->i%2==0)
//                .skip(3)
                .limit(3)
//                .skip(2)
                .map(m->m*m)
                .skip(2)
                .forEach(System.out::println);
    }

    @Test
    public void streamInTestAutomation() {


    }


}
