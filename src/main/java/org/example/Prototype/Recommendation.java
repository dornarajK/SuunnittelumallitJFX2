package org.example.Prototype;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Prototype<Recommendation> {
    private String targetAudience;
    private ArrayList<Book> recommendedBooks;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.recommendedBooks = new ArrayList<>();
    }


    // deep clone
    @Override
    public Recommendation clone() {
        Recommendation copy = new Recommendation(this.targetAudience);

        for (Book book : this.recommendedBooks) {
            copy.addBook(book.clone());
        }
        return copy;
    }

    public void addBook(Book book) {
        recommendedBooks.add(book);
    }
    public void removeBook(String book) {
        recommendedBooks.remove(book);
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getTargetAudience() {
        return targetAudience;
    }
    public List<Book> getRecommendedBooks() {
        return recommendedBooks;
    }

    public void display() {
        System.out.println("Recommended books for " + targetAudience + ":");
        for (Book book : recommendedBooks) {
            System.out.println("- " + book);
        }
    }


    public ArrayList<Book> getBooks() {
        return recommendedBooks;
    }
}


