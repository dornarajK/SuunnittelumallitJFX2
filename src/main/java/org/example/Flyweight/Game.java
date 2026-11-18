package org.example.Flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Game extends Application {
    public static final String MAP_TYPE = "city";
    public static final int MAP_WIDTH = 10;
    public static final int MAP_HEIGHT = 8;
    private static final int TILE_SIZE = 64;
    private static final TileGraphicFactory GRAPHIC_FACTORY = new TileGraphicFactory();

    public Map createMap(String type, int width, int height) {
        return switch (type) {
            case "city" -> new BuildingTile.CityMap(width, height);
            case "wilderness" -> new WildernessMap(width, height);
            default -> throw new IllegalArgumentException("Unknown map type: " + type);
        };
    }

    @Override
    public void start(Stage stage) {
        Map map = createMap(MAP_TYPE, MAP_WIDTH, MAP_HEIGHT);
        Canvas canvas = new Canvas();
        map.render(canvas, TILE_SIZE, GRAPHIC_FACTORY);

        StackPane root = new StackPane(canvas);
        root.setStyle("-fx-background-color: #263238; -fx-padding: 12;");
        stage.setTitle("RPG Map - Flyweight Rendering");
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.sizeToScene();
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
