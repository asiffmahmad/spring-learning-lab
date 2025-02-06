package com.learnspring.lab.code.java8;

import java.util.stream.IntStream;

public class PatternPrinting {
    public static void main(String[] args) {
        squarePattern(5);
        rightTrianglePattern(5);
        pyramidPattern(5);
        invertedPyramidPattern(5);
        diamondPattern(5);
       // leftTrianglePattern(5);
       // hourglassPattern(5);
    }

    // Square Pattern
    public static void squarePattern(int n) {
        System.out.println("Square Pattern:");
        /* Sample Output for n = 5:
        * * * * *
        * * * * *
        * * * * *
        * * * * *
        * * * * *
        */
        
        // Java 8+
        IntStream.range(0, n).forEach(i -> System.out.println("* ".repeat(n)));
        
        // Pre-Java 8
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Right Triangle Pattern
    public static void rightTrianglePattern(int n) {
        System.out.println("Right Triangle Pattern:");
        /* Sample Output for n = 5:
        *
        * *
        * * *
        * * * *
        * * * * *
        */
        
        // Java 8+
        IntStream.rangeClosed(1, n).forEach(i -> System.out.println("* ".repeat(i)));
        
        // Pre-Java 8
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Pyramid Pattern
    public static void pyramidPattern(int n) {
        System.out.println("Pyramid Pattern:");
        /* Sample Output for n = 5:
            *
           * *
          * * *
         * * * *
        * * * * *
        */
        
        // Java 8+
        IntStream.range(0, n).forEach(i -> System.out.println(" ".repeat(n - i - 1) + "* ".repeat(i + 1)));
        
        // Pre-Java 8
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Inverted Pyramid Pattern
    public static void invertedPyramidPattern(int n) {
        System.out.println("Inverted Pyramid Pattern:");
        /* Sample Output for n = 5:
        * * * * *
         * * * *
          * * *
           * *
            *
        */
        
        // Java 8+
        IntStream.range(0, n).forEach(i -> System.out.println(" ".repeat(i) + "* ".repeat(n - i)));
        
        // Pre-Java 8
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    // Diamond Pattern
    public static void diamondPattern(int n) {
        System.out.println("Diamond Pattern:");
        /* Sample Output for n = 5:
            *
           * *
          * * *
         * * * *
        * * * * *
         * * * *
          * * *
           * *
            *
        */
        
        // Java 8+
        IntStream.range(0, n).forEach(i -> System.out.println(" ".repeat(n - i - 1) + "* ".repeat(i + 1)));
        IntStream.range(0, n - 1).forEach(i -> System.out.println(" ".repeat(i + 1) + "* ".repeat(n - i - 1)));
        
        // Pre-Java 8
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

