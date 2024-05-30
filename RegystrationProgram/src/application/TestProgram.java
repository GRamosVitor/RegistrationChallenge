package application;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import model.entities.User;
import model.services.QuestionnaireService;
import model.services.UserService;

public class TestProgram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String path = "D:\\temp\\SistemaDeCadastros\\formulario.txt";
		boolean loopControl = true;
		do {
		try {
			List<String> questions = QuestionnaireService.readQuestions(path);

			for (String str : questions) {
				System.out.println(str);
			}
			
			User p = UserService.createNewUser(questions, sc);
			
			System.out.println(p);
			loopControl = false;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());

			}
		} while (loopControl == true); 
	}
}
