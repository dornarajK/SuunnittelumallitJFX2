package org.example.Proxy;
import java.time.LocalDate;


public interface DocumentInterface {
    int getId();
    LocalDate getCreationDate();
    String getContent(User user);

    String getContent();
}
