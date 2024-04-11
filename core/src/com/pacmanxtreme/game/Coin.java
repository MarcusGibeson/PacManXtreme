package com.pacmanxtreme.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Coin {
    float x;
    float y;
    float size;
    boolean isCollected;

    Color color = Color.WHITE;

    public Coin(float x, float y, float size) {
        this.x = x;
        this.y = y;
        this.size = 3;
        this.isCollected = false;
    }

    public void draw(ShapeRenderer shape) {
        if(!isCollected) {
            shape.begin(ShapeRenderer.ShapeType.Filled);
            shape.setColor(color);

            shape.circle(x,y,size);
            shape.end();
        }
    }

    public boolean isCollected() {
        return isCollected;
    }

    public void setCollected(boolean collected) {
        isCollected = collected;
    }
}
