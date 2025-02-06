package com.learnspring.lab.code.java8;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class PatternExamples {
    public static void main(String[] args) {
        matchPattern("hello123", "\\d+");
        extractMatches("abc 123 def 456", "\\d+");
        replacePattern("hello123world456", "\\d+", "#");
        validateEmail("test@example.com");
        extractDigits("abc123xyz456");
        splitStringUsingPattern("apple,banana;orange", "[;,]");
    }

    // Check if a string matches a pattern
    public static void matchPattern(String input, String regex) {
        // Java 8+
        boolean isMatch = Pattern.compile(regex).matcher(input).find();
        System.out.println("Pattern Match (Java 8+): " + isMatch);

        // Pre-Java 8
        boolean found = false;
        Matcher matcher = Pattern.compile(regex).matcher(input);
        while (matcher.find()) {
            found = true;
            break;
        }
        System.out.println("Pattern Match (Pre-Java 8): " + found);
    }

    // Extract all matches from a string
    public static void extractMatches(String input, String regex) {
        // Java 8+
        List<String> matches = Pattern.compile(regex)
                .matcher(input)
                .results()
                .map(MatchResult::group)
                .collect(Collectors.toList());
        System.out.println("Extracted Matches (Java 8+): " + matches);

        // Pre-Java 8
        List<String> results = new ArrayList<>();
        Matcher matcher = Pattern.compile(regex).matcher(input);
        while (matcher.find()) {
            results.add(matcher.group());
        }
        System.out.println("Extracted Matches (Pre-Java 8): " + results);
    }

    // Replace occurrences of a pattern
    public static void replacePattern(String input, String regex, String replacement) {
        // Java 8+
        String replaced = input.replaceAll(regex, replacement);
        System.out.println("Replaced String (Java 8+): " + replaced);

        // Pre-Java 8
        Matcher matcher = Pattern.compile(regex).matcher(input);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, replacement);
        }
        matcher.appendTail(sb);
        System.out.println("Replaced String (Pre-Java 8): " + sb.toString());
    }

    // Validate email format
    public static void validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        // Java 8+
        boolean isValid = Pattern.matches(emailRegex, email);
        System.out.println("Valid Email (Java 8+): " + isValid);

        // Pre-Java 8
        boolean valid = email.matches(emailRegex);
        System.out.println("Valid Email (Pre-Java 8): " + valid);
    }

    // Extract digits from a string
    public static void extractDigits(String input) {
        // Java 8+
        String digits = input.replaceAll("\\D", "");
        System.out.println("Extracted Digits (Java 8+): " + digits);

        // Pre-Java 8
        StringBuilder sb = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        System.out.println("Extracted Digits (Pre-Java 8): " + sb.toString());
    }

    // Split a string using a pattern
    public static void splitStringUsingPattern(String input, String regex) {
        // Java 8+
        List<String> result = Arrays.stream(input.split(regex)).collect(Collectors.toList());
        System.out.println("Split String (Java 8+): " + result);

        // Pre-Java 8
        List<String> splitList = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",; ");
        while (tokenizer.hasMoreTokens()) {
            splitList.add(tokenizer.nextToken());
        }
        System.out.println("Split String (Pre-Java 8): " + splitList);
    }
}
