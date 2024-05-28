package services;

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

import entities.Person;

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

	public static String nameWritter(File file) throws FileNotFoundException, IOException {

		try (BufferedReader bf = new BufferedReader(new FileReader(file.getPath()))) {

			String name = bf.readLine();
			return name;
		}
	}

	public static void searchUsers(String db, Scanner sc) throws FileNotFoundException, IOException {

		Set<Person> persons = createPersonList(db);
		sc.nextLine();
		System.out.println();

		System.out.println("Enter the full or partial name to search ");
		String nameInput = sc.nextLine();

		List<String> resultNames = new ArrayList<>();

		for (Person person : persons) {
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

	public static Set<Person> createPersonList(String dbPath) throws FileNotFoundException, IOException {

		Set<Person> persons = new HashSet<>();
		File directory = new File(dbPath);
		File[] files = directory.listFiles();

		if (files != null) {
			for (File file : files) {
				try (BufferedReader br = new BufferedReader(new FileReader(file))) {
					String name = br.readLine();
					String email = br.readLine();
					int age = Integer.valueOf(br.readLine());
					double height = Double.valueOf(br.readLine());
					Person p = new Person(name, email, age, height);
					persons.add(p);
				}
			}
		}
		return persons;
	}
}
