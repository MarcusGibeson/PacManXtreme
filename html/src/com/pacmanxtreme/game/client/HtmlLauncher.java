package com.pacmanxtreme.game.client;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.backends.gwt.GwtApplication;
import com.badlogic.gdx.backends.gwt.GwtApplicationConfiguration;
import com.pacmanxtreme.game.Grid;
import com.pacmanxtreme.game.PacManXtreme;
import com.pacmanxtreme.game.PacmanLevel1Maze;

public class HtmlLauncher extends GwtApplication {

        @Override
        public GwtApplicationConfiguration getConfig () {
                // Resizable application, uses available space in browser
                return new GwtApplicationConfiguration(true);
                // Fixed size application:
                //return new GwtApplicationConfiguration(480, 320);
        }

        @Override
        public ApplicationListener createApplicationListener() {
                int gridSizeX = 640;
                int gridSizeY = 480;
                int cellSize = 10;
                int[][] wallPositions = PacmanLevel1Maze.getWallPositions();
                Grid grid = new Grid(wallPositions, gridSizeX, gridSizeY, cellSize);
                return new PacManXtreme(grid);
        }
}