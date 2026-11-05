package org.example.Proxy;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Library {

    private final Map<Integer, DocumentInterface> documents =
            new HashMap<>();

    // Add an unprotected document
    public void addPublicDocument(
            int id, LocalDate creationDate, String content) {

        Document document =
                new Document(id, creationDate, content);

        documents.put(id, document);
    }

    // Add a protected document
    public void addProtectedDocument(
            int id, LocalDate creationDate, String content,
            String... usernames) {

        Document document =
                new Document(id, creationDate, content);

        AccessControlService service =
                AccessControlService.getInstance();

        for (String username : usernames) {
            service.grantAccess(id, username);
        }

        DocumentProxy proxy = new DocumentProxy(document);

        documents.put(id, proxy);
    }

    // Find a document using its ID
    public DocumentInterface getDocument(int id) {

        return documents.get(id);
    }
}
