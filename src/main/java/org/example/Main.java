package org.example;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        //Color favColor= Color.BLACK;
        DaysOfWeek day = DaysOfWeek.THURSDAY;
        System.out.println("Thursday is a: " + day.getDayType());
        Person person1 = new Person("1", "Sergej", DaysOfWeek.FRIDAY);
        Person person2 = new Person("2", "Sebastian", DaysOfWeek.MONDAY);
        Person person3 = new Person("3", "Marianna", DaysOfWeek.SUNDAY);
        HashMap<String, Person> myPersonshMap = new HashMap<String, Person>() {{
            put("1", person1);
            put("2", person2);
            put("3", person3);
        }};
        PersonRepository persons = new PersonRepository();
        persons.setPersons(myPersonshMap);
        if (persons.getPersonById("3").isPresent()) {
            System.out.println("Lieblingstag: " + persons.getPersonById("3").get().favoriteDay());
        } else {
            System.out.println("Person nicht gefunden ");
        }

         /*
    STREAMS
     */

    /*
    1.Filter a list of numbers and only output the even numbers.
     */
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(numbers);
        numbers.stream().filter(number -> number % 2 == 0)
                .forEach(System.out::println);
/*
2: Use 'map' and double each number in the list.
 */
        numbers.stream().map(number -> number * 2)
                .forEach(System.out::println);

    /*
    3: Sort the list in ascending order
     */
        numbers.stream().sorted().forEach(System.out::println);

    /*
    4: Perform a 'reduce' operation to calculate the sum of all numbers in the list.
         */
        int sum = numbers.stream().reduce(0, (a, number) -> a + number);
        System.out.println("Die Summe der Liste:" + sum);

        List<Integer> newList = numbers.stream().map(number -> number * number).collect(Collectors.toList());
        System.out.println(newList);
        try {
            Files.lines(Path.of("students.csv")).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //remove header
        try {
            Files.lines(Path.of("students.csv")).skip(1).forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //Convert each line ito the class Student
        try {
           List<Student> students= Files.lines(Path.of("students.csv")).skip(1)
                    .map(line->{
                        String[] parts=line.split(",");
                        return new Student(
                                parts[0],
                                parts[1],
                                Integer.parseInt(parts[2]),
                                Integer.parseInt(parts[3]));
                    })
                    .collect(Collectors.toList());
            System.out.println("Die Liste der Studenten : "+students.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}