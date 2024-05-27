package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ListUsers {

	public static void listUsers(String dbPath) throws FileNotFoundException, IOException {
		File path = new File(dbPath);
		File[] files = path.listFiles();
		int i = 1;
		
		System.out.println();
		System.out.println("==== Registered Users ====");
		
		for (File file : files) {
			System.out.printf(i + " - " + nameWritter(file) + "%n");
			i++;
		}
	}

	public static String nameWritter(File file) throws FileNotFoundException, IOException {

		try (BufferedReader bf = new BufferedReader(new FileReader(file.getPath()))) {

			String name = bf.readLine();
			return name;
		}
	}
}
