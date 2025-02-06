package com.learnspring.lab.code.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FilterExamples {

    public static void main(String[] args) {
        filterEvenNumbers();
        filterStringsByLength();
        filterObjects();
        filterUsingPredicate();
        filterAndCollectToMap();
        filterAndFindFirst();
        filterAndCount();
        filterAndLimit();
        sortNumbers();
        distinctValues();
        firstValue();
        lastValue();
        secondLastValue();
        secondValue();
        sortNumbersAsc();
        sortNumbersDesc();
        
        
    }
    
    

    // 1. Filtering even numbers from a list
    public static void filterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);
    }

    // 2. Filtering strings by length
    public static void filterStringsByLength() {
        List<String> words = Arrays.asList("apple", "banana", "cat", "dog", "elephant");
        List<String> filtered = words.stream()
                .filter(word -> word.length() > 3)
                .collect(Collectors.toList());
        System.out.println("Words with more than 3 letters: " + filtered);
    }

    // 3. Filtering objects based on a condition
    public static void filterObjects() {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        List<Person> adults = people.stream()
                .filter(p -> p.getAge() >= 30)
                .collect(Collectors.toList());
        System.out.println("Adults: " + adults);
    }

    // 4. Filtering using a Predicate
    public static void filterUsingPredicate() {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        List<String> startsWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());
        System.out.println("Names starting with A: " + startsWithA);
    }

    // 5. Filtering and collecting to a Map
    public static void filterAndCollectToMap() {
        List<Person> people = Arrays.asList(
                new Person("Alice", 25),
                new Person("Bob", 30),
                new Person("Charlie", 35)
        );
        Map<String, Integer> nameAgeMap = people.stream()
                .filter(p -> p.getAge() > 25)
                .collect(Collectors.toMap(Person::getName, Person::getAge));
        System.out.println("Filtered Map: " + nameAgeMap);
    }

    // 6. Filtering and finding the first match
    public static void filterAndFindFirst() {
        List<Integer> numbers = Arrays.asList(3, 7, 10, 14, 18);
        Integer firstEven = numbers.stream()
                .filter(n -> n % 2 == 0)
                .findFirst()
                .orElse(null);
        System.out.println("First even number: " + firstEven);
    }

    // 7. Filtering and counting elements
    public static void filterAndCount() {
        List<String> words = Arrays.asList("apple", "banana", "grape", "kiwi", "cherry");
        long count = words.stream()
                .filter(w -> w.length() > 4)
                .count();
        System.out.println("Number of words longer than 4 characters: " + count);
    }

    // 8. Filtering and limiting results
    public static void filterAndLimit() {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8, 10, 12, 14);
        List<Integer> limited = numbers.stream()
                .filter(n -> n % 2 == 0)
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("First 3 even numbers: " + limited);
    }
    
    // 1. Sorting a list
    public static void sortNumbers() {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2, 9, 7);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted numbers: " + sortedNumbers);
    }

    // 2. Getting distinct values from a list
    public static void distinctValues() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers);
    }

    // 3. Getting the first value
    public static void firstValue() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Integer first = numbers.stream().findFirst().orElse(null);
        System.out.println("First value: " + first);
    }

    // 4. Getting the last value
    public static void lastValue() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Integer last = numbers.isEmpty() ? null : numbers.get(numbers.size() - 1);
        System.out.println("Last value: " + last);
    }

    // 5. Getting the second last value
    public static void secondLastValue() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Integer secondLast = numbers.size() < 2 ? null : numbers.get(numbers.size() - 2);
        System.out.println("Second last value: " + secondLast);
    }

    // 6. Getting the second value
    public static void secondValue() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Integer second = numbers.size() < 2 ? null : numbers.get(1);
        System.out.println("Second value: " + second);
    }
    
    // 1. Sorting a list in ascending order
    public static void sortNumbersAsc() {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2, 9, 7);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Sorted numbers (Asc): " + sortedNumbers);
    }

    // 2. Sorting a list in descending order
    public static void sortNumbersDesc() {
        List<Integer> numbers = Arrays.asList(5, 3, 8, 1, 2, 9, 7);
        List<Integer> sortedNumbers = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Sorted numbers (Desc): " + sortedNumbers);
    }

    // Person class used for filtering objects
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return name + " (" + age + ")";
        }
    }
}

