package org.example.Builder;

public class OfficeComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i5");
    }

    @Override
    public void buildRam() {
        computer.setRam(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("512 GB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Intel Integrated Graphics");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 11 Home");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
