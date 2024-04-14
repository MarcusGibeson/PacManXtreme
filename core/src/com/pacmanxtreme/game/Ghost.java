package com.pacmanxtreme.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

public class Ghost {
    float x;
    float y;
    int size;
    int xSpeed;
    int ySpeed;


    ArrayList<Wall> walls;
    Texture ghostTexture;
    Texture ghostUpTexture;
    Texture ghostDownTexture;
    Texture ghostLeftTexture;
    Texture ghostRightTexture;

    Sprite ghostSprite;

    public Ghost(float initialX, float initialY, int xSpeed, int ySpeed, String spritePath, String upSpritePath, String downSpritePath, String leftSpritePath, String rightSpritePath, ArrayList<Wall> walls) {
        ghostTexture = new Texture(Gdx.files.internal(spritePath));
        ghostUpTexture = new Texture(Gdx.files.internal(upSpritePath));
        ghostDownTexture = new Texture(Gdx.files.internal(downSpritePath));
        ghostLeftTexture = new Texture(Gdx.files.internal(leftSpritePath));
        ghostRightTexture = new Texture(Gdx.files.internal(rightSpritePath));


        ghostSprite = new Sprite(ghostTexture);

        this.x = initialX;
        this.y = initialY;
        this.walls = walls;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;

        this.size = (int) Math.max(ghostSprite.getWidth(), ghostSprite.getHeight());

        ghostSprite.setPosition(x, y);
    }

    public float getX() {return x;}
    public float getY() {return y;}

    public int getXSpeed() {return xSpeed;}
    public int getYSpeed() {return ySpeed;}

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void render(SpriteBatch batch) {
        ghostSprite.draw(batch);
    }


    public void update(float deltaTime) {
        float newX = x + xSpeed * deltaTime;
        float newY = y + ySpeed * deltaTime;

        // Update the ghost's position only if it's not colliding with a wall
        if (!collidesWithWall(newX, newY)) {
            x = newX;
            y = newY;
            ghostSprite.setPosition(newX, newY);
        }
        else {
            changeDirection();
        }

    }

    private boolean collidesWithWall(float newX, float newY) {
        for (Wall wall : walls) {
            if (newX < wall.x + wall.width &&
                    newX + size > wall.x &&
                    newY < wall.y + wall.height &&
                    newY + size > wall.y) {
                return true; // Collision detected
            }
        }
        return false; // No collision detected
    }

    private void changeDirection() {
        int speed = xSpeed + ySpeed;

        if (xSpeed != 0) {
            //if moving horizontally, switch to vertical
            if (xSpeed > 0) {
                //moving right, so switching to moving down
                xSpeed = 0;
                ySpeed = -speed;
            } else {
                //moving left, so switching to moving up
                xSpeed = 0;
                ySpeed = speed;
            }
        } else {
            //if moving vertically, switch to horizontal
            if (ySpeed > 0) {
                //moving up, switch to right
                xSpeed = speed;
                ySpeed = 0;
            } else {
                //moving down, switch to left
                xSpeed = -speed;
                ySpeed = 0;
            }
        }


        updateSpriteDirection();
    }

    private void updateSpriteDirection() {
        //change sprite based on direction
        if (xSpeed > 0) {
            ghostSprite.setTexture(ghostRightTexture);
        } else if (xSpeed < 0) {
            ghostSprite.setTexture(ghostLeftTexture);
        } else if (ySpeed > 0) {
            ghostSprite.setTexture(ghostUpTexture);
        } else if (ySpeed < 0) {
            ghostSprite.setTexture(ghostDownTexture);
        }
    }


}
