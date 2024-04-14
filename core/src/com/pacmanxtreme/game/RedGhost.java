package com.pacmanxtreme.game;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;

import java.util.ArrayList;
import java.util.List;

public class RedGhost extends Ghost {
    Node[][] grid;
    int gridSizeX;
    int gridSizeY;
    Sprite sprite;

    private Pacman pacman;

    private List<Node> pathToTarget;

    public RedGhost(float initialX, float initialY, int xSpeed, int ySpeed, String spritePath, String upSpritePath, String downSpritePath, String leftSpritePath, String rightSpritePath, ArrayList<Wall> walls, Pacman pacman, Node[][] grid, int gridSizeX, int gridSizeY) {
        super(initialX, initialY, xSpeed, ySpeed, spritePath, upSpritePath, downSpritePath, leftSpritePath, rightSpritePath, walls);
        this.pacman = pacman;
        this.grid = grid;
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
        this.sprite = new Sprite(new Texture(spritePath));
        this.sprite.setPosition(initialX,initialY);


//    // Log the initial position and grid indices
//        System.out.println("Ghost position: (" + initialX + ", " + initialY + ")");
//        System.out.println("Grid indices: (" + MathUtils.floor(initialX) + ", " + MathUtils.floor(initialY) + ")");
}
    public Node getCurrentNode() {
        int gridX = MathUtils.floor(x);
        int gridY = MathUtils.floor(y);
        //debug
        System.out.println("Ghost position: (" + x + ", " + y + ")");
        System.out.println("Grid indices: (" + gridX + ", " + gridY + ")");

        Node currentNode = grid[gridX][gridY];
        System.out.println(currentNode);
        if (gridX >= 0 && gridX < gridSizeX && gridY >= 0 && gridY < gridSizeY) {
            return currentNode;
        }else {
            return null;
        }
    }
    private Node getPacmanCurrentNode() {
        if(pacman != null) {
            System.out.println("Player position has been returned.");
            return pacman.getCurrentNode();
        } else {
            System.out.println("Player position is null.");
            return null;
        }

    }

    @Override
    public void update(float deltaTime) {
        System.out.println("RedGhost update method called");
        Node playerNode = getPacmanCurrentNode();
        //Find path to player's position
        pathToTarget = findPathToPlayer(playerNode);
//        System.out.println("Player node: (" + playerNode.getX() + ", " + playerNode.getY() + ")");


        //Log current node's position
        Node startNode = getCurrentNode();
        if (startNode != null){
            System.out.println("Start node position: (" + startNode.getX() + ", " + startNode.getY() + ")");
        }else {
            System.out.println("Start node is null.");
        }

        //Move towards the player along the path
        if(pathToTarget != null && !pathToTarget.isEmpty()) {
            Node nextNode = pathToTarget.get(0);
//            System.out.println("Path to target: " + pathToTarget);
            MoveTo(nextNode, deltaTime);

            // Check if the ghost has reached the last node in the path
            if (getX() == nextNode.getX() && getY() == nextNode.getY()) {
                // Remove the reached node from the path
                pathToTarget.remove(0);
            }
        } else {
//            //If no path, continue moving based on current speed
//            float movementX = getXSpeed() * deltaTime;
//            float movementY = getYSpeed() * deltaTime;
//            System.out.println("Movement X: " + movementX + ", Movement Y: " + movementY);
//            int newX = Math.round(getX() + movementX);
//            int newY = Math.round(getY() + movementY);
//            System.out.println("New sprite position: (" + newX + ", " + newY + ")");
//            setPosition(newX, newY);
        }

        sprite.setPosition(getX(), getY());
    }



    private List<Node> findPathToPlayer(Node playerNode) {
        //Check if playerNode is null
        if (playerNode == null) {
            System.out.println("Player node is null.");
            return null;
        }

        Node startNode = getCurrentNode();
        if (startNode != null) {
            System.out.println("Start node: (" + startNode.getX() + ", " + startNode.getY() + ")");
            System.out.println("Player node: (" + playerNode.getX() + ", " + playerNode.getY() + ")");
            //Use A* pathfinding to calculate path from current node to player node
            List<Node> path = AStarPathfinder.findPath(startNode, playerNode);

            //Log the path for debugging
            if (path != null) {
                //remove first node from the path if it is the same as the starting Node of the ghost
                if (!path.isEmpty() && !path.get(0).equals(startNode)) {
                    System.out.println("Removing first node. Equal to ghost's position.");
                    path.remove(0);
                }
                for (Node node : path) {
                    System.out.println("Node: (" + node.getX() + "," + node.getY() + ")");
                }
            } else {
                System.out.println("No path found.");
            }
            return path;
        } else {
            System.out.println("Start node is null");
            return null;
        }

    }

    @Override
    public void render(SpriteBatch batch) {
        sprite.draw(batch);
    }
    public void renderPath(ShapeRenderer shapeRenderer) {
        if (pathToTarget != null && !pathToTarget.isEmpty()) {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
            shapeRenderer.setColor(Color.RED);
            for(int i = 0; i < pathToTarget.size() - 1; i++) {
                Node currentNode = pathToTarget.get(i);
                Node nextNode = pathToTarget.get(i + 1);
                shapeRenderer.line(currentNode.getX(), currentNode.getY(), nextNode.getX(), nextNode.getY());
            }
            shapeRenderer.end();
        }
    }

    private void MoveTo(Node nextNode, float deltaTime) {
        float positionThreshold = 0.01f;

        //check if the ghost is already at the target node
        if (Math.abs(getX() - nextNode.getX()) < positionThreshold && Math.abs(getY() - nextNode.getY()) < positionThreshold) {
            //remove node from the path
            pathToTarget.remove(0);
            System.out.println("Ghost is already at the target node");
            return;
        }

        //Calculate the distance and direction to the next node
        float dx = nextNode.getX() - getX();
        float dy = nextNode.getY() - getY();
        float distanceToNextNode = (float) Math.sqrt(dx * dx + dy * dy);
        System.out.println("Distance to next node: " + distanceToNextNode);

        //Determine the movement speed based on deltaTime and ghost's speed
        float movementSpeedX = getXSpeed() * deltaTime;
        System.out.println("Movement speed on x-axis: " + movementSpeedX);
        float movementSpeedY = getYSpeed() * deltaTime;
        System.out.println("Movement speed on y-axis: " + movementSpeedY);

        //If the distance to the next node is greater than the movement speed,
        //move towards the next node. Otherwise, directly set the ghost's position to the next node.
        if (distanceToNextNode <= Math.max(movementSpeedX, movementSpeedY)) {
            //Move towards next node
            System.out.println("Not rounded. Moving to (" + nextNode.getX() + ", " + nextNode.getY() + " ).");
            setPosition(nextNode.getX(), nextNode.getY());
            pathToTarget.remove(0);
        } else {
            //Calculate the movement ratio to ensure smooth movement
            float movementRatioX = movementSpeedX / distanceToNextNode;
            float movementRatioY = movementSpeedY / distanceToNextNode;
            float newX = getX() + dx * movementRatioX;
            float newY = getY() + dy * movementRatioY;

            //Round the float positions to the nearest integer value
            int roundedX = Math.round(newX);
            int roundedY = Math.round(newY);
            System.out.println("(X,Y) rounded. Moving to (" + roundedX + ", " + roundedY + " ).");
            //update the ghost's position
            setPosition(roundedX, roundedY);
        }
    }

}
