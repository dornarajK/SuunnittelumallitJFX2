
package org.example.Flyweight;
import java.util.Random;

public class WildernessMap extends Map {
    public WildernessMap(int width, int height) {
        super(width, height);
    }
    private static final Random RANDOM = new Random();

    @Override
    protected Tile createTile() {
        int choice = RANDOM.nextInt(3);
        return switch (choice) {
            case 0 -> new SwampTile();
            case 1 -> new WaterTile();
            default -> new ForestTile();
        };
    }


}


