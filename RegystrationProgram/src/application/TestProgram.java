package application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestProgram {

	public static void main(String[] args) {

		String dbPath = "D:\\temp\\SistemaDeCadastros\\database";
		File path = new File(dbPath); File[] files = path.listFiles();
		int i = 1;
		for (File file : files) {
			try {
				System.out.printf(i + " - " + nameWritter(file) + "%n");
				i ++;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	public static String nameWritter(File file) throws FileNotFoundException, IOException {
		
		try (BufferedReader bf = new BufferedReader(new FileReader(file.getPath()))){
			
			String name = bf.readLine();
			return name;
		}
	}

}
