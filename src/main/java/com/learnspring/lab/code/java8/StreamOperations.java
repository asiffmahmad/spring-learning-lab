package com.learnspring.lab.code.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;
import java.util.Optional;

public class StreamOperations {

    public static void main(String[] args) {
        sortNumbersAsc();
        sortNumbersDesc();
        distinctValues();
        firstValue();
        lastValue();
        secondLastValue();
        secondValue();
        filterEvenNumbers();
        mapToSquare();
        reduceSum();
        anyMatchExample();
        allMatchExample();
        noneMatchExample();
        sumUsingMapToInt();
        groupByEvenOdd();
        partitionByEvenOdd();
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

    // 3. Getting distinct values from a list
    public static void distinctValues() {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4, 5);
        List<Integer> distinctNumbers = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Distinct numbers: " + distinctNumbers);
    }

    // 4. Getting the first value
    public static void firstValue() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Integer first = numbers.stream().findFirst().orElse(null);
        System.out.println("First value: " + first);
    }

    // 5. Getting the last value
    public static void lastValue() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Integer last = numbers.isEmpty() ? null : numbers.get(numbers.size() - 1);
        System.out.println("Last value: " + last);
    }

    // 6. Getting the second last value
    public static void secondLastValue() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Integer secondLast = numbers.size() < 2 ? null : numbers.get(numbers.size() - 2);
        System.out.println("Second last value: " + secondLast);
    }

    // 7. Getting the second value
    public static void secondValue() {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);
        Integer second = numbers.size() < 2 ? null : numbers.get(1);
        System.out.println("Second value: " + second);
    }

    // 8. Filtering even numbers
    public static void filterEvenNumbers() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = numbers.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println("Even numbers: " + evens);
    }

    // 9. Mapping numbers to their squares
    public static void mapToSquare() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        List<Integer> squares = numbers.stream().map(n -> n * n).collect(Collectors.toList());
        System.out.println("Squared numbers: " + squares);
    }

    // 10. Reducing to sum all numbers
    public static void reduceSum() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum: " + sum);
    }

    // 11. Checking if any number is greater than 3
    public static void anyMatchExample() {
        boolean result = Arrays.asList(1, 2, 3, 4).stream().anyMatch(n -> n > 3);
        System.out.println("Any number greater than 3? " + result);
    }

    // 12. Checking if all numbers are positive
    public static void allMatchExample() {
        boolean result = Arrays.asList(1, 2, 3, 4).stream().allMatch(n -> n > 0);
        System.out.println("All numbers positive? " + result);
    }

    // 13. Checking if no number is negative
    public static void noneMatchExample() {
        boolean result = Arrays.asList(1, 2, 3, 4).stream().noneMatch(n -> n < 0);
        System.out.println("No negative numbers? " + result);
    }

    // 14. Summing values using mapToInt
    public static void sumUsingMapToInt() {
        int sum = Arrays.asList(1, 2, 3, 4).stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum using mapToInt: " + sum);
    }

    // 15. Grouping numbers into even and odd
    public static void groupByEvenOdd() {
        Map<Boolean, List<Integer>> grouped = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .collect(Collectors.groupingBy(n -> n % 2 == 0));
        System.out.println("Grouped by even/odd: " + grouped);
    }

    // 16. Partitioning numbers into even and odd
    public static void partitionByEvenOdd() {
        Map<Boolean, List<Integer>> partitioned = Arrays.asList(1, 2, 3, 4, 5, 6).stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Partitioned by even/odd: " + partitioned);
    }
}

