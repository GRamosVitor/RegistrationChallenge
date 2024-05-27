package application;

import java.io.IOException;
import java.util.Scanner;

import services.QuestionnaireManipulator;

public class TestProgram {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String path = "D:\\temp\\SistemaDeCadastros\\formulario.txt";
		try {
			QuestionnaireManipulator.addQuestion(path, sc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	}

