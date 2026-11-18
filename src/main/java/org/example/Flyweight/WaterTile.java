
package org.example.Flyweight;
public class WaterTile extends Tile {
    @Override
    public char getCharacter() {
        return 'W';
    }

    @Override
    public String getDescription() {
        return "water";
    }

    @Override
    public void action() {
    }
}


