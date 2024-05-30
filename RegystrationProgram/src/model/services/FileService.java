package model.services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import model.entities.User;

public class FileService {

	public static void createDocument(String dbPath, User p) throws IOException {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(createPath(dbPath, p)))) {
			String[] lines = new String[] {p.getName(), p.getEmail(), p.getAge().toString(), p.getHeight().toString()};
			for(String line : lines) {
				bw.write(line);
				bw.newLine();
			}
		}
	}
	
	public static String createPath(String dbPath, User p) throws IOException{
		return dbPath + "\\" + (count(dbPath ) + 1) + "-" + p.getName().replaceAll("\\s", "").toUpperCase() + ".txt" ;
	}
	
	public static long count(String dbPath) throws IOException {
		try (Stream<Path> files = Files.list(Paths.get(dbPath))) {
			long count = files.count();
			return count;
		}
	}
	
	
}
