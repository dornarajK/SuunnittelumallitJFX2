package org.example.Builder;

public class GamingComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("Intel Core i9");
    }

    @Override
    public void buildRam() {
        computer.setRam(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1 TB SSD");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("NVIDIA RTX 3080");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Windows 10 Pro");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
