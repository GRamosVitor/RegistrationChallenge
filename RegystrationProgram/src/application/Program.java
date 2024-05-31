package application;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.entities.User;
import model.services.FileService;
import model.services.QuestionnaireService;
import model.services.UserService;

public class Program {

	public static void main(String[] args) throws IOException {

		String path = "D:\\temp\\SistemaDeCadastros\\formulario.txt";
		String dbPath = "D:\\temp\\SistemaDeCadastros\\database";

		boolean loopControl = true;
		Scanner sc = new Scanner(System.in);

		do {
			try {

				List<String> questions;

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
					System.out.println();
					System.out.println("==== User Registration ====");

					questions = QuestionnaireService.readQuestions(path);
					
					User p = UserService.createNewUser(questions, sc, dbPath);

					FileService.createDocument(dbPath, p);

					System.out.println();

					System.out.println(p);

					System.out.println();
					System.out.println("==== Press enter to return ====");
					System.in.read();

					break;

				case 2:
					UserService.listUsers(dbPath);

					System.out.println();
					System.out.println("==== Press enter to return ====");
					System.in.read();

					break;

				case 3:
					QuestionnaireService.addQuestion(path, sc);

					System.out.println();
					System.out.println("==== Press enter to return ====");
					System.in.read();

					break;

				case 4:
					QuestionnaireService.deleteQuestion(path, sc);

					System.out.println();
					System.out.println("==== Press enter to return ====");
					System.in.read();
					break;

				case 5:
					UserService.searchUsers(dbPath, sc);

					System.out.println();
					System.out.println("==== Press enter to return ====");
					System.in.read();
					break;

				case 6:
					System.out.println("==== Program closed ====");
					loopControl = false;
					break;

				default:
					System.out.println("Enter a number between 1 and 6");
				}

			} catch (Exception e) {
				System.out.println("Error: " + e.getMessage());
				System.out.println();
				System.out.println("==== Press enter to return ====");
				System.in.read();
			}

		} while (loopControl != false);
		sc.close();
	}
}
