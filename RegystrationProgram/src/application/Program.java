package application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import entities.Person;
import services.FileCreator;
import services.PersonCreator;
import services.QuestionnaireCreator;

public class Program {

	public static void main(String[] args) {
						
		Scanner sc = new Scanner(System.in);
;
		
		List<String> questions;

		String path = "D:\\temp\\SistemaDeCadastros\\formulario.txt";
		String dbPath = "D:\\temp\\SistemaDeCadastros\\database";
		
		boolean loopControl = true;
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
					try {
						
						System.out.println();
						System.out.println("==== User Registration ====");
						
						questions = QuestionnaireCreator.createQuestions(path);
						
						Person p = PersonCreator.createPerson(questions, sc);
						
						FileCreator.createDocument(dbPath, p);
						
						System.out.println();
						System.out.println(p);
						System.out.println();
						
						
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
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
					System.out.println("==== Programa encerrado ====");
					loopControl = false;
					break;
				default:
					System.out.println("Enter a number between 1 and 6");
			}

		} while (loopControl != false);
		
		
		
		sc.close();
	}
	
}
