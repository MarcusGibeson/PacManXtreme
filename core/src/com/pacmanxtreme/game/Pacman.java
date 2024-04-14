package com.pacmanxtreme.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;

public class Pacman {
    Node[][] grid;
    int gridSizeX;
    int gridSizeY;
    float x;
    float y;
    int size;

    float speed = 150.0f;
    float xSpeed;
    float ySpeed;


    Color color = Color.YELLOW;

    public Pacman(float x, float y, int size, Node[][] grid, int gridSizeX, int gridSizeY) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.grid = grid;
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;

    }

    public float getX(){
        return x;
    }
    public float getY() {
        return y;
    }


    public Node getCurrentNode() {
        //Ensure that the grid is initialized
        if (grid == null || gridSizeX <= 0 || gridSizeY <= 0) {
            System.err.println("Grid is not properly initialized.");
            return null;
        }

        //calculate the grid position based on Pacman's coordinates
        int gridX = MathUtils.floor(x);
        int gridY = MathUtils.floor(y);

        if (gridX >= 0 && gridX < gridSizeX && gridY >= 0 && gridY < gridSizeY) {
            //return the corresponding node from the grid
            Node playerNode = grid[gridX][gridY];
            System.out.println(playerNode);
            return playerNode;
        } else {
            //Pacman is outside the grid
            System.out.println("Pacman is null, pacman is outside of grid area");
            return null;
        }
    }


    public void update() {
        if (x < 0) {
            x = Gdx.graphics.getWidth();
        } else if (x > Gdx.graphics.getWidth()){
            x = 0;
        }
        if (y < 0) {
            y = Gdx.graphics.getHeight();
        } else if (y > Gdx.graphics.getHeight()) {
            y = 0;
        }
    }
    public void updatePosition(ArrayList<Wall> walls) {
        if(Gdx.input.isKeyPressed(Input.Keys.W)) {
            xSpeed = 0;
            ySpeed = speed;
        }
        if(Gdx.input.isKeyPressed(Keys.DPAD_UP)) {
            xSpeed = 0;
            ySpeed = speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.A)) {
            xSpeed = -speed;
            ySpeed = 0;
        }
        if(Gdx.input.isKeyPressed(Keys.DPAD_LEFT)) {
            xSpeed = -speed;
            ySpeed = 0;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)) {
            xSpeed = 0;
            ySpeed = -speed;
        }
        if(Gdx.input.isKeyPressed(Keys.DPAD_DOWN)) {
            xSpeed = 0;
            ySpeed = -speed;
        }
        if(Gdx.input.isKeyPressed(Input.Keys.D)) {
            xSpeed = speed;
            ySpeed = 0;
        }
        if(Gdx.input.isKeyPressed(Keys.DPAD_RIGHT)) {
            xSpeed = speed;
            ySpeed = 0;
        }

        if (Gdx.input.isKeyPressed(Keys.SPACE)) {
            size = 25;
        } else {
            size = 10;
        }
        // Move the pacman based on current speed
        x += Gdx.graphics.getDeltaTime() * xSpeed;
        y += Gdx.graphics.getDeltaTime() * ySpeed;

        // Calculate the next position based on current speed
        float nextX = x + xSpeed * Gdx.graphics.getDeltaTime();
        float nextY = y + ySpeed * Gdx.graphics.getDeltaTime();

        // Check if the next position is within bounds
        if (nextX < 0 || nextX + size > Gdx.graphics.getWidth() || nextY < 0 || nextY + size > Gdx.graphics.getHeight()) {
            return; // Exit the method if the next position is out of bounds
        }

        // Check for collisions with walls
        for (Wall wall : walls) {
            if (nextX < wall.x + wall.width &&
                    nextX + size > wall.x &&
                    nextY < wall.y + wall.height &&
                    nextY + size > wall.y) {
                // Adjust the pacman's position to just outside the wall's bounds
                if (xSpeed > 0) {
                    x = wall.x - size;
                } else if (xSpeed < 0) {
                    x = wall.x + wall.width + size;
                    xSpeed = 0;
                }
                if (ySpeed > 0) {
                    y = wall.y - size;
                } else if (ySpeed < 0) {
                    y = wall.y + wall.height + size;
                    ySpeed=0;
                }
                return; // Exit the method
            }
        }
    }

    public void checkCollision(ArrayList<Coin> coins) {
        for (Coin coin : coins) {
            if(collidesWith(coin)) {
                coin.setCollected(true);
            }
        }
    }


    private boolean collidesWith(Coin coin) {
        float pacmanLeft = x;
        float pacmanRight = x+size;
        float pacmanTop = y+size;
        float pacmanBottom = y;

        float coinLeft = coin.x;
        float coinRight = coin.x+coin.size;
        float coinTop = coin.y + coin.size;
        float coinBottom = coin.y;

        return pacmanRight >= coinLeft && pacmanLeft <= coinRight && pacmanBottom <= coinTop && pacmanTop >= coinBottom;
    }
}
