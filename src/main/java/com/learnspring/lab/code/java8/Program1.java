package com.learnspring.lab.code.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Program1 {
	
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
		names.forEach(name -> System.out.println(name));
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
		List<Integer> evens = numbers.stream()
		.filter(n -> n % 2 == 0)
		.collect(Collectors.toList());
		System.out.println(evens); // Output: [2, 4, 6]
		
		
		Optional<String> optional = Optional.ofNullable("asi");
		String value = optional.get();  // Throws NoSuchElementException
		
		System.out.println(optional);

	}
	
	

}
