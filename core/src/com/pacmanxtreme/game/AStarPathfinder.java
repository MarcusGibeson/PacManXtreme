package com.pacmanxtreme.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class AStarPathfinder {
    public static List<Node> findPath(Node start, Node goal) {

        //Initialize open and closed lists
        PriorityQueue<Node> openList = new PriorityQueue<>();
        HashSet<Node> closedList = new HashSet<>();

        start.setCost(0);
        openList.add(start);

        while(!openList.isEmpty()) {
            //Get the node with the lowest cost from the open list
            Node current = openList.poll();

            //If the current node is the goal, reconstruct and return the path
            if (current.equals(goal)) {
                return reconstructPath(current);
            }

            closedList.add(current);

            //Iterate through neighbors of the current node
            for (Node neighbor : current.getNeighbors()) {
                if (!neighbor.isPassable() || closedList.contains(neighbor)) {
                    continue;
                }

                //Calculate the cost to reach the neighbor
                int tentativeCost = current.getCost() + calculateCost(current, neighbor);

                if (tentativeCost < neighbor.getCost() || !openList.contains(neighbor)) {
                    neighbor.setCost(tentativeCost);
                    neighbor.setParent(current);

                    if(!openList.contains(neighbor)) {
                        openList.add(neighbor);
                    }
                }
            }
        }

        //no path found
        return null;
    }

    private static List<Node> reconstructPath(Node current) {
        List<Node> path = new ArrayList<>();
        while (current != null) {
            path.add(current);
            current = current.getParent();
        }
        Collections.reverse(path);
        return path;
    }

    private static int calculateCost(Node from, Node to) {
        //Calculate the cost to mvoe from node "from" to node "to"
        int distance = Math.abs(from.getX() - to.getX() - to.getX()) + Math.abs(from.getY() - to.getY());
        int baseCost = 1; // base cost

        int totalCost = baseCost * distance;
        return totalCost;
    }

}
