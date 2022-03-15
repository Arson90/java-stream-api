package examples;

import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class DistinctAndCollectors {
    final List<String> countries = List.of("France", "Italy", "Spain", "Portugal", "Spain", "Brazil", "Italy", "Denmark");

    @Test
    public void distinct() {
        List<String> collect = countries.stream()
                .distinct()
                .collect(Collectors.toList());

        assertEquals(6, collect.size());
        System.out.println(collect);
    }

    @Test
    public void distinctUsingCollectors() {
        Set<String> collect = countries.stream()
                .collect(Collectors.toSet());

        assertEquals(6, collect.size());
        System.out.println(collect);
    }
}
