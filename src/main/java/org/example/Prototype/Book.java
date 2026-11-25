package org.example.Prototype;

public class Book implements Prototype<Book> {
    private String author;
    private String title;
    private String genre;
    private int publicationYear;

    public Book(String author, String title, String genre, int publicationYear) {
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // close the book
    @Override
    public Book clone() {
        return new Book(this.author, this.title, this.genre, this.publicationYear);
    }

    // getters
    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }
    public int getPublicationYear() {
        return publicationYear;
    }

    @Override
    public String toString() {
        return title + " by " + author +
                " (" + genre + ", " + publicationYear + ")";
    }
}
