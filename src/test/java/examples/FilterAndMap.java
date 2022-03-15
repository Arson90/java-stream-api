package examples;

import beans.Person;
import beans.PersonDTO;
import com.google.common.collect.ImmutableList;
import mockdata.MockData;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FilterAndMap {

    @Test
    public void withoutFilter() throws IOException {
        ImmutableList<Person> people = MockData.getPeople();
        List<Person> maleFromBrazil = new ArrayList<>();
        for (Person person : people) {
            if (person.getGender().equalsIgnoreCase("male"))
                if (person.getCountry().equalsIgnoreCase("brazil"))
                    maleFromBrazil.add(person);
        }
        for (Person person : maleFromBrazil) {
            System.out.println(person);
        }
    }

    @Test
    public void personMapping() throws IOException {
        ImmutableList<Person> people = MockData.getPeople();
        people.stream()
                .map(PersonDTO::map)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    @Test
    public void personFilteringAndMapping() throws IOException {
        MockData.getPeople().stream()
                .filter(person -> person.getCountry().equalsIgnoreCase("Greece"))
                .map(Person::getCity)
                .map(String::toUpperCase)
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
