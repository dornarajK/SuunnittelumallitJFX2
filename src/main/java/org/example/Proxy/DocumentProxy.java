
package org.example.Proxy;

import org.example.Proxy.*;

import java.time.LocalDate;

public class DocumentProxy implements DocumentInterface {

    private Document document;
    private final AccessControlService accessControlService;

    public DocumentProxy(Document document) {
        this.document = document;
        this.accessControlService =
                AccessControlService.getInstance();
    }

    @Override
    public int getId() {
        return document.getId();
    }

    @Override
    public LocalDate getCreationDate() {
        return document.getCreationDate();
    }

    @Override
    public String getContent(User user) {

        String username = user.getUsername();

        if (accessControlService.isAllowed(
                document.getId(), username)) {

            return document.getContent(user);

        } else {

            throw new AccessDeniedException(
                    "Access denied! " + username
                            + " cannot access document "
                            + document.getId()
            );
        }
    }

    @Override
    public String getContent() {
        return document.getContent();
    }
}
