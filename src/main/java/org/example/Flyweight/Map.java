package org.example.Flyweight;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public abstract class Map {
    protected final int width;
    protected final int height;
    protected final Tile[][] tiles;

    public Map(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Map dimensions must be positive");
        }
        this.width = width;
        this.height = height;
        this.tiles = new Tile[height][width];
    }

    protected abstract Tile createTile();

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile getTile(int x, int y) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            throw new IndexOutOfBoundsException("Tile position outside map: " + x + ", " + y);
        }
        if (tiles[y][x] == null) {
            tiles[y][x] = createTile();
        }
        return tiles[y][x];
    }

    /** Draws individual tile positions while reusing one graphic per terrain class. */
    public void render(Canvas canvas, int tileSize, TileGraphicFactory factory) {
        if (tileSize <= 0) {
            throw new IllegalArgumentException("Tile size must be positive");
        }
        canvas.setWidth((double) width * tileSize);
        canvas.setHeight((double) height * tileSize);
        GraphicsContext graphics = canvas.getGraphicsContext2D();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                factory.getGraphic(getTile(x, y)).draw(graphics, (double) x * tileSize,
                        (double) y * tileSize, tileSize);
            }
        }
    }

    /** Retained for the earlier console version of the assignment. */
    public void display() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(getTile(x, y).getCharacter());
            }
            System.out.println();
        }
    }
}
