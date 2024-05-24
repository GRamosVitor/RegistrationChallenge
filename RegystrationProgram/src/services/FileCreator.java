package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import entities.Person;

public class FileCreator {

	public static void createDocument(String dbPath, Person p) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(createPath(dbPath, p)))) {
			String[] lines = new String[] {p.getName(), p.getEmail(), p.getAge().toString(), p.getHeight().toString()};
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
	}
	
	public static long count(String dbPath) throws IOException {
		try (Stream<Path> files = Files.list(Paths.get(dbPath))) {
			long count = files.count();
			return count;
		}
	}
	
	public static String createPath(String dbPath, Person p) throws IOException{
		return dbPath +"\\"+ count(dbPath) + "-" + p.getName().replaceAll("\\s", "").toUpperCase();
	}
}
