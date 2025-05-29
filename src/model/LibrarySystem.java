package model;

import java.util.ArrayList;

public class LibrarySystem {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public LibrarySystem() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void issueBook(String bookId, String memberId) throws Exception {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);
        member.borrowBook(book);
    }

    public void returnBook(String bookId, String memberId) throws Exception {
        Book book = findBookById(bookId);
        Member member = findMemberById(memberId);
        member.returnBook(book);
    }

    public ArrayList<Book> listAllBooks() {
        return books;
    }

    public ArrayList<Book> listAvailableBooks() {
        ArrayList<Book> available = new ArrayList<>();
        for (Book b : books) {
            if (b.isAvailable()) {
                available.add(b);
            }
        }
        return available;
    }

    public Book findBookById(String id) throws Exception {
        return books.stream().filter(b -> b.getBookId().equals(id)).findFirst()
                    .orElseThrow(() -> new Exception("Book not found."));
    }

    public Member findMemberById(String id) throws Exception {
        return members.stream().filter(m -> m.getMemberId().equals(id)).findFirst()
                      .orElseThrow(() -> new Exception("Member not found."));
    }

    public ArrayList<Member> getMembers() { return members; }
}