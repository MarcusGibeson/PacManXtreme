package com.pacmanxtreme.game;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node> {

    int x;
    int y;
    boolean passable;
    List<Node> neighbors;
    int cost;
    Node parent;

    //grid size
    private static int gridSizeX;
    private static int gridSizeY;
    private static Node[][] grid;

    public Node(int x, int y, boolean passable) {
        this.x = x;
        this.y = y;
        this.passable = passable;
        this.neighbors = new ArrayList<>();
        this.cost = Integer.MAX_VALUE;
        this.parent = null;
    }

    //Set grid size
    public static void setGridSize(int sizeX, int sizeY) {
        gridSizeX = sizeX;
        gridSizeY = sizeY;
    }

    public static void setGrid(Node[][] grid) {
        Node.grid = grid;
    }

    //add neighbor
    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    //access and modify node properties
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void setX() {
        this.x = x;
    }

    public void setY() {
        this.y = y;
    }

    public boolean isPassable() {
        return passable;
    }

    public void setPassable(boolean passable) {
        this.passable = passable;
    }

    //Get list of neighbors
    public List<Node> getNeighbors() {
        List<Node> neighbors = new ArrayList<>();

        // Check adjacent nodes (up, down, left, right)
        // Assuming nodes are stored in a 2D grid
        // Adjust the conditions based on your grid layout
        // Add conditions to handle edge cases if necessary

        // Up
        if (y < gridSizeY - 1) {
            neighbors.add(grid[x][y + 1]);
        }

        // Down
        if (y > 0) {
            neighbors.add(grid[x][y - 1]);
        }

        // Left
        if (x > 0) {
            neighbors.add(grid[x - 1][y]);
        }

        // Right
        if (x < gridSizeX - 1) {
            neighbors.add(grid[x + 1][y]);
        }

        return neighbors;
    }

    public void setNeighbors(List<Node> neighbors) {
        this.neighbors = neighbors;
    }

    public int getCost() { return cost;}

    public void setCost(int cost) { this.cost = cost; }

    public Node getParent() { return parent;}

    public void setParent(Node parent) { this.parent = parent;}

    //add method to calculate distance between nodes
    public double distanceTo(Node other) {
        int dx= other.x - this.x;
        int dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    //comparable implementation for priority queue
    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.cost, other.cost);
    }

}
