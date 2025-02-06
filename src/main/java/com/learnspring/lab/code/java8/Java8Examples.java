package com.learnspring.lab.code.java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Examples {

    public static void main(String[] args) {

        System.out.println(" 1. Traditional vs. Java 8 ways of converting array to list");
        int[] arr = {1, 2, 3, 4, 5};
        
        // Traditional way
        List<Integer> list1 = new ArrayList<>();
        for (int num : arr) {
            list1.add(num);
        }
        System.out.println("Before Java 8: " + list1);
        
        // Java 8 way
        List<Integer> list2 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println("Using Java 8 Streams: " + list2);

        System.out.println("\n 2. Printing an array using forEach");
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        names.forEach(System.out::println);

        System.out.println("\n 3. Filtering elements (Before vs. After Java 8)");
        
        // Before Java 8
        List<String> filteredNames1 = new ArrayList<>();
        for (String name : names) {
            if (name.length() > 3) {
                filteredNames1.add(name);
            }
        }
        System.out.println("Before Java 8: " + filteredNames1);
        
        // Java 8
        List<String> filteredNames2 = names.stream()
                                           .filter(name -> name.length() > 3)
                                           .collect(Collectors.toList());
        System.out.println("Using Java 8: " + filteredNames2);

        System.out.println("\n 4. Sorting List (Before vs. After Java 8)");
        
        // Before Java 8
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("Before Java 8: " + names);
        
        // Java 8 way
        List<String> sortedNames = names.stream()
                                        .sorted()
                                        .collect(Collectors.toList());
        System.out.println("Using Java 8 Streams: " + sortedNames);

        System.out.println("\n 5. Mapping Elements (Convert List to Uppercase)");
        
        // Before Java 8
        List<String> upperCaseNames1 = new ArrayList<>();
        for (String name : names) {
            upperCaseNames1.add(name.toUpperCase());
        }
        System.out.println("Before Java 8: " + upperCaseNames1);

        // Java 8 way
        List<String> upperCaseNames2 = names.stream()
                                            .map(String::toUpperCase)
                                            .collect(Collectors.toList());
        System.out.println("Using Java 8 Streams: " + upperCaseNames2);

        System.out.println("\n 6. Find First Element in Stream");
        Optional<String> firstElement = names.stream().findFirst();
        firstElement.ifPresent(System.out::println);

        System.out.println("\n 7. Using Optional to Avoid NullPointerException");
        Optional<String> optionalName = Optional.ofNullable(null);
        System.out.println(optionalName.orElse("Default Value"));

        System.out.println("\n 8. Sum of Array Elements (Before vs. After Java 8)");
        
        // Before Java 8
        int sum1 = 0;
        for (int num : arr) {
            sum1 += num;
        }
        System.out.println("Before Java 8: " + sum1);

        // Java 8
        int sum2 = Arrays.stream(arr).sum();
        System.out.println("Using Java 8 Streams: " + sum2);

        System.out.println("\n 9. Using Functional Interfaces (Predicate Example)");
        
        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println("Is 4 even? " + isEven.test(4));

        System.out.println("\n 10. Grouping Data using Collectors.groupingBy()");
        
        List<String> items = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        Map<String, Long> itemCount = items.stream()
                                           .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Item Count: " + itemCount);

        System.out.println("\n 11. Parallel Streams for Performance Improvement");
        
        long startTime = System.currentTimeMillis();
        IntStream.range(1, 100000).forEach(i -> {});
        long endTime = System.currentTimeMillis();
        System.out.println("Normal Stream Time: " + (endTime - startTime) + " ms");

        startTime = System.currentTimeMillis();
        IntStream.range(1, 100000).parallel().forEach(i -> {});
        endTime = System.currentTimeMillis();
        System.out.println("Parallel Stream Time: " + (endTime - startTime) + " ms");

        System.out.println("\n 12. Using Stream.of() for Quick List Creation");
        Stream.of("A", "B", "C").forEach(System.out::println);

        System.out.println("\n 13. Generating Infinite Streams");
        Stream.iterate(1, n -> n + 2)
              .limit(5)
              .forEach(System.out::println);

        System.out.println("\n 14. Removing Duplicates from a List");
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> uniqueNumbers = numbers.stream()
                                             .distinct()
                                             .collect(Collectors.toList());
        System.out.println("Unique Numbers: " + uniqueNumbers);

        System.out.println("\n 15. Convert List to Set using Streams");
        Set<Integer> numberSet = numbers.stream().collect(Collectors.toSet());
        System.out.println("Converted Set: " + numberSet);
    }
}
