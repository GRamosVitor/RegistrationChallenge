package application;

import java.util.Scanner;

public class TestProgram {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		boolean loopControl = true;
		Scanner sc = new Scanner(System.in);

		do {
			System.out.println("==== Select an Option ====");
			System.out.println("1 - Register new User");
			System.out.println("2 - List registered users");
			System.out.println("3 - Register new question on the form");
			System.out.println("4 - Delete question from the form");
			System.out.println("5 - Search User by name or e-mail");
			System.out.println("6 - Exit");
			System.out.print("Enter option number: ");
			int optionNumber = sc.nextInt();

			switch (optionNumber) {
				case 1:
					System.out.println("caso 1");
					break;
				case 2:
					System.out.println("caso 2");
					break;
				case 3:
					System.out.println("caso 3");
					break;
				case 4:
					System.out.println("caso 4");
					break;
				case 5:
					System.out.println("caso 5");
					break;
				case 6:
					loopControl = false;
					break;
				default:
					System.out.println("Enter a number between 1 and 6");
			}

		} while (loopControl != false);
		
		sc.close();
	}

}
