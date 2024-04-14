package com.pacmanxtreme.game;

public class Grid {

    private Node[][] nodes;
    private int gridSizeX;
    private int gridSizeY;
    private int cellSize;



    public Grid(int[][] wallPositions, int gridSizeX, int gridSizeY, int cellSize) {
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
        this.cellSize = cellSize;
        this.nodes = new Node[gridSizeX][gridSizeY];


        //Initialize grid with nodes
        for (int x = 0; x < gridSizeX; x++){
            for (int y = 0; y < gridSizeY; y++) {
                boolean passable = true;

                //Check if the current cell overlaps with any wall position
                for (int[] wall : wallPositions) {
                    int wallX = wall[0];
                    int wallY = wall[1];
                    int wallWidth = wall[2];
                    int wallHeight = wall[3];

                if (x >= wallX && x < wallX + wallWidth && y >= wallY && y < wallY + wallHeight) {
                    passable = false;
                    break;
                    }
                }

                //create node and mark as passable or impassable
                nodes [x][y] = new Node(x, y, passable);
            }
        }
    }

    public Node[][] getNodes() {
        return nodes;
    }

    public void printGrid() {
        for (int y=0; y < gridSizeY; y++) {
            for (int x = 0; x < gridSizeX; x++) {
                if (nodes[x][y].isPassable()) {
                    System.out.print("0"); //passable node
                } else {
                    System.out.print("X"); //impassable node
                }
            }
            System.out.println(); //move to next row
        }
    }

    public int getGridSizeX() {
        return gridSizeX;
    }

    public int getGridSizeY() {
        return gridSizeY;
    }

    public int getCellSize() {
        return cellSize;
    }

    //other methods for manipulating the grid
}
