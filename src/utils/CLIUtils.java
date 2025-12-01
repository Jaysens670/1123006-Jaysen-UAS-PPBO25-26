package utils;

import java.util.Scanner;

public class CLIUtils {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }

    public static int readInt(String prompt) {
        System.out.println(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Input must be a number!");
            scanner.next();
        }
        int result = scanner.nextInt();
        scanner.nextLine();
        return result;
    }
}