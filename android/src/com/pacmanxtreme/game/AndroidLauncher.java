package com.pacmanxtreme.game;

import android.os.Bundle;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.pacmanxtreme.game.PacManXtreme;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		int gridSizeX = 640;
		int gridSizeY = 480;
		int cellSize = 10;
		int[][] wallPositions = PacmanLevel1Maze.getWallPositions();
		Grid grid = new Grid(wallPositions, gridSizeX, gridSizeY, cellSize);
		initialize(new PacManXtreme(grid), config);
	}
}
