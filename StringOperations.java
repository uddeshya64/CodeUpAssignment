/*
 * Program to perform String operations such as Append, CountWords, Replace, isPalindrome, Splice, Split, MaxRepeat, Sort, Shift, and Reverse.
 * Owner : Uddeshya Patidar
 * Date : 04/09/2024 
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
            System.out.println("\nChoose an operation:");
            System.out.println("1. Append");
            System.out.println("2. Count Words");
            System.out.println("3. Replace");
            System.out.println("4. Is Palindrome");
            System.out.println("5. Splice");
            System.out.println("6. Split");
            System.out.println("7. Max Repeat");
            System.out.println("8. Sort");
            System.out.println("9. Shift");
            System.out.println("10. Reverse");
        
            System.out.print("Enter the number of the operation: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input: Please enter a valid operation number.");
                scanner.next();
                scanner.nextLine();
                continue;
            }
            int choice = scanner.nextInt();
            scanner.nextLine(); //Consume the new line character

            String resultString = inputString;
            boolean validOption = true;

            switch (choice) {
            
                case 1: //Append the string
                    System.out.print("Enter the string to append: ");
                    String appendString = scanner.nextLine();
                    if (!appendString.isEmpty()) {
                        resultString = inputString + appendString;
                        System.out.println("Updated String: " + resultString);
                    } else {
                        System.out.println("Invalid input: The string to append cannot be empty.");
                    }
                    break;

                case 2: //Count total number of words in the current string 
                    if (inputString.trim().isEmpty()) {
                        System.out.println("Word count: 0"); //If string is empty
                    } else {
                        String[] words = inputString.trim().split("\\s+"); //Split by spaces
                        System.out.println("Word count: " + words.length);
                    }
                    break;

                case 3: //Replace all occurrences of character a with character b in the current string
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

                case 4: //Check if the string is a Palindrome
                    boolean is_Palindrome = isPalindrome(inputString);
                    System.out.println("Is palindrome: " + is_Palindrome);
                    break;

                case 5: //Splice the string
                    spliceOperation(scanner, inputString);
                    break;

                case 6: //Split the current string into array of words
                    System.out.print("Enter the pattern to split by: ");
                    String pattern = scanner.nextLine();
                    String[] words = split(inputString, pattern);
                    System.out.println("Split result: " + Arrays.toString(words));
                    break;

                case 7: //Return the character that appears the most frequently 
                    char maxChar = maxRepeat(inputString);
                    System.out.println("Character that appears most frequently: " + maxChar);
                    break;

                case 8: //Sort the characters of the string in alphabetical order
                    String sortedString = sort(inputString);
                    System.out.println("Updated String: " + sortedString);
                    break;

                case 9: //Shift the characters from start to end of the string
                    System.out.print("Enter the number of characters to shift: ");
                    int shiftAmount = scanner.nextInt();
                    scanner.nextLine(); //Consume the newline left by nextInt()
                    resultString = shift(inputString, shiftAmount);
                    System.out.println("Updated String: " + resultString);
                    break;

                case 10: //Reverse the string
                    resultString = reverse(inputString);
                    System.out.println("Updated String: " + resultString);
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

    //Split the string
    public static String[] split(String inputString, String pattern) {
        return inputString.split(pattern);
    }

    //Return the character with maximum occurrence
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

    //Sort the string
    public static String sort(String inputString) {
        char[] chars = inputString.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    //Shift the characters
    public static String shift(String inputString, int n) {
        if (n > inputString.length()) {
            return inputString;
        }
        return inputString.substring(n) + inputString.substring(0, n);
    }

    //Reverse the string
    public static String reverse(String inputString) {
        StringBuilder reversed = new StringBuilder(inputString);
        return reversed.reverse().toString();
    }

    //Count the words in string
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

    //Splice the string
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

    //check if the string is a Palindrome 
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




