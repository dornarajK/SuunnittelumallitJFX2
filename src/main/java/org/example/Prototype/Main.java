package org.example.Prototype;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList <Recommendation> recommendations = new ArrayList<>();


        // student recommendation example
        Recommendation students = new Recommendation("Students");
        students.addBook(new Book(
                "Kristiina Viitanen", "3D-mallintaminen suunnittelun apuvälineenä", "3D Modeling", 2012
        ));

        students.addBook(new Book(
                "Martin Fowler", "UML Distilled", "Software Modeling", 1997
        ));

        recommendations.add(students);


        while (true) {
            System.out.println("\n-- Book Recommendation System --");
            System.out.println("1. View recommendations");
            System.out.println("2. Create recommendation");
            System.out.println("3. Clone recommendation");
            System.out.println("4. Exit");

            System.out.println("your choice: ");
            String choice = scanner.nextLine();

            // View recommendations
            if (choice.equals("1")) {
                for (int i = 0; i < recommendations.size(); i++) {
                    System.out.println("\nRecommendation " + (i + 1));
                    recommendations.get(i).display();
                }

            }

            // Create recommendation
            else if (choice.equals("2")) {

                System.out.print("Enter target audience: ");
                String audience = scanner.nextLine();

                Recommendation newRecommendation =
                        new Recommendation(audience);

                System.out.print("Enter book title: ");
                String title = scanner.nextLine();

                System.out.print("Enter author: ");
                String author = scanner.nextLine();

                newRecommendation.addBook(
                        new Book(author, title, "General", 2026)
                );

                recommendations.add(newRecommendation);

                System.out.println("Recommendation created!");

            }

            // Clone recommendation

            else if (choice.equals("3")) {

                // Show recommendations
                for (int i = 0; i < recommendations.size(); i++) {
                    System.out.println((i + 1) + ". " +
                            recommendations.get(i).getTargetAudience());
                }

                System.out.print("Choose recommendation number: ");
                int number;
                try {
                    number = Integer.parseInt(scanner.nextLine().trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid recommendation number!");
                    continue;
                }

                if (number >= 1 && number <= recommendations.size()) {

                    Recommendation cloned = recommendations.get(number - 1).clone();

                    System.out.print("Enter new target audience: ");
                    cloned.setTargetAudience(scanner.nextLine());

                    boolean editing = true;
                    while (editing) {
                        System.out.println("\nCurrent books in clone:");
                        cloned.display();

                        System.out.println("1. Add book");
                        System.out.println("2. Remove book");
                        System.out.println("3. Finish");
                        System.out.print("Choose: ");
                        String option = scanner.nextLine().trim();

                        if (option.equals("1")) {
                            System.out.print("Enter book title: ");
                            String title = scanner.nextLine().trim();
                            System.out.print("Enter author: ");
                            String author = scanner.nextLine().trim();
                            cloned.addBook(new Book(author, title, "General", 2026));

                        } else if (option.equals("2")) {

                            ArrayList<Book> books = cloned.getBooks();

                            if (books.isEmpty()) {
                                System.out.println("No books to remove!");
                            } else {
                                for (int i = 0; i < books.size(); i++) {
                                    System.out.println((i + 1) + ". " + books.get(i).getTitle());
                                }

                                System.out.print("Enter book number to remove: ");
                                try {
                                    int bookNumber = Integer.parseInt(scanner.nextLine().trim());

                                    if (bookNumber >= 1 && bookNumber <= books.size()) {
                                        books.remove(bookNumber - 1);
                                        System.out.println("Book removed!");
                                    } else {
                                        System.out.println("Invalid book number!");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Invalid book number!");
                                }
                            }
                        }

                        else if (option.equals("3")) {
                            editing = false;

                        } else {
                            System.out.println("Invalid choice!");
                        }
                    }

                    recommendations.add(cloned);
                    System.out.println("Cloned recommendation saved!");

                } else {
                    System.out.println("Invalid recommendation number!");
                }
            }

            // Exit
            else if (choice.equals("4")) {

                System.out.println("Goodbye!");
                break;

            }

            else {
                System.out.println("Invalid choice!");
            }
        }

        scanner.close();



        }



    }

