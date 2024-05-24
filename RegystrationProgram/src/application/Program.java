package application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Person;
import services.FileCreator;
import services.PersonFactory;
import services.QuestionnaireCreator;

public class Program {

	public static void main(String[] args) {
		
		String path = "D:\\temp\\SistemaDeCadastros\\formulario.txt";
		String dbPath = "D:\\temp\\SistemaDeCadastros\\database";
			
		List<String> questions;
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			
			questions = QuestionnaireCreator.createQuestions(path);
			
			Person p = PersonFactory.createPerson(questions);
			
			FileCreator.createDocument(dbPath, p);
				
			System.out.println(p);
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		sc.close();
	}

}
