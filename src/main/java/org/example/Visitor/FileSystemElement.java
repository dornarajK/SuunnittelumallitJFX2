package org.example.Visitor;

public interface FileSystemElement {

    void accept(FileSystemVisitor visitor);

}