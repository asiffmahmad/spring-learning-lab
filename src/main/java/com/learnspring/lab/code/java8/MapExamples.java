package com.learnspring.lab.code.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.LinkedHashMap;
import java.util.function.Function;

public class MapExamples {

    public static void main(String[] args) {
        mapToKeyValuePairs();
        mapToFrequencyCount();
        mapToUppercaseKeyValuePairs();
        mapToIndexPosition();
        mapToSortedKeyValuePairs();
        mapToGroupByFirstLetter();
    }

    // 1. Mapping a list of words to a key-value pair (word -> length)
    public static void mapToKeyValuePairs() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Map<String, Integer> wordLengthMap = words.stream()
                .collect(Collectors.toMap(word -> word, String::length));
        System.out.println("Word-Length Map: " + wordLengthMap);
    }

    // 2. Mapping a list to a frequency count (word -> count)
    public static void mapToFrequencyCount() {
        List<String> words = Arrays.asList("apple", "banana", "apple", "cherry", "banana", "banana");
        Map<String, Long> frequencyMap = words.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Word Frequency Map: " + frequencyMap);
    }

    // 3. Mapping words to uppercase keys (word.upper() -> length)
    public static void mapToUppercaseKeyValuePairs() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Map<String, Integer> uppercaseWordMap = words.stream()
                .collect(Collectors.toMap(word -> word.toUpperCase(), String::length));
        System.out.println("Uppercase Word-Length Map: " + uppercaseWordMap);
    }

    // 4. Mapping words to their index positions in the list
    public static void mapToIndexPosition() {
        List<String> words = Arrays.asList("apple", "banana", "cherry");
        Map<String, Integer> indexMap = new LinkedHashMap<>();
        for (int i = 0; i < words.size(); i++) {
            indexMap.put(words.get(i), i);
        }
        System.out.println("Word Index Map: " + indexMap);
    }

    // 5. Mapping words to sorted key-value pairs (sorted by key)
    public static void mapToSortedKeyValuePairs() {
        List<String> words = Arrays.asList("banana", "apple", "cherry");
        Map<String, Integer> sortedMap = words.stream()
                .sorted()
                .collect(Collectors.toMap(word -> word, String::length, (oldVal, newVal) -> oldVal, LinkedHashMap::new));
        System.out.println("Sorted Word-Length Map: " + sortedMap);
    }

    // 6. Mapping words to grouped first letters (first letter -> words)
    public static void mapToGroupByFirstLetter() {
        List<String> words = Arrays.asList("apple", "banana", "avocado", "cherry", "blueberry");
        Map<Character, List<String>> groupedMap = words.stream()
                .collect(Collectors.groupingBy(word -> word.charAt(0)));
        System.out.println("Grouped by First Letter: " + groupedMap);
    }
}
