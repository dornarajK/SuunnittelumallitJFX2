
package org.example.Flyweight;

import java.util.Random;

public class BuildingTile extends Tile {
    @Override
    public char getCharacter() {
        return 'B';
    }

    @Override
    public String getDescription() {
        return "building";
    }

    @Override
    public void action() {
    }

    public static class CityMap extends Map {
        public CityMap(int width, int height) {
            super(width, height);
        }

        private static final Random RANDOM = new Random();

        @Override
        protected Tile createTile() {
            int choice = RANDOM.nextInt(3);
            return switch (choice) {
                case 0 -> new RoadTile();
                case 1 -> new ForestTile();
                default -> new BuildingTile();
            };


        }

    }
}


