package application;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Stream;

import entities.Person;
import services.PersonFactory;
import services.QuestionnaireCreator;

public class Program {

	public static void main(String[] args) {
		
		String path = "D:\\temp\\SistemaDeCadastros\\formulario.txt";
		String dbPath = "D:\\temp\\SistemaDeCadastros\\database";
		Stream<Path> files = null;
		
		try {
			files = Files.list(Paths.get(dbPath));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long count = files.count();
		
		List<String> questions;
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		try {
			
			questions = QuestionnaireCreator.createQuestions(path);
			
			Person p = PersonFactory.createPerson(questions);
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(dbPath+"\\"+ count + "-" + p.getName().replaceAll("\\s", "").toUpperCase()))) {
				String[] lines = new String[] {p.getName(), p.getEmail(), p.getAge().toString(), p.getHeight().toString()};
				for(String line : lines) {
					bw.write(line);
					bw.newLine();
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
