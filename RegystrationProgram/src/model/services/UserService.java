package model.services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import model.entities.User;
import model.exceptions.DomainException;

public class UserService {

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

	public static void searchUsers(String db, Scanner sc) throws FileNotFoundException, IOException {

		Set<User> persons = createUserList(db);
		sc.nextLine();
		System.out.println();

		System.out.println("Enter the full or partial name to search ");
		String nameInput = sc.nextLine();

		List<String> resultNames = new ArrayList<>();

		for (User person : persons) {
			if (person.getName().toLowerCase().contains(nameInput.toLowerCase())
					|| person.getEmail().toLowerCase().contains(nameInput.toLowerCase())) {
				resultNames.add(person.getName());
			}
		}

		System.out.println();

		if (resultNames.isEmpty()) {
			System.out.println("No match found");
		} else {
			for (String str : resultNames) {
				System.out.println(str);
			}
		}
	}

	public static User createNewUser(List<String> questions, Scanner sc, String dbPath) throws DomainException, FileNotFoundException, IOException {

		User p = new User();

		for (int i = 0; i < questions.size(); i++) {
			System.out.println(questions.get(i));
	
			if (i == 0) {
				sc.nextLine();
				String name = sc.nextLine();
				if (validateName(name)) {
					throw new DomainException("Name must be longer than 10 characters");
				}
				p.setName(name);

				
			} else if (i == 1) {
				String email = sc.nextLine();
				if (validateEmail(email)) {
					throw new DomainException("E-mail must contain an @");
				}
				if(checkEmailDuplicity(email, dbPath)){
					throw new DomainException("There is already a user with this e-mail");
				}
				p.setEmail(email);

			} else if (i == 2) {
				int age = sc.nextInt();
				if (validateAge(age)) {
					throw new DomainException("User age must be greater than 18");
				}
				p.setAge(age);

			} else if (i == 3) {
				sc.nextLine();
				String height = sc.nextLine();
				if(!validateHeight(height)) {
					throw new DomainException("The height number must be separeted by a comma");
				}
				double h = Double.parseDouble(height.replace(",", "."));
				p.setHeight(h);
			}
		}
		return p;
	}
	
	public static Set<User> createUserList(String dbPath) throws FileNotFoundException, IOException {

		Set<User> persons = new HashSet<>();
		File directory = new File(dbPath);
		File[] files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					String name = br.readLine();
					String email = br.readLine();
					int age = Integer.valueOf(br.readLine());
					double height = Double.valueOf(br.readLine());
					User p = new User(name, email, age, height);
					persons.add(p);
				}
			}
		}
		return persons;
	}

	public static String nameWritter(File file) throws FileNotFoundException, IOException {

		try (BufferedReader bf = new BufferedReader(new FileReader(file.getPath()))) {
			String name = bf.readLine();
			return name;
		}
	}

	public static boolean validateName(String name) {
		return name.length() < 10;
	}

	public static boolean validateEmail(String email) {
		return !email.contains("@");
	}

	public static boolean checkEmailDuplicity (String email, String dbPath) throws FileNotFoundException, IOException {
		Set<User> persons = createUserList(dbPath);
		boolean emailDuplicate = false;
		for (User p : persons) {
			if (p.getEmail().contains(email)) {
				emailDuplicate = true;
			}
		}
		return emailDuplicate;
	}
	
	public static boolean validateAge(int age) {
		return age < 18;
	}
	
	public static boolean validateHeight(String height) {
		return height.contains(",");
	}
	
}
