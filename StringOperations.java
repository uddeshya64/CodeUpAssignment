/***
 * Program to perform String operations such as Append, CountWords, Replace, isPalindrome, Splice, Split, MaxRepeat, Sort, Shift, and Reverse.
 * Owner: Uddeshya Patidar
 * Date: 04/09/2024
 */
package practice.java;

import java.util.Arrays;
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
                    + "\n5. Splice"
                    + "\n6. Split"
                    + "\n7. Max Repeat"
                    + "\n8. Sort"
                    + "\n9. Shift"
                    + "\n10. Reverse");

            System.out.print("Enter the number of the operation: ");

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
                case 1: // Append
                    System.out.print("Enter the string to append: ");
                    String appendString = scanner.nextLine();
                    if (!appendString.isEmpty()) {
                        resultString = inputString + appendString;
                        System.out.println("Updated String: " + resultString);
                    } else {
                        System.out.println("Invalid input: The string to append cannot be empty.");
                    }
                    break;

                case 2: // Count words
                    int wordCount = countWords(inputString);
                    System.out.println("Word count: " + wordCount);
                    break;

                case 3: // Replace
                    System.out.print("Enter the character or substring to replace: ");
                    String oldSubstring = scanner.nextLine();
                    System.out.print("Enter the replacement character or substring: ");
                    String newSubstring = scanner.nextLine();
                    if (!oldSubstring.isEmpty() && !newSubstring.isEmpty()) {
                        resultString = inputString.replace(oldSubstring, newSubstring);
                        System.out.println("Updated String: " + resultString);
                    } else {
                        System.out.println("Invalid input: Both the old and new substrings must be non-empty.");
                    }
                    break;

                case 4: // Is Palindrome
                    boolean isPal = isPalindrome(inputString);
                    System.out.println("Is palindrome: " + isPal);
                    break;

                case 5: // Splice
                    spliceOperation(scanner, inputString);
                    break;

                case 6: // Split
                    System.out.print("Enter the pattern to split by: ");
                    String pattern = scanner.nextLine();
                    String[] words = split(inputString, pattern);
                    System.out.println("Split result: " + Arrays.toString(words));
                    break;

                case 7: // Max Repeat
                    char maxChar = maxRepeat(inputString);
                    System.out.println("Character that appears most frequently: " + maxChar);
                    break;

                case 8: // Sort
                    String sortedString = sort(inputString);
                    System.out.println("Sorted String: " + sortedString);
                    break;

                case 9: // Shift
                    System.out.print("Enter the number of characters to shift: ");
                    int n = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline left by nextInt()
                    resultString = shift(inputString, n);
                    System.out.println("Shifted String: " + resultString);
                    break;

                case 10: // Reverse
                    resultString = reverse(inputString);
                    System.out.println("Reversed String: " + resultString);
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
        } while (scanner.nextLine().equalsIgnoreCase("y"));
        System.out.println("Program terminated.");
        scanner.close();
    }

    // Split
    public static String[] split(String inputString, String pattern) {
        return inputString.split(pattern);
    }

    // Max Repeat
    public static char maxRepeat(String inputString) {
        int[] freq = new int[256];
        for (int i = 0; i < inputString.length(); i++) {
            freq[inputString.charAt(i)]++;
        }
        int max = -1;
        char result = ' ';
        for (int i = 0; i < inputString.length(); i++) {
            if (freq[inputString.charAt(i)] > max) {
                max = freq[inputString.charAt(i)];
                result = inputString.charAt(i);
            }
        }
        return result;
    }

    // Sort
    public static String sort(String inputString) {
        char[] chars = inputString.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    // Shift
    public static String shift(String inputString, int n) {
        if (n > inputString.length()) {
            return inputString;
        }
        return inputString.substring(n) + inputString.substring(0, n);
    }

    // Reverse
    public static String reverse(String inputString) {
        StringBuilder reversed = new StringBuilder(inputString);
        return reversed.reverse().toString();
    }

    // Count Words 
    public static int countWords(String inputString) {
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
        return wordCount;
    }

    // Splice 
    public static void spliceOperation(Scanner scanner, String inputString) {
        System.out.print("Enter the start index for splice: ");
        if (scanner.hasNextInt()) {
            int start = scanner.nextInt();
            System.out.print("Enter the length for splice: ");
            if (scanner.hasNextInt()) {
                int length = scanner.nextInt();
                scanner.nextLine();
                if (start >= 0 && start + length <= inputString.length()) {
                    String resultString = inputString.substring(0, start) + inputString.substring(start + length);
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
    }

    // IsPalindrome 
    public static boolean isPalindrome(String inputString) {
        int n = inputString.length();
        for (int i = 0; i < n / 2; i++) {
            if (inputString.charAt(i) != inputString.charAt(n - i - 1)) {
                return false;
            }
        }
        return true;
    }
}




