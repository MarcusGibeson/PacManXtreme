package com.pacmanxtreme.game;

import java.util.ArrayList;

public class RedGhost extends Ghost {
    private Pacman ball;

    public RedGhost(float initialX, float initialY, int xSpeed, int ySpeed, String spritePath, String upSpritePath, String downSpritePath, String leftSpritePath, String rightSpritePath, ArrayList<Wall> walls, Pacman ball) {
        super(initialX, initialY, xSpeed, ySpeed, spritePath, upSpritePath, downSpritePath, leftSpritePath, rightSpritePath, walls);
        this.ball = ball;
    }

    @Override
    public void update(float deltaTime) {
        //chase behavior
        float targetX = ball.getX();
        float targetY = ball.getY();


//        //Calculate path to Pac-Man's target position using pathfinding algorithm
//        ArrayList<Node> path = calculatePathToTarget(targetX, targetY);
//
//        followPath(path, deltaTime);
//

}
}
