package org.example.Builder;

public class ComputerDirector {
    public void constructComputer(ComputerBuilder builder) {
        builder.buildProcessor();
        builder.buildRam();
        builder.buildHardDrive();
        builder.buildGraphicsCard();
        builder.buildOperatingSystem();
    }
}
