
package org.example.Flyweight;
public class RoadTile extends Tile {
    @Override
    public char getCharacter() {
        return 'R';
    }

    @Override
    public String getDescription() {
        return "road";
    }

    @Override
    public void action() {
    }
}


