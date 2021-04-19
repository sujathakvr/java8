package com.ontarioinc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StreamTest {
	
	public static void methodReference() {
		List<Employee> list = new ArrayList<>();
        list.add(new Employee("Dave", 23, 20000));
        list.add(new Employee("Joe", 18, 40000));
        list.add(new Employee("Ryan", 54, 100000));
        list.add(new Employee("Iyan", 5, 34000));
        list.add(new Employee("Ray", 63, 54000));
        // Code without using method reference
        
        System.out.println(list.stream().mapToInt(employee -> employee.getSalary()).sum());
        
        // code with method reference
        System.out.println(list.stream().mapToInt(Employee::getSalary).sum());
        
	}
	
	public static void slice() {
		List<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("China");
        countries.add("India");
        countries.add("UK");
        countries.add("China");
        
        //distinct countries
        
        // code with method reference
        countries.stream().distinct().forEach(System.out::println);
        Collections.sort(countries, (c1, c2) -> c1.compareTo(c2));
        countries.stream().forEach(System.out::println);
        
	}
	
	public static void flatMapDemo() {
		List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j","k","l"));
        // map() is used to convert each name to upper case.
        // Note: The map() method does not modify the original list.
        
        list.stream().flatMap(s -> s.stream()).filter(x -> x.equals("a")).forEach(System.out::println);
	}
	
	public static void mapDemo() {
		List<String> list = new ArrayList<>();
        list.add("Dave");
        list.add("Joe");
        list.add("Ryan");
        list.add("Iyan");
        list.add("Ray");
        // map() is used to convert each name to upper case.
        // Note: The map() method does not modify the original list.
        
        //print all the names in uppercase
        list.stream().map(name -> name.toUpperCase()).forEach(System.out::println);
	}
	
	public static void main(String[] args) {
	      mapDemo();  
	      flatMapDemo();
	      methodReference();
	      slice();
	}
}
