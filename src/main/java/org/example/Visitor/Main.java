package org.example.Visitor;

public class Main {

    public static void main(String[] args) {

        // Create the main directory
        Directory root = new Directory("MyComputer");

        // Create subdirectories
        Directory documents = new Directory("Documents");
        Directory pictures = new Directory("Pictures");

        // Create files
        File file1 = new File("report.pdf", 5);
        File file2 = new File("homework.docx", 3);
        File file3 = new File("photo.jpg", 10);
        File file4 = new File("notes.pdf", 2);

        // Add files to directories
        documents.add(file1);
        documents.add(file2);
        pictures.add(file3);
        pictures.add(file4);

        // Add directories to root
        root.add(documents);
        root.add(pictures);

        // Calculate total size
        SizeCalculatorVisitor sizeVisitor =
                new SizeCalculatorVisitor();

        root.accept(sizeVisitor);

        System.out.println("Total size: "
                + sizeVisitor.getTotalSize() + " MB");

        // Search for PDF files
        SearchVisitor searchVisitor =
                new SearchVisitor(".pdf");

        root.accept(searchVisitor);

        System.out.println("\nPDF files found:");

        for (File file : searchVisitor.getResults()) {
            System.out.println(file.getName()
                    + " - " + file.getSize() + " MB");
        }
    }
}