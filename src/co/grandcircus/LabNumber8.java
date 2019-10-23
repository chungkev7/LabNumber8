/*
 * @author: Kevin Chung
 */
package co.grandcircus;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LabNumber8 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String[] studentNames = { "Adam", "Bob", "Charlie", "Drew", "Eric", "Fred", "George", "Jack", "Matt", "Luke" };
		String[] studentHome = { "Lansing", "Detroit", "Ann Arbor", "Grand Rapids", "Pontiac", "Kalamazoo",
				"Traverse City", "Ferndale", "Saginaw", "Royal Oak" };
		String[] studentFood = { "pizza", "pasta", "burgers", "tacos", "ice cream", "pies", "cheesecake", "sushi",
				"steak", "chicken" };
		String toContinue = "y";
		int studentNum = 0;
		String numInput;
		String userInput;
		boolean isValidStudentNum = false;
		boolean isValidUserInput = false;

		while (toContinue.equals("y")) {
			System.out.println(
					"Welcome to our Java class of ten students. Which student number would you like to learn more about (1-10)?");
			while (!isValidStudentNum) {
				try {
					studentNum = scan.nextInt() - 1;
					numInput = studentNames[studentNum];
					isValidStudentNum = true;
				} catch (InputMismatchException e) {
					System.out.println(
							"That's not a valid student number. Please try again. (Enter a whole number between 1-10): ");
					scan.nextLine();
				} catch (IndexOutOfBoundsException | IllegalArgumentException e) {
					System.out.println("The student does not exist. Please try again. (Enter a number between 1-10): ");
					scan.nextLine();
				}
			}
			System.out.println("Student " + (studentNum + 1) + " is " + studentNames[studentNum]
					+ ". Would you like to you know about " + studentNames[studentNum]
					+ "? Enter hometown or favorite food.");

			scan.nextLine();
			userInput = scan.nextLine();

			while (!isValidUserInput) {
				if (userInput.equalsIgnoreCase("hometown")) {
					System.out.println(studentNames[studentNum] + " is from " + studentHome[studentNum] + ". ");
					isValidUserInput = true;
				} else if (userInput.equalsIgnoreCase("favorite food")) {
					System.out.println(studentNames[studentNum] + "'s favorite food is " + studentFood[studentNum] + ". ");
					isValidUserInput = true;
				} else {
					System.out.println("The information is not doest exist. Please enter hometown or favorite food: ");
					userInput = scan.nextLine();
				}
			}
			System.out.print("Would you like to know about another student (y/n)?\n");

			toContinue = scan.nextLine().toLowerCase().substring(0, 1);

			isValidStudentNum = false;
			isValidUserInput = false;
		}
		System.out.println("\nHave a nice day!");
		scan.close();
	}
}
