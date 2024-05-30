package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import model.entities.User;
import model.services.QuestionnaireService;
import model.services.UserService;

public class TestProgram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String path = "D:\\temp\\SistemaDeCadastros\\database";
		
		try {
			System.out.println(count(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static long count(String dbPath) throws IOException {
		try (Stream<Path> files = Files.list(Paths.get(dbPath))) {
			long count = files.count();
			return count;
		}
	
}
}
