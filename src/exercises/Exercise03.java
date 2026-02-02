package exercises;

import java.util.Scanner;

/*
Processing One-Dimensional Arrays to Search Employee Information
Problem
Based on the employee management program from the previous exercise, implement the following features:
a. Find the employee with the highest average score.
b. Find an employee by full name (exact match).
c. Find employees by full name (partial / flexible search).
Example:
When the user enters part of a name (for example, "Hoang"), the system displays all employees whose full name contains "Hoang"
(e.g. "Nguyen Van Hoang", "Hoang Van Thai", ...).
 */
public class Exercise03 {

    static Scanner scanner = new Scanner(System.in);
    private static String[] fullName;
    private static double[] gpa;

    public static void main(String[] args) {
        //input info ->prompt user for input (readInt()) -> separate methods to guard each input
        int n = readInt("Please enter the number of employees whose info you wanna store: ");
        fullName = new String[n];
        gpa = new double[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\n--Input employee " + (i + 1) + " --");
            inputEmployeeInfo(i);
        }
        printMenu();
        int choice = readInt("Please choose an option: ");
        switch (choice) {
            case 0:
                System.out.println("Bai ^^");
                return;
            case 1:
                System.out.println("\n--employee(s) with the highest average score--");
                for (int i = 0; i < n; i++) {
                    if (gpa[i] == highestGpa(n)) {
                        printEmployeeInfo(i);
                        System.out.println();
                    }
                }
                break;
            case 2:
                exactNameSort(n);
                break;
            case 3:
                partialNameSort(n);
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static double highestGpa(int n) {
        double max = 0;
        for (int i = 0; i < n; i++) {
            max = gpa[i];
            i++;
            if (gpa[i] > max) {
                max = gpa[i];
            } else {
                return max;
            }
        }
        return max;
    }

    private static void exactNameSort(int n) {
        String name = readNonEmptyLine("Please enter the exact full name of the employee: ");
        for (int i = 0; i < n; i++){
            if (fullName[i].equals(name)){
                System.out.println();
                System.out.print("---Employee " + name + "'s info---\n");
                printEmployeeInfo(i);
            } else {
                System.out.println("No match.");
            }
        }
    }

    private static void partialNameSort(int n) {
        String partial = readNonEmptyLine("Please enter the name of the employee: ");
        for (int i = 0; i < n; i++){
            if (fullName[i].contains(partial)){
                System.out.println();
                System.out.print("---Employee " + partial + "'s info---\n");
                printEmployeeInfo(i);
            } else {
                System.out.println("No match.");
            }
        }
    }


    private static void printMenu() {
        System.out.println("=== Operation for searching employee information ===");
        System.out.println("1) Find the employee with the highest average score.");
        System.out.println("2) Find an employee by full name (exact match).");
        System.out.println("3) Find employees by full name (partial / flexible search).");
        System.out.println("4) Reinput array");
        System.out.println("0) Exit");
    }


    private static String readNonEmptyLine(String prompt) {
        while (true) {
            System.out.print(prompt);
            String sLine = scanner.nextLine().trim();
            if (!sLine.isEmpty()) {
                return sLine;
            }
            System.out.println("Invalid input! Please enter a non-empty string of characters.");
        }
    }

    private static void inputEmployeeInfo(int i) {
        fullName[i] = readNonEmptyLine("Enter employee #" + (i + 1) + "'s name: ");
        gpa[i] = readDouble("Please enter employee #" + (i + 1) + " gpa on a 10-point scale: ");
    }

    private static void printEmployeeInfo(int i) {
        System.out.println("Full name: " + fullName[i]);
        System.out.println("GPA: " + String.format("%.2f", gpa[i]));
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String d = scanner.nextLine();
            try {
                double dParsed = Double.parseDouble(d);
                if (dParsed < 1 || dParsed > 10) {
                    System.out.println("Invalid input! Gpa score must be within the range 1.0 - 10.0.");
                    continue;
                }
                return dParsed;

            } catch (NumberFormatException e) {
                System.out.println("Invalid! Value cannot ve empty. Please enter a double.");
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String sInt = scanner.nextLine().trim();
            try {
                return Integer.parseInt(sInt);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter an integer only!");
            }
        }
    }
}


