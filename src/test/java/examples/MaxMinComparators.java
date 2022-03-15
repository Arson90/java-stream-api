package examples;

import com.google.common.collect.ImmutableList;
import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MaxMinComparators {
    final List<Integer> numbers = ImmutableList.of(20, 90, 7, 12, 55, 3, 11, 7);

    @Test
    public void min() {
        int integer = numbers.stream()
                .min(Comparator.naturalOrder())
                .orElse(0);

        assertEquals(3, integer);
        System.out.println("Minimum number is " + integer);
    }

    @Test
    public void max() {
       int integer = numbers.stream()
               .max(Comparator.naturalOrder())
               .orElse(0);

       assertEquals(90, integer);
       System.out.println("Maximum number is " + integer);
    }
}
