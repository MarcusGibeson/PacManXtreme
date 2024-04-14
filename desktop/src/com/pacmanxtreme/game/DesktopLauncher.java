package com.pacmanxtreme.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.pacmanxtreme.game.PacManXtreme;

// Please note that on macOS your application needs to be started with the -XstartOnFirstThread JVM argument
public class DesktopLauncher {
	public static void main(String[] arg) {
		// Initialize grid
		int gridSizeX = 640;
		int gridSizeY = 480;
		int cellSize = 10;
		int[][] wallPositions = PacmanLevel1Maze.getWallPositions();
		Grid grid = new Grid(wallPositions, gridSizeX, gridSizeY, cellSize);

		//Set grid size and grid for nodes
		Node.setGridSize(gridSizeX, gridSizeY);
		Node.setGrid(grid.getNodes());

		// Configure and start the application
		Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
		config.setForegroundFPS(60);
		config.setTitle("PacManXtreme");
		new Lwjgl3Application(new PacManXtreme(grid), config);
	}
}


