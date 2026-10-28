package org.example.Memento;


public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        System.out.println("Memento created");
    }

    private final String timestamp =
            java.time.LocalDateTime.now()
                    .format(
                            java.time.format.DateTimeFormatter
                                    .ofPattern("dd.MM.yyyy HH:mm:ss")
                    );

    @Override
    public String getTimestamp() {
        return timestamp;
    }

    public int[] getOptions() {
        return options;
    }

    public boolean isSelected() {
        return isSelected;
    }
}