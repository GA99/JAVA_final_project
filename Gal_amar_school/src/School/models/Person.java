package School.models;

import School.enums.MaritalStatus;

import java.util.Scanner;

public abstract class Person {

    protected String id;
    protected String firstName;
    protected String lastName;
    protected MaritalStatus maritalStatus;
    protected Scanner scanner;

    public Person() {
        this.scanner = new Scanner(System.in);
    }

    public String getId() {
        return id;
    }

    public void input() {
        getIdFromUser();
        this.firstName = getNameFromUser("Enter firstname: ");
        this.lastName = getNameFromUser("Enter lastname: ");
        getMaritalStatusFromUser();
    }

    private void getMaritalStatusFromUser() {

        int maritalStatus;
        boolean inputScanned = false;
        while (!inputScanned) {
            try {
                System.out.print("Enter marital status (1-DIVORCED, 2-MARRIED, 3-SINGLE): ");
                maritalStatus = scanner.nextInt();
                this.maritalStatus = MaritalStatus.values()[maritalStatus - 1];
                inputScanned = true;
            } catch (Exception e) {
                System.out.println("'ERROR' - please chose from the list");
            }
        }
    }

    private String getNameFromUser(String msg) {
        String name = null;
        boolean inputScanned = false;
        while (!inputScanned) {
            try {
                System.out.print(msg);
                name = scanner.nextLine();
                for (char aChar : name.toCharArray()) {
                    if (Character.isDigit(aChar)) {
                        throw new Exception();
                    }
                }
                inputScanned = true;
            } catch (Exception e) {
                System.out.println("wrong input, name cannot be a number");
            }
        }
        return name;
    }

    private void getIdFromUser() {
        String id;
        boolean inputScanned = false;
        while (!inputScanned) {
            try {
                System.out.print("Enter id: ");
                id = scanner.nextLine();
                Integer.parseInt(id);
                this.id = id;
                inputScanned = true;
            } catch (Exception e) {
                System.out.println("wrong input, id cannot be a string");
            }
        }
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", maritalStatus=" + maritalStatus;
    }
}
