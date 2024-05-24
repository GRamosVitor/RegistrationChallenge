package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import services.QuestionnaireCreator;

public class Program {

	public static void main(String[] args) {
		
		String path = "D:\\temp\\SistemaDeCadastros\\formulario.txt";
		List<String> questions;
		try {
			
			questions = QuestionnaireCreator.createQuestions(path);
			for(String q : questions) {
				System.out.println(q);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}

}
