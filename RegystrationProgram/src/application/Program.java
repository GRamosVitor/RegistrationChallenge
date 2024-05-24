package application;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Person;
import services.QuestionnaireCreator;

public class Program {

	public static void main(String[] args) {
		
		String path = "D:\\temp\\SistemaDeCadastros\\formulario.txt";
		List<String> questions;
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			
			Person p = new Person();
			questions = QuestionnaireCreator.createQuestions(path);
			
			for(int i = 0; i< questions.size(); i++) {
				System.out.println(questions.get(i));
				if(questions.get(i).charAt(0) == '1') {
					String name = sc.nextLine();
					p.setName(name);
				} else if(questions.get(i).charAt(0) == '2') {
					String email = sc.nextLine();
					p.setEmail(email);
					
				} else if (questions.get(i).charAt(0) == '3'){
					int age = sc.nextInt();
					p.setAge(age);
				} else {
					Double height = sc.nextDouble();
					p.setHeight(height);
					
				}
			}
			
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
