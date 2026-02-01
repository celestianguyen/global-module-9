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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = readInt(scanner,"Please enter the number of employees whose info you wanna store: ");

        String[] fullName = new String[n];
        int[] age = new int[n];
        String[] gender = new String[n];
        double[] basicSalary = new double[n];
        double[] gpa = new double[n];

        for (int i = 0; i < n; i++){
            System.out.println("\n--Input employee " + (i + 1) + " --");
            inputEmployeeInfo(scanner, i, fullName, age, gender, basicSalary, gpa);
        }

        System.out.println("\n--- Employee List ---");
        for (int i = 0; i < n; i++) {
            System.out.println("Employee #" + (i + 1));
            System.out.println(" Full name: " + fullName[i]);
            System.out.println(" Age: " + age[i]);
            System.out.println(" Gender: " + gender[i]);
            System.out.println(" Salary: " + formatMoney(basicSalary[i]));
            System.out.println(" GPA: " + String.format("%.2f", gpa[i]));
        }

    }
    private static void inputEmployeeInfo(Scanner scanner, int i, String[] fullName, int[] age, String[] gender, double[] basicSalary, double[] gpa){
        fullName[i] = readNonEmptyLine(scanner, "Enter employee's name. Please enter name(s) again!");
        age[i] = readInt(scanner, "Please enter employee " + (i + 1) + " age: ");
        gender[i] = readNonEmptyLine();
        basicSalary[i] = readDouble();
        gpa[i] = readDouble();

    }
    private static void printEmployeeInfo(int i,String[] fullName, double age, String[] gender, double[] basicSalary, double[] gpa){
        System.out.println("Employee #" + (i + 1));
        System.out.println("Full name: " + fullName[i]);
        System.out.println("Age: " + age[i]);
        System.out.println("Gender: " + gender[i]);
        System.out.println("Salary: " + formatMoney(basicSalary[i]));
        System.out.println("GPA: " + String.format("%.2f", gpa[i]));
    }

    private static String readGender(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            if (s.equalsIgnoreCase("M") || s.equalsIgnoreCase("Male")) return "Male";
            if (s.equalsIgnoreCase("F") || s.equalsIgnoreCase("Female")) return "Female";
            if (s.equalsIgnoreCase("Other") || s.equalsIgnoreCase("O")) return "Other";
            System.out.println("  Enter M, F, or Other.");
        }
    }

    private static String formatMoney(double v) {
        return String.format("%,.2f", v);
    }
    private static void readNonEmptyLine(){
        while (true) {
            System.out.print(Scanner scanner, String prompt);
            String s = scanner.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("  Value cannot be empty.");
        }
    };
    private static double readDouble(Scanner scanner, String prompt){
        while (true){
            System.out.print(prompt);
            double d = scanner.nextDouble();
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
