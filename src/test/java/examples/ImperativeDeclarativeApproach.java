package examples;

import beans.Person;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ImperativeDeclarativeApproach {

    @Test
    public void imperativeApproach() throws IOException {
        List<Person> people = MockData.getPeople();
        List<Person> peopleFromChina = new ArrayList<>();

        for (Person person : people) {
            if (person.getCountry().equalsIgnoreCase("china")) {
                peopleFromChina.add(person);
            }
        }

        for (Person person : peopleFromChina) {
            System.out.println(person);
        }
    }

    @Test
    public void declarativeApproach() throws IOException {
        MockData.getPeople().stream()
                .filter(person -> person.getCountry().equalsIgnoreCase("china"))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
