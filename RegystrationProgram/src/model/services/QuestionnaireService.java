package model.services;

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

public class QuestionnaireService {

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
		sc.nextLine();
		System.out.println();
		System.out.println("==== Enter the question to be added to the Questionaire: ====");
		String question = sc.nextLine();
		String insertion = String.valueOf(questions.size() + 1) + " - " + question;

		File file = new File(path);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {

			bw.write(insertion);
			bw.newLine();
		}
	}

	public static void deleteQuestion(String path, Scanner sc) throws FileNotFoundException, IOException {
		
		File file = new File(path);
		List<String> questions = readQuestions(path);

		for (String question : questions) {
			System.out.println(question);
		}
		
		System.out.println("==== Enter the question nbumber to be deleted from the Questionaire: ====");
		int number = sc.nextInt();
		number--;
		
		if (number < 4) {
			System.out.println("It is not possible to delete questions 1 to 4");
		} else {
			questions.remove(number);
		}
				
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			for(String question : questions) {
				bw.write(question);
				bw.newLine();
			}
		}
	}
}
