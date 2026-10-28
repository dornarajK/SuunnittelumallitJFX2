package org.example.Memento;


import java.util.ArrayList;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
public class Controller {
    private Model model;
    private Gui gui;
    private List<IMemento> history; // Memento history

    // history
    private ArrayList<IMemento> undoHistory = new ArrayList<>();
    private ArrayList<IMemento> redoHistory = new ArrayList<>();

    public Controller(Gui gui) {
        this.model = new Model();
        this.gui = gui;
        this.history = new ArrayList<>();
    }

    public void setOption(int optionNumber, int choice) {
        saveToHistory();
        model.setOption(optionNumber, choice);
    }

    public int getOption(int optionNumber) {
        return model.getOption(optionNumber);
    }

    public void setIsSelected(boolean isSelected) {
        saveToHistory();
        model.setIsSelected(isSelected);
    }

    public boolean getIsSelected() {
        return model.getIsSelected();
    }

    public void undo() {
        if (!history.isEmpty()) {
            System.out.println("Memento found in history");

            // save the current state for redo
            redoHistory.add(model.createMemento());

            IMemento previousState = history.remove(history.size() - 1);
            model.restoreState(previousState);

            gui.updateGui();
        }
    }

    public void redo() {
        if (!redoHistory.isEmpty()) {
            // Save current state for undo
            history.add(model.createMemento());

            // Get the last undone state
            IMemento nextState =
                    redoHistory.remove(redoHistory.size() - 1);

            model.restoreState(nextState);
            gui.updateGui();
        }
    }

    private void saveToHistory() {
        IMemento currentState = model.createMemento();
        history.add(currentState);

        redoHistory.clear();
    }

    public void restoreHistoryState(IMemento state) {
        if (state != null) {
            redoHistory.clear();
            model.restoreState(state);
            gui.updateGui();
        }
    }

    public void openHistoryWindow() {
        Stage historyStage = new Stage();

        ListView<IMemento> listView = new ListView<>();

        // Show the saved states
        listView.getItems().addAll(history);

        // Also show the current state
        listView.getItems().add(model.createMemento());

        // Display each state's timestamp
        listView.setCellFactory(list -> new ListCell<>() {
            @Override
            protected void updateItem(IMemento item, boolean empty) {
                super.updateItem(item, empty);

                if (empty || item == null) {
                    setText(null);
                } else {
                    setText(item.getTimestamp());
                }
            }
        });

        // Restore the selected state
        listView.getSelectionModel()
                .selectedItemProperty()
                .addListener((observable, oldState, newState) -> {
                    if (newState != null) {
                        restoreHistoryState(newState);
                    }
                });

        VBox layout = new VBox(listView);
        VBox.setVgrow(listView, Priority.ALWAYS);

        Scene scene = new Scene(layout, 350, 400);

        historyStage.setTitle("Model History");
        historyStage.setScene(scene);
        historyStage.show();
    }
}