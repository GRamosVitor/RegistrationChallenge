package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionnaireCreator {

	public static List<String> createQuestions(String path) throws FileNotFoundException, IOException {
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
}
