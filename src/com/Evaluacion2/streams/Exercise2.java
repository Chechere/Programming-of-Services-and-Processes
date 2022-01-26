package com.Evaluacion2.streams;

import java.util.*;

public class Exercise2 {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<Person>();

        people.add(new Person("John", 50));
        people.add(new Person("May", 12));
        people.add(new Person("Tiff", 23));
        people.add(new Person("Azul", 15));
        people.add(new Person("Samatha", 67));

        //Convert and show all names into uppercase.
        people  .stream()
                .map(person -> person.getName()
                                     .toUpperCase())
                .forEach(System.out::println);
        System.out.println();

        //Show all names with length less than 4.
        people  .stream()
                .filter(person -> person.getName()
                                        .length() < 4)
                .forEach(person -> System.out.println(person.getName()));
        System.out.println();

        //Get age of the oldest person.
        int max = people.stream().mapToInt(Person::getAge).max().getAsInt();
        System.out.println("Elder: " + max + "\n");

        double avg = people.stream().mapToInt(Person::getAge).average().orElse(-1);
        int min = people.stream().mapToInt(Person::getAge).min().getAsInt();
        int amount = people.size();

        System.out.printf("Average age: %.2f; Min age: %d; Max age: %d; Amount: %d.", avg, min, max, amount);
    }
}

class Person {
    private String name;
    private int age;

    public Person (String name, int age) {
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