package org.example.Builder;

public class Main {
    public static void main(String[] args) {

        ComputerDirector director = new ComputerDirector();

        GamingComputerBuilder gamingBuilder = new GamingComputerBuilder();
        director.constructComputer(gamingBuilder);
        Computer gamingComputer = gamingBuilder.getComputer();
        System.out.println("Gaming Computer Configuration:");
        System.out.println(gamingComputer);

        OfficeComputerBuilder officeBuilder = new OfficeComputerBuilder();
        director.constructComputer(officeBuilder);
        Computer officeComputer = officeBuilder.getComputer();
        System.out.println("\nOffice Computer Configuration:");
        System.out.println(officeComputer);
    }

}
