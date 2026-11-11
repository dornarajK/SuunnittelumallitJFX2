package org.example.Builder;

public class Computer {
    private String processor;
    private int ram;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    // to display the computer configuration
    @Override
    public String toString() {
        return "Processor: " + processor +
                "\nRAM: " + ram + " GB" +
                "\nHard Drive: " + hardDrive +
                "\nGraphics Card: " + graphicsCard +
                "\nOperating System: " + operatingSystem;
    }
}
