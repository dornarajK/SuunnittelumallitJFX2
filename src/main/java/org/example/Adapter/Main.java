package org.example.Adapter;



public class Main {

    public static void main(String[] args) {

        // Create the adapter
        NewDateInterface date = new CalendarToNewDateAdapter();

        // Set the date
        date.setDay(28);
        date.setMonth(2);
        date.setYear(2025);

        // Print the original date
        System.out.println("Original date: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());

        // Advance the date by 5 days
        date.advanceDays(5);

        // Print the new date
        System.out.println("After 5 days: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());

        // Advance another 10 days
        date.advanceDays(10);

        System.out.println("After another 10 days: "
                + date.getDay() + "/"
                + date.getMonth() + "/"
                + date.getYear());
    }
}