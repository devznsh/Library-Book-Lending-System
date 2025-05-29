package storage;

import model.Book;
import model.Member;
import model.LibrarySystem;

import java.io.*;
import java.util.*;

public class FileHandler {
    public static void loadBooks(LibrarySystem system, String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            system.addBook(new Book(parts[0], parts[1], parts[2], Boolean.parseBoolean(parts[3])));
        }
        br.close();
    }

    public static void loadMembers(LibrarySystem system, String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            Member member = new Member(parts[0], parts[1]);
            system.addMember(member); // Borrowed books not loaded for simplicity
        }
        br.close();
    }

    public static void saveBooks(LibrarySystem system, String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (Book b : system.listAllBooks()) {
            bw.write(b.toFileString());
            bw.newLine();
        }
        bw.close();
    }

    public static void saveMembers(LibrarySystem system, String filename) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
        for (Member m : system.getMembers()) {
            bw.write(m.toFileString());
            bw.newLine();
        }
        bw.close();
    }
}