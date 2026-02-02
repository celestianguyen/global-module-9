package exercises;

import java.util.Scanner;

/*
Using One-Dimensional Arrays to Manage Employee Information
Problem
Use one-dimensional arrays to process the input of information for n employees, based on the previous employee information exercise (full name, age, gender, basic salary, and university graduation GPA (on a 10-point scale))
Hint:
Each type of information (for example, full name) is stored in a separate array.
The information of one employee is identified by the same index position in all arrays.
 */
public class Exercise02 {
    static Scanner scanner = new Scanner(System.in);
    private static String[] fullName;
    private static int[] age;
    private static String[] gender;
    private static double[] basicSalary;
    private static double[] gpa;

    public static void main(String[] args) {

        int n = readInt(scanner,"Please enter the number of employees whose info you wanna store: ");
        fullName = new String[n];
        age = new int[n];
        gender = new String[n];
        basicSalary = new double[n];
        gpa = new double[n];
        for (int i = 0; i < n; i++){
            System.out.println("\n--Input employee " + (i + 1) + " --");
            inputEmployeeInfo(i);
        }

        System.out.println("\n--- Employee List ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1));
            printEmployeeInfo(i);
        }

    }
    private static void inputEmployeeInfo(int i){
        fullName[i] = readNonEmptyLine("Enter employee's name: ");
        age[i] = readInt(scanner, "Please enter employee " + (i + 1) + " age: ");
        gender[i] = readGender("Enter employee's gender: ");
        basicSalary[i] = readDouble("Please enter employee's basic salary: ");
        gpa[i] = readDouble("Please enter employee's gpa on a 10-point scale: ");

    }
    private static void printEmployeeInfo(int i){
        System.out.println("Full name: " + fullName[i]);
        System.out.println("Age: " + age[i]);
        System.out.println("Gender: " + gender[i]);
        System.out.println("Salary: " + formatMoney(basicSalary[i]));
        System.out.println("GPA: " + String.format("%.2f", gpa[i]));
    }

    private static String readGender(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = readNonEmptyLine(prompt);
            if (s.equalsIgnoreCase("M") || s.equalsIgnoreCase("Male")) return "Male";
            if (s.equalsIgnoreCase("F") || s.equalsIgnoreCase("Female")) return "Female";
            if (s.equalsIgnoreCase("Other") || s.equalsIgnoreCase("O")) return "Other";
            System.out.println("  Enter M, F, or Other.");
        }
    }

    private static String formatMoney(double v) {
        return String.format("%,.2f", v);
    }
    private static String readNonEmptyLine(String target){
        while (true) {
            System.out.print(target);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("  Value cannot be empty.");
        }
    }
    private static double readDouble(String prompt){
        while (true){
            System.out.print(prompt);
            String d = scanner.nextLine();
            try{
                return Double.parseDouble(d);

            } catch (NumberFormatException e){
                System.out.println("Invalid! Value cannot ve empty. Please enter a double.");
            }
        }

    }
    private static int readInt(Scanner scanner, String prompt){
        while (true){
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e){
                System.out.println("Invalid input! Please enter again.");
            }
        }
    }

}
