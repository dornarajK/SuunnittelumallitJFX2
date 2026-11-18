
package org.example.Flyweight;
public class SwampTile extends Tile {
    @Override
    public char getCharacter() {
        return 'S';
    }

    @Override
    public String getDescription() {
        return "swamp";
    }

    @Override
    public void action() {
    }
}


