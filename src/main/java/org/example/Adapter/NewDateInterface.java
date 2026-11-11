package org.example.Adapter;

public interface NewDateInterface {
    void setDay(int day);

    void setMonth(int month);

    void setYear(int year);

    int getDay();

    int getMonth();

    int getYear();
    // siirtää päivämäärää eteenpäin
    void advanceDays(int days);
}
