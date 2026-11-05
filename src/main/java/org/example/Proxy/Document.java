package org.example.Proxy;
import java.time.LocalDate;

public class Document implements DocumentInterface {
    private int id;
    private LocalDate creationDate;
    private String content;

    public Document(int id, LocalDate creationDate, String content) {
        this.id = id;
        this.creationDate = creationDate;
        this.content = content;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String getContent(User user) {
        return "";
    }

    @Override
    public String getContent() {
        return content;
    }

}
