package org.example.Visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {

    private String extension;
    private List<File> results = new ArrayList<>();

    public SearchVisitor(String extension) {
        this.extension = extension;
    }

    @Override
    public void visit(File file) {

        if (file.getName().endsWith(extension)) {
            results.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {

        for (FileSystemElement element : directory.getElements()) {
            element.accept(this);
        }
    }

    public List<File> getResults() {
        return results;
    }
}