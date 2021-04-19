package com.ontarioinc;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateTest {
	
	static boolean isAgeGreaterThan18(Person p, Predicate<Person> predicate) {
		return predicate.test(p);
	}
	
	static boolean isAgeLessThan60(Person p, Predicate<Person> predicate) {
		return predicate.test(p);
	}
	
	static boolean isEligible(Person p, Predicate<Person> predicate) {
		return predicate.test(p);
	}
	
	static boolean isPersonEligibleForVoting(
		      Person person, Integer minAge, BiPredicate<Person, Integer> predicate) {
		    return predicate.test(person, minAge);
	  }
	
	public static void predicateDemo() {
		 Person person = new Person("Alex", 23);
		 Predicate<Person> ageGreaterThan18 = p -> p.getAge() > 18;
		 Predicate<Person> ageLessThan60 = p -> p.getAge() < 60;
		 Predicate<Person> combined = ageGreaterThan18.and(ageLessThan60);
		 System.out.println(isAgeGreaterThan18(person, ageGreaterThan18));
		 System.out.println(isAgeLessThan60(person, ageLessThan60));
		 
		 System.out.println(isEligible(person, combined));
	}
	
	public static void biPredicateDemo() {
		 Person person = new Person("Alex", 23);
		 
		 System.out.println(isPersonEligibleForVoting(person, 18, (p, minAge) -> {
			 return p.getAge() > minAge;
		 }));
	}
	
	public static void main(String[] args) {
		predicateDemo();  
	}
}


class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}