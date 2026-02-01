package exercises;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] a = inputArray(sc);

            while (true) {
                printMenu();
                int choice = readInt(sc, "Choose: ");

                switch (choice) {
                    case 0:
                        {
                            System.out.println("Bai ^^");
                            return;
                        }
                    case 1:
                        outputArray(a);
                        break;
                    case 2:
                        System.out.println("Is the array all even? " + isAllEven(a));
                        break;
                    case 3:
                        System.out.println("Is the array all prime? " + isAllPrime(a));
                        break;
                    case 4:
                        System.out.println("Is the array in ascending order? " + isAscending(a));
                        break;
                    case 5:
                        System.out.println("Odd count: " + countOddElements(a));
                        break;
                    case 6:
                        System.out.println("Sum of positive odd: " + sumPositiveOdd(a));
                        break;
                    case 7:
                        System.out.println("Count divisible by 4 but not by 5: " + countDivisibleBy4NotBy5(a));
                        break;
                    case 8:
                        System.out.println("Sum of primes: " + sumPrimes(a));
                        break;
                    case 9:
                        {
                            int x = readInt(sc, "Enter x: ");
                            System.out.println("Last index of x: " + lastIndexOf(a, x));
                        }
                        break;
                    case 10:
                        {
                            int idx = firstPrimeIndex(a);
                            System.out.println(idx == -1 ? "No prime found." : "First prime index: " + idx + " (value=" + a[idx] + ")");
                        }
                    case 11:
                        {
                            Integer minPos = findMinPositive(a);
                            System.out.println(minPos == null ? "No positive number found." : "Smallest positive: " + minPos);
                        }
                        break;
                    case 12:
                        {
                            int k = readInt(sc, "Enter k: ");
                            printPositionsOf(a, k);
                        }
                        break;
                    case 13:
                        {
                            int min = findMin(a);
                            int max = findMax(a);
                            System.out.println("Min: " + min);
                            System.out.println("Max: " + max);
                        }
                        break;
                    case 14:
                        {
                            a = inputArray(sc);
                            System.out.println("Array updated.");
                        }
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
                System.out.println();
            }
        }
    }

    // 1a. Input an array
    public static int[] inputArray(Scanner sc) {
        int n = readInt(sc, "Enter n (array size > 0): ");
        while (n <= 0) n = readInt(sc, "n must be > 0. Enter again: ");

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = readInt(sc, "a[" + i + "] = ");
        }
        return a;
    }

    // 1b. Output an array
    public static void outputArray(int[] a) {
        System.out.print("Array: [");
        for (int i = 0; i < a.length; i++) {
            if (i > 0) System.out.print(", ");
            System.out.print(a[i]);
        }
        System.out.println("]");
    }

    // 2a. Check whether array contains only even numbers
    public static boolean isAllEven(int[] a) {
        for (int v : a) {
            if (v % 2 != 0) return false;
        }
        return true;
    }

    // 2b. Check whether array contains only prime numbers
    public static boolean isAllPrime(int[] a) {
        for (int v : a) {
            if (!isPrime(v)) return false;
        }
        return true;
    }

    // 2c. Check whether array is in increasing order (strictly increasing)
    public static boolean isAscending(int[] a) {
        for (int i = 1; i < a.length; i++) {
            if (a[i] <= a[i - 1]) return false;
        }
        return true;
    }

    // 3a. Count odd elements
    public static int countOddElements(int[] a) {
        int count = 0;
        for (int v : a) if (v % 2 != 0) count++;
        return count;
    }

    // 3b. Sum of positive odd numbers
    public static int sumPositiveOdd(int[] a) {
        int sum = 0;
        for (int v : a) if (v > 0 && v % 2 != 0) sum += v;
        return sum;
    }

    // 3c. Count divisible by 4 but not divisible by 5
    public static int countDivisibleBy4NotBy5(int[] a) {
        int count = 0;
        for (int v : a) {
            if (v % 4 == 0 && v % 5 != 0) count++;
        }
        return count;
    }

    // 3d. Sum of prime numbers
    public static int sumPrimes(int[] a) {
        int sum = 0;
        for (int v : a) if (isPrime(v)) sum += v;
        return sum;
    }

    // 4a. Last position of x
    public static int lastIndexOf(int[] a, int x) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    // 4b. First position of a prime number
    public static int firstPrimeIndex(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (isPrime(a[i])) return i;
        }
        return -1;
    }

    // 4c. Smallest positive number (returns null if none)
    public static Integer findMinPositive(int[] a) {
        Integer best = null;
        for (int v : a) {
            if (v > 0 && (best == null || v < best)) best = v;
        }
        return best;
    }

    // 4d. Check whether k appears; if yes, show all positions (no ArrayList)
    public static void printPositionsOf(int[] a, int k) {
        boolean found = false;
        System.out.print("Positions of " + k + ": ");
        for (int i = 0; i < a.length; i++) {
            if (a[i] == k) {
                if (found) System.out.print(", ");
                System.out.print(i);
                found = true;
            }
        }
        if (!found) System.out.print("(not found)");
        System.out.println();
    }

    // 4e. Min / Max
    public static int findMin(int[] a) {
        int min = a[0];
        for (int i = 1; i < a.length; i++) if (a[i] < min) min = a[i];
        return min;
    }

    public static int findMax(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) if (a[i] > max) max = a[i];
        return max;
    }

    // Helper: prime check
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n % 2 == 0) return n == 2;
        for (int d = 3; (long) d * d <= n; d += 2) {
            if (n % d == 0) return false;
        }
        return true;
    }

    // UI helpers
    private static void printMenu() {
        System.out.println("=== One-Dimensional Array Operations ===");
        System.out.println("1) Output array");
        System.out.println("2) Check if array is all even");
        System.out.println("3) Check if array is all prime");
        System.out.println("4) Check if array is strictly ascending");
        System.out.println("5) Calc: count odd elements");
        System.out.println("6) Calc: sum of positive odd");
        System.out.println("7) Calc: count divisible by 4 not by 5");
        System.out.println("8) Calc: sum of primes");
        System.out.println("9) Search: last index of x");
        System.out.println("10) Search: first prime index");
        System.out.println("11) Search: smallest positive number");
        System.out.println("12) Search: find k and print positions");
        System.out.println("13) Search: min and max");
        System.out.println("14) Reinput array");
        System.out.println("0) Exit");
    }

    private static int readInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = sc.nextLine().trim();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException ex) {
                System.out.println("Invalid integer. pls try again.");
            }
        }
    }
}
