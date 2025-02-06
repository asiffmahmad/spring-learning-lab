package com.learnspring.lab.code.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class StringOperations {

    public static void main(String[] args) {
        reverseString("hello");
        countCharacterOccurrences("banana", 'a');
        checkAnagram("listen", "silent");
        removeDuplicateCharacters("programming");
        firstNonRepeatingCharacter("swiss");
        checkIfStringContainsOnlyDigits("12345");
        findLongestWord("The quick brown fox jumps over the lazy dog");
        replaceSpacesWithEncoding("hello world");
        checkPalindrome("madam");
        extractNumbersFromString("abc123xyz456");
        convertToTitleCase("hello world");
        findDuplicateWords("this is a test this is only a test");
        customSplit("apple,banana,orange", ",");
    }

    // Reverse String
    public static void reverseString(String input) {
        // Java 8+
        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Reversed String (Java 8+): " + reversed);

        // Pre-Java 8
        char[] charArray = input.toCharArray();
        String result = "";
        for (int i = charArray.length - 1; i >= 0; i--) {
            result += charArray[i];
        }
        System.out.println("Reversed String (Pre-Java 8): " + result);
    }

    // Count Character Occurrences
    public static void countCharacterOccurrences(String input, char ch) {
        // Java 8+
        long count = input.chars().filter(c -> c == ch).count();
        System.out.println("Occurrences (Java 8+): " + count);

        // Pre-Java 8
        int counter = 0;
        for (char c : input.toCharArray()) {
            if (c == ch) counter++;
        }
        System.out.println("Occurrences (Pre-Java 8): " + counter);
    }

    // Check Anagram
    public static void checkAnagram(String str1, String str2) {
        // Java 8+
        boolean isAnagram = Arrays.equals(str1.chars().sorted().toArray(), str2.chars().sorted().toArray());
        System.out.println("Are Anagrams (Java 8+): " + isAnagram);

        // Pre-Java 8
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        System.out.println("Are Anagrams (Pre-Java 8): " + Arrays.equals(arr1, arr2));
    }

    // Remove Duplicate Characters
    public static void removeDuplicateCharacters(String input) {
        // Java 8+
        String result = input.chars()
                .distinct()
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("Without Duplicates (Java 8+): " + result);

        // Pre-Java 8
        StringBuilder sb = new StringBuilder();
        Set<Character> seen = new HashSet<>();
        for (char c : input.toCharArray()) {
            if (!seen.contains(c)) {
                seen.add(c);
                sb.append(c);
            }
        }
        System.out.println("Without Duplicates (Pre-Java 8): " + sb.toString());
    }

    // Find First Non-Repeating Character
    public static void firstNonRepeatingCharacter(String input) {
        // Java 8+
        Character result = input.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> input.indexOf(c) == input.lastIndexOf(c))
                .findFirst()
                .orElse(null);
        System.out.println("First Non-Repeating (Java 8+): " + result);

        // Pre-Java 8
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                System.out.println("First Non-Repeating (Pre-Java 8): " + entry.getKey());
                break;
            }
        }
    }

    // Check if String Contains Only Digits
    public static void checkIfStringContainsOnlyDigits(String input) {
        // Java 8+
        boolean isNumeric = input.chars().allMatch(Character::isDigit);
        System.out.println("Contains Only Digits (Java 8+): " + isNumeric);

        // Pre-Java 8
        boolean isNumber = true;
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                isNumber = false;
                break;
            }
        }
        System.out.println("Contains Only Digits (Pre-Java 8): " + isNumber);
    }

    // Custom Split Method
    public static void customSplit(String input, String delimiter) {
        // Java 8+
        List<String> splitList = Arrays.stream(input.split(delimiter)).collect(Collectors.toList());
        System.out.println("Split (Java 8+): " + splitList);

        // Pre-Java 8
        List<String> result = new ArrayList<>();
        int start = 0, index;
        while ((index = input.indexOf(delimiter, start)) != -1) {
            result.add(input.substring(start, index));
            start = index + delimiter.length();
        }
        result.add(input.substring(start));
        System.out.println("Split (Pre-Java 8): " + result);
    }
    
    // Find Longest Word
    public static void findLongestWord(String sentence) {
        // Java 8+
        String longest = Arrays.stream(sentence.split(" "))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println("Longest Word (Java 8+): " + longest);

        // Pre-Java 8
        String[] words = sentence.split(" ");
        String longestWord = "";
        for (String word : words) {
            if (word.length() > longestWord.length()) {
                longestWord = word;
            }
        }
        System.out.println("Longest Word (Pre-Java 8): " + longestWord);
    }

    // Replace Spaces with Encoding
    public static void replaceSpacesWithEncoding(String input) {
        // Java 8+
        String encoded = input.replace(" ", "%20");
        System.out.println("Encoded String (Java 8+): " + encoded);

        // Pre-Java 8
        System.out.println("Encoded String (Pre-Java 8): " + input.replaceAll(" ", "%20"));
    }

    // Check Palindrome
    public static void checkPalindrome(String input) {
        // Java 8+
        boolean isPalindrome = new StringBuilder(input).reverse().toString().equals(input);
        System.out.println("Is Palindrome (Java 8+): " + isPalindrome);

        // Pre-Java 8
        int n = input.length();
        boolean palindrome = true;
        for (int i = 0; i < n / 2; i++) {
            if (input.charAt(i) != input.charAt(n - 1 - i)) {
                palindrome = false;
                break;
            }
        }
        System.out.println("Is Palindrome (Pre-Java 8): " + palindrome);
    }

    // Extract Numbers from String
    public static void extractNumbersFromString(String input) {
        // Java 8+
        String numbers = input.replaceAll("\\D", "");
        System.out.println("Extracted Numbers (Java 8+): " + numbers);

        // Pre-Java 8
        StringBuilder digits = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }
        System.out.println("Extracted Numbers (Pre-Java 8): " + digits.toString());
    }

    // Convert to Title Case
    public static void convertToTitleCase(String input) {
        // Java 8+
        String titleCase = Arrays.stream(input.split(" "))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
        System.out.println("Title Case (Java 8+): " + titleCase);

        // Pre-Java 8
        StringBuilder sb = new StringBuilder();
        String[] words = input.split(" ");
        for (String word : words) {
            sb.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
        }
        System.out.println("Title Case (Pre-Java 8): " + sb.toString().trim());
    }

    // Find Duplicate Words
    public static void findDuplicateWords(String input) {
        // Java 8+
        Map<String, Long> wordCount = Arrays.stream(input.split(" "))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        wordCount.forEach((word, count) -> {
            if (count > 1) System.out.println("Duplicate Word (Java 8+): " + word);
        });

        // Pre-Java 8
        Map<String, Integer> wordMap = new HashMap<>();
        String[] words = input.split(" ");
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate Word (Pre-Java 8): " + entry.getKey());
            }
        }
    }
}

