package model;

import java.util.ArrayList;

public class Member {
    private String memberId;
    private String name;
    private ArrayList<Book> borrowedBooks;

    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public void borrowBook(Book book) throws MaxLimitReachedException, BookNotAvailableException {
        if (borrowedBooks.size() >= 3) {
            throw new MaxLimitReachedException("You cannot borrow more than 3 books.");
        }
        if (!book.isAvailable()) {
            throw new BookNotAvailableException("This book is not available.");
        }
        borrowedBooks.add(book);
        book.setAvailable(false);
    }

    public void returnBook(Book book) throws Exception {
        if (!borrowedBooks.contains(book)) {
            throw new Exception("This book was not borrowed by this member.");
        }
        borrowedBooks.remove(book);
        book.setAvailable(true);
    }

    public String getMemberId() { return memberId; }
    public String getName() { return name; }
    public ArrayList<Book> getBorrowedBooks() { return borrowedBooks; }

    public String toFileString() {
        StringBuilder sb = new StringBuilder(memberId + "," + name);
        for (Book book : borrowedBooks) {
            sb.append(",").append(book.getBookId());
        }
        return sb.toString();
    }
}