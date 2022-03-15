package examples;

import beans.Person;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class StreamIterate {

    @Test
    public void range() {

        System.out.println("Loop for i");

        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
        }

        System.out.println("Exclusive");
        IntStream.range(0,10)
                .forEach(System.out::println);

        System.out.println("Inclusive");
        IntStream.rangeClosed(0,10)
                .forEach(System.out::println);
    }

    @Test
    public void rangeIteratingLists() throws IOException {
        List<Person> people = MockData.getPeople();
        IntStream.range(0, people.size())
                .forEach(index -> {
                    Person person = people.get(index);
                    System.out.println(person);
                });
    }

    @Test
    public void intStreamIterate() throws IOException {
        List<Person> people = MockData.getPeople();
        IntStream.iterate(0, index -> index + 1)
                .limit(10)
                .forEach(index -> {
            Person person = people.get(index);
            System.out.println(person);
        });
    }
}
