package com.pacmanxtreme.game;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;

import com.badlogic.gdx.backends.iosrobovm.IOSApplication;
import com.badlogic.gdx.backends.iosrobovm.IOSApplicationConfiguration;
import com.pacmanxtreme.game.PacManXtreme;

public class IOSLauncher extends IOSApplication.Delegate {
    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        int gridSizeX = 640;
        int gridSizeY = 480;
        int cellSize = 10;
        int[][] wallPositions = PacmanLevel1Maze.getWallPositions();
        Grid grid = new Grid(wallPositions, gridSizeX, gridSizeY, cellSize);
        return new IOSApplication(new PacManXtreme(grid), config);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, IOSLauncher.class);
        pool.close();
    }
}
