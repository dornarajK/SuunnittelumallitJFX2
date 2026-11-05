package org.example.Proxy;



import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // users
        User john = new User("John");
        User teacher = new User("Teacher");
        User manager = new User("Manager");


        Library library = new Library();

        //public documents
        library.addPublicDocument(
                1,
                LocalDate.now(),
                "Welcome to our document library."
        );

        //protected documents
        library.addProtectedDocument(
                2,
                LocalDate.now(),
                "protected for Teacher",
                "Teacher"
        );

        library.addProtectedDocument(
                3,
                LocalDate.now(),
                "protected for Manager",
                "Manager"
        );

        //Test public document
        System.out.println("public documents: ");

        DocumentInterface doc1 = library.getDocument(1);

        System.out.println("ID: " + doc1.getId());
        System.out.println("Date: " + doc1.getCreationDate());
        System.out.println("Content: " + doc1.getContent(john));


        // Test protected document - John (not allowed)
        System.out.println("\n 1. protected documents (test john): ");

        DocumentInterface doc2 = library.getDocument(2);

        try {
            System.out.println(doc2.getContent(john));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }


        // Test protected document - Teacher (allowed)
        System.out.println("\n 2. protected document - Teacher: ");

        try {
            System.out.println(doc2.getContent(teacher));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }


        // Test protected document - Manager (allowed)
        System.out.println("\n 3. Manager ACCESSING DOCUMENT 3: ");

        DocumentInterface doc3 = library.getDocument(3);

        try {
            System.out.println(doc3.getContent(manager));
        } catch (AccessDeniedException e) {
            System.out.println(e.getMessage());
        }


        // print document info
        System.out.println("\n 4. Document Information: ");


        System.out.println("Document ID: " + doc1.getId());
        System.out.println("Creation date: " + doc1.getCreationDate());
        System.out.println("__");
        System.out.println("Document ID: " + doc2.getId());
        System.out.println("Creation date: " + doc2.getCreationDate());
        System.out.println("__");
        System.out.println("Document ID: " + doc3.getId());
        System.out.println("Creation date: " + doc3.getCreationDate());
    }
}
