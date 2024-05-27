package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionnaireManipulator {

	public static List<String> readQuestions(String path) throws FileNotFoundException, IOException {
		List<String> questions = new ArrayList<>();
		try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

			String line = bf.readLine();
			while (line != null) {
				questions.add(line);
				line = bf.readLine();
			}

			return questions;
		}
	}

	public static void addQuestion(String path, Scanner sc) throws FileNotFoundException, IOException {
		
		List<String> questions = readQuestions(path);
		
		System.out.println();
		System.out.println("==== Enter the question to be added to the Questionaire: ====");
		sc.nextLine();
		String question = sc.nextLine();
		String insertion = String.valueOf(questions.size()+1) + " - " + question;
		
		File file = new File(path);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			
			bw.write(insertion);
			bw.newLine();
		}
	}
}
