package org.example.Prototype;

public interface Prototype<T extends Prototype<T>> {
    T clone();
}
