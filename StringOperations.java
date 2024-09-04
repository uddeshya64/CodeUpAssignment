/***
 * Program to perform String operations such as Append, CountWords, Replace, isPalindrome and Splice.
 * Owner: Uddeshya Patidar
 * Date: 04/09/2024
 */
package practice.java;

import java.util.Scanner;

public class StringOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.print("Enter a string: ");
            String inputString = scanner.nextLine();
            System.out.println("\nChoose an operation:"
            		+ "\n1. Append"
            		+ "\n2. Count Words"
            		+ "\n3. Replace"
            		+ "\n4. Is Palindrome"
            		+ "\n5. Splice");
            
            System.out.print("Enter the number of the operation: ");
            
            // Check input
            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: Please enter a valid operation number.");
                scanner.next(); 
                continue; 
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            String resultString = inputString;
            boolean validOption = true;

            switch (choice) {
                case 1:// Append
                    System.out.print("Enter the string to append: ");
                    String appendString = scanner.nextLine();
                    if (!appendString.isEmpty()) {
                        resultString = inputString + appendString;
                        System.out.println("Updated String: " + resultString);
                    } else {
                        System.out.println("Invalid input: The string to append cannot be empty.");
                    }
                    break;

                case 2:// Count words 
                    int wordCount = 0;
                    boolean inWord = false;
                    for (int i = 0; i < inputString.length(); i++) {
                        if (inputString.charAt(i) != ' ') {
                            if (!inWord) {
                                wordCount++;
                                inWord = true;
                            }
                        } else {
                            inWord = false;
                        }
                    }
                    System.out.println("Word count: " + wordCount);
                    break;

                case 3:// replace 
                    System.out.print("Enter the character or substring to replace: ");
                    String oldSubstring = scanner.nextLine();
                    System.out.print("Enter the replacement character or substring: ");
                    String newSubstring = scanner.nextLine();
                    if (!oldSubstring.isEmpty() && !newSubstring.isEmpty()) {
                        StringBuilder replaceResult = new StringBuilder();
                        for (int i = 0; i < inputString.length(); i++) {
                            boolean match = true;
                            for (int j = 0; j < oldSubstring.length() && i + j < inputString.length(); j++) {
                                if (inputString.charAt(i + j) != oldSubstring.charAt(j)) {
                                    match = false;
                                    break;
                                }
                            }
                            if (match) {
                                replaceResult.append(newSubstring);
                                i += oldSubstring.length() - 1;
                            } else {
                                replaceResult.append(inputString.charAt(i));
                            }
                        }
                        resultString = replaceResult.toString();
                        System.out.println("Updated String: " + resultString);
                    } else {
                        System.out.println("Invalid input: Both the old and new substrings must be non-empty.");
                    }
                    break;
                case 4:// is palindrome 
                    boolean isPal = true;
                    int n = inputString.length();
                    for (int i = 0; i < n / 2; i++) {
                        if (inputString.charAt(i) != inputString.charAt(n - i - 1)) {
                            isPal = false;
                            break;
                        }
                    }
                    System.out.println("Is palindrome: " + isPal);
                    break;
                case 5:// splice operation
                    System.out.print("Enter the start index for splice: ");
                    if (scanner.hasNextInt()) {
                        int start = scanner.nextInt();
                        System.out.print("Enter the length for splice: ");
                        if (scanner.hasNextInt()) {
                            int length = scanner.nextInt();
                            scanner.nextLine(); 
                            if (start >= 0 && start + length <= inputString.length()) {
                                resultString = inputString.substring(0, start) + inputString.substring(start + length);
                                System.out.println("Updated String: " + resultString);
                            } else {
                                System.out.println("Invalid input: Start index and length are out of bounds.");
                            }
                        } else {
                            System.out.println("Invalid input: Length must be an integer.");
                            scanner.next(); 
                        }
                    } else {
                        System.out.println("Invalid input: Start index must be an integer.");
                        scanner.next(); 
                    }
                    break;
                default:
                    validOption = false;
                    System.out.println("Invalid choice: Please enter a valid operation number.");
                    break;
            }
            if (validOption) {
                System.out.print("Do you want to run the code again? (y/n): ");
            } else {
                System.out.print("Would you like to try again? (y/n): ");
            }
        } while (scanner.nextLine().equalsIgnoreCase("yes"));
        System.out.println("Program terminated.");
        scanner.close();
    }
}



