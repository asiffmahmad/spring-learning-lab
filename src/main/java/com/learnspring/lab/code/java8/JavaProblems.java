package com.learnspring.lab.code.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaProblems {

    // Number-related methods
    public static String checkOddEven(int number) {
        return number % 2 == 0 ? number + " is even." : number + " is odd.";
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static List<Integer> generateFibonacci(int terms) {
        List<Integer> series = new ArrayList<>();
        int a = 0, b = 1;
        for (int i = 0; i < terms; i++) {
            series.add(a);
            int next = a + b;
            a = b;
            b = next;
        }
        return series;
    }

    public static int[] swapNumbers(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        return new int[]{a, b};
    }

    public static int factorial(int number) {
        if (number < 0) throw new IllegalArgumentException("Number must be non-negative.");
        int result = 1;
        for (int i = 2; i <= number; i++) {
            result *= i;
        }
        return result;
    }

    public static int reverseNumber(int number) {
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }
        return reversed;
    }

    public static boolean isArmstrong(int number) {
        int original = number;
        int sum = 0;
        int digits = (int) (Math.log10(number) + 1);
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }
        return sum == original;
    }

    public static int countDigits(int number) {
        if (number == 0) return 1;
        int count = 0;
        number = Math.abs(number);
        while (number > 0) {
            number /= 10;
            count++;
        }
        return count;
    }

    public static boolean isPalindromeNumber(int number) {
        return number == reverseNumber(number);
    }

    public static int sumOfDigits(int number) {
        number = Math.abs(number);
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // String-related methods
    public static String reverseString(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static String reverseEachWord(String input) {
        return Arrays.stream(input.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString())
                .collect(Collectors.joining(" "));
    }

    public static Map<Character, Integer> findDuplicateChars(String input) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : input.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        charCount.entrySet().removeIf(entry -> entry.getValue() == 1);
        return charCount;
    }

    public static Map<String, Integer> countWordOccurrences(String input) {
        return Arrays.stream(input.split(" "))
                .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum));
    }

    public static int countWords(String s) {
        return (int) Arrays.stream(s.trim().split("\\s+")).count();
    }

    public static List<String> generatePermutations(String str) {
        List<String> permutations = new ArrayList<>();
        permute("", str, permutations);
        return permutations;
    }

    private static void permute(String prefix, String suffix, List<String> permutations) {
        if (suffix.isEmpty()) {
            permutations.add(prefix);
            return;
        }
        for (int i = 0; i < suffix.length(); i++) {
            permute(prefix + suffix.charAt(i), 
                    suffix.substring(0, i) + suffix.substring(i + 1), 
                    permutations);
        }
    }

    public static boolean isPalindromeString(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    public static boolean areAnagrams(String str1, String str2) {
        return Arrays.equals(str1.chars().sorted().toArray(),
                            str2.chars().sorted().toArray());
    }

    public static int[] countVowelsConsonants(String str) {
        str = str.toLowerCase();
        int vowels = 0, consonants = 0;
        for (char c : str.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) vowels++;
            else if (Character.isLetter(c)) consonants++;
        }
        return new int[]{vowels, consonants};
    }

    public static String getUniqueChars(String input) {
        return input.chars()
                .distinct()
                .collect(StringBuilder::new, 
                        StringBuilder::appendCodePoint, 
                        StringBuilder::append)
                .toString();
    }

    public static String getEvenIndexedChars(String input) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i += 2) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }

    public static String removeSpaces(String str) {
        return str.replaceAll("\\s+", "");
    }

    public static String doubleCharacters(String str) {
        return str.chars()
                .mapToObj(c -> "" + (char)c + (char)c)
                .collect(Collectors.joining());
    }

    public static String[] swapStrings(String str1, String str2) {
        str1 = str1 + str2;
        str2 = str1.substring(0, str1.length() - str2.length());
        str1 = str1.substring(str2.length());
        return new String[]{str1, str2};
    }

    public static String compressString(String input) {
        if (input.isEmpty()) return "";
        StringBuilder sb = new StringBuilder();
        int count = 1;
        char current = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == current) {
                count++;
            } else {
                sb.append(current).append(count);
                current = input.charAt(i);
                count = 1;
            }
        }
        return sb.append(current).append(count).toString();
    }

    public static String[] separateLettersCase(String input) {
        return new String[]{
            input.replaceAll("[^a-z]", ""),
            input.replaceAll("[^A-Z]", "")
        };
    }

    public static String[] separateAlphaNumeric(String input) {
        return new String[]{
            input.replaceAll("[^A-Za-z]", ""),
            input.replaceAll("[^0-9]", "")
        };
    }

    public static String rearrangeDigits(String input) {
        String digits = input.replaceAll("\\D", "");
        String others = input.replaceAll("\\d", "");
        return digits + others;
    }

    public static String formatZeros(String input) {
        return String.format("%011d", Long.parseLong(input));
    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, left = 0, right = 0;
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right++));
                max = Math.max(max, right - left);
            } else {
                set.remove(s.charAt(left++));
            }
        }
        return max;
    }

    // Array-related methods
    public static Set<Integer> findCommonElements(int[] arr1, int[] arr2) {
        Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
        return Arrays.stream(arr2).filter(set1::contains).boxed().collect(Collectors.toSet());
    }

    public static <T> T[] getFirstLast(ArrayList<T> list) {
        return (T[]) new Object[]{list.get(0), list.get(list.size()-1)};
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            int min = i;
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[min]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    public static int[] removeDuplicatesArray(int[] arr) {
        return Arrays.stream(arr).distinct().toArray();
    }

    public static <T> ArrayList<T> removeDuplicatesList(ArrayList<T> list) {
        return new ArrayList<>(new LinkedHashSet<>(list));
    }

    public static int findMissingNumber(int[] arr) {
        int n = arr.length + 1;
        int total = n * (n + 1) / 2;
        return total - Arrays.stream(arr).sum();
    }

    public static int[] findMinMax(int[] arr) {
        IntSummaryStatistics stats = Arrays.stream(arr).summaryStatistics();
        return new int[]{stats.getMin(), stats.getMax()};
    }

    public static int linearSearch(int[] arr, int target) {
        return IntStream.range(0, arr.length)
                .filter(i -> arr[i] == target)
                .findFirst()
                .orElse(-1);
    }

    public static int sumIntegersInArray(String[] arr) {
        return Arrays.stream(arr)
                .filter(s -> s.matches("\\d+"))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public static int[] countOddEven(int[] arr) {
        IntSummaryStatistics stats = Arrays.stream(arr)
                .map(n -> n % 2)
                .summaryStatistics();
        return new int[]{
            (int) (stats.getCount() - stats.getSum()),
            (int) stats.getSum()
        };
    }

    public static List<Integer> findNonRepeated(int[] arr) {
        return Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        // Example usage
        System.out.println(checkOddEven(5)); // 5 is odd.
        System.out.println(isPrime(7));       // true
        System.out.println(generateFibonacci(7)); // [0, 1, 1, 2, 3, 5, 8]
    }
}

class Student {
    private int id;
    private String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
