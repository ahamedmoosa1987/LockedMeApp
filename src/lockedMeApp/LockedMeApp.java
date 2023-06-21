package lockedMeApp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class LockedMeApp {
    private static List<String> fileNames = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        displayWelcomeMessage();
        boolean isRunning = true;

        while (isRunning) {
            displayMainMenu();
            String choice = getUserChoice();

            switch (choice) {
                case "1":
                    retrieveFileNames();
                    break;
                case "2":
                    addFile();
                    break;
                case "3":
                    deleteFile();
                    break;
                case "4":
                    searchFile();
                    break;
                case "5":
                    isRunning = false;
                    System.out.println("Application closed.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }

        scanner.close();
    }

    private static void displayWelcomeMessage() {
        System.out.println("Welcome to LockedMe.com");
        System.out.println("----------------------------");
    }

    private static void displayMainMenu() {
        System.out.println("\nMAIN MENU");
        System.out.println("1. Retrieve File Names");
        System.out.println("2. Add File");
        System.out.println("3. Delete File");
        System.out.println("4. Search File");
        System.out.println("5. Close Application");
    }

    private static String getUserChoice() {
        System.out.print("\nEnter your choice: ");
        return scanner.nextLine();
    }

    private static void retrieveFileNames() {
        if (fileNames.isEmpty()) {
            System.out.println("No files found.");
            return;
        }

        List<String> sortedFileNames = new ArrayList<>(fileNames);
        Collections.sort(sortedFileNames);
        
        System.out.println("\nFILE NAMES (Ascending Order):");
        for (String fileName : sortedFileNames) {
            System.out.println(fileName);
        }
    }

    private static void addFile() {
        System.out.print("\nEnter the file name to add: ");
        String fileName = scanner.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("Invalid file name. Please try again.");
            return;
        }

        fileNames.add(fileName);
        System.out.println("File added successfully.");
    }

    private static void deleteFile() {
        System.out.print("\nEnter the file name to delete: ");
        String fileName = scanner.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("Invalid file name. Please try again.");
            return;
        }

        if (fileNames.remove(fileName)) {
            System.out.println("File deleted successfully.");
        } else {
            System.out.println("File not found.");
        }
    }

    private static void searchFile() {
        System.out.print("\nEnter the file name to search: ");
        String fileName = scanner.nextLine().trim();

        if (fileName.isEmpty()) {
            System.out.println("Invalid file name. Please try again.");
            return;
        }

        if (fileNames.contains(fileName)) {
            System.out.println("File found.");
        } else {
            System.out.println("File not found.");
        }
    }
}

