package services;

import java.util.List;
import java.util.Scanner;

import entities.Person;

public class PersonCreator {
	
	public static Person createPerson(List<String> questions, Scanner sc) {
		

		Person p = new Person();
		
		for(int i = 0; i< questions.size(); i++) {
			System.out.println(questions.get(i));
			if(questions.get(i).charAt(0) == '1') {
				sc.nextLine();
				String name = sc.nextLine();
				p.setName(name);
			} else if(questions.get(i).charAt(0) == '2') {
				String email = sc.nextLine();
				p.setEmail(email);
				
			} else if (questions.get(i).charAt(0) == '3'){
				int age = sc.nextInt();
				p.setAge(age);
			} else {
				Double height = sc.nextDouble();
				p.setHeight(height);
			}
		}
		return p;
	}
}
