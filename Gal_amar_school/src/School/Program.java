package School;

import School.models.Person;
import School.models.Score;
import School.models.Student;
import School.models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        System.out.println("***************************************");
        System.out.println("Welcome to Gal Amar School");
        System.out.println("***************************************");

        int userChoice = -1;
        Teacher teacher;
        Student student;
        while (userChoice != 0) {
            userChoice = getUserChoice();
            switch (userChoice) {
                case 1:
                    teacher = new Teacher();
                    teacher.input();
                    people.add(teacher);
                    System.out.println("*****************");
                    System.out.println("New teacher stored:  " + teacher);
                    System.out.println("*****************");
                    break;
                case 2:
                    student = new Student();
                    student.input();
                    people.add(student);
                    System.out.println("*****************");
                    System.out.println("New student stored: " + student);
                    System.out.println("*****************");
                    break;
                case 3:
                    for (Person person : people) {
                        System.out.println(person);
                    }
                    break;
                case 4:
                    for (Person person : people) {
                        if (person instanceof Teacher) {
                            System.out.println(person.toString());
                        }
                    }
                    break;
                case 5:
                    for (Person person : people) {
                        if (person instanceof Student) {
                            System.out.println(person.toString());
                        }
                    }
                    break;
                case 6:
                    printEntity(people, Teacher.class);
                    break;
                case 7:
                    student = (Student) printEntity(people, Student.class);
                    if (student != null) {
                        String userChoiceForStudent = "";
                        while (!userChoiceForStudent.equals("E")) {
                            printStudentMenu();
                            userChoiceForStudent = scanner.next();
                            List<Score> studentScores = student.getScores();
                            switch (userChoiceForStudent.toUpperCase()) {
                                case "A":
                                    if (!studentScores.isEmpty()) {
                                        for (Score score : studentScores) {
                                            System.out.println(score);
                                        }
                                    } else {
                                        System.out.println("No courses yet");
                                    }
                                    break;
                                case "B":
                                    System.out.print("Course name: ");
                                    String courseName = scanner.next();
                                    System.out.print("Score Score: ");
                                    int courseScore = scanner.nextInt();
                                    Score score = new Score(courseName, courseScore);
                                    studentScores.add(score);
                                    System.out.println("New data stored: " + score);
                                    break;
                                case "C":
                                    System.out.println("Student's average score: " + student.getAverageScore());
                                    break;
                                case "D":
                                    if (!studentScores.isEmpty()) {
                                        System.out.println("Choose course index to remove: ");
                                        for (int i = 0; i < studentScores.size(); i++) {
                                            Score scoreToPrint = studentScores.get(i);
                                            System.out.println("***** index " + i + ": *****" + "\n"
                                                    + "course name: " + scoreToPrint.getCourse() + "\n"
                                                    + "course score: " + scoreToPrint.getValue() + "\n"
                                            );
                                        }
                                        System.out.print("Your choice: ");
                                        int scoreIndex = scanner.nextInt();
                                        Score scoreToRemove = studentScores.get(scoreIndex);
                                        studentScores.remove(scoreIndex);
                                        System.out.println("*******************");
                                        System.out.printf("Successfully removed %s course by index: %d from student's scores%n",
                                                scoreToRemove.getCourse(), scoreIndex);
                                        System.out.println("*******************");
                                    } else {
                                        System.out.println("no available courses to remove");
                                    }
                                    break;
                                case "E":
                                    break;
                                default:
                                    System.out.println("'ERROR' - please chose from the list");
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.print("Please enter minimum range: ");
                    double minimalAverageScore = scanner.nextDouble();
                    System.out.print("Please enter maximum range: ");
                    double maximalAverageScore = scanner.nextDouble();
                    for (Person person : people) {
                        if (person instanceof Student) {
                            double studentAverageScore = ((Student) person).getAverageScore();
                            if (studentAverageScore >= minimalAverageScore && studentAverageScore <= maximalAverageScore) {
                                System.out.println(person);
                            }
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("'ERROR' - please chose from the list");
            }
        }
    }

    private static void printMenu() {
        System.out.println();
        System.out.println("Please choose one from the menu: \n" +
                "1 - Add teacher\n" +
                "2 - Add student\n" +
                "3 - Show All People\n" +
                "4 - Show All Teachers\n" +
                "5 - Show All Students\n" +
                "6 - Print Teacher By ID Number\n" +
                "7 - Show Student By ID and check Scores\n" +
                "8 - Show students by score range\n" +
                "0 - Quit"
        );
        System.out.print("Your choice: ");
    }

    private static void printStudentMenu() {
        System.out.println();
        System.out.println("Please choose one from the menu: \n" +
                "A - Show all scores\n" +
                "B - ADD new course and score\n" +
                "C - Show average scores\n" +
                "D - Remove score by index\n" +
                "E - Return to the main menu"
        );
        System.out.print("Your choice: ");
    }

    private static Person printEntity(List<Person> people, Class<?> clazz) {
        String entity = clazz.getSimpleName();
        System.out.print("Please enter " + entity.toLowerCase() + " ID: ");
        String id = scanner.next();
        Person foundPerson = null;
        for (Person person : people) {
            if (person.getId().equals(id)) {
                foundPerson = person;
                if (person.getClass().equals(clazz)) {
                    System.out.println(person.toString());
                } else {
                    System.out.println("this is not a " + entity.toLowerCase());
                }
            }
        }
        if (foundPerson == null) {
            System.out.println("doesn't exist");
        }
        return foundPerson;
    }

    private static int getUserChoice() {
        printMenu();
        return scanner.nextInt();
    }
}
