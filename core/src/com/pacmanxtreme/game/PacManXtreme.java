package com.pacmanxtreme.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.ScreenUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;


public class PacManXtreme extends ApplicationAdapter {
	SpriteBatch batch;
	Stage stage;
	ShapeRenderer shape;
	Pacman pacman;
	ArrayList<Coin> coins;
	ArrayList<Wall> walls;
	ArrayList<Ghost> ghosts;
	RedGhost redGhost;

	int gridSizeX;
	int gridSizeY;
	int cellSize;

	Texture backgroundTexture;
	private Grid grid;

	public PacManXtreme(Grid grid) {
		this.grid = grid;
		this.gridSizeX = grid.getGridSizeX();
		this.gridSizeY = grid.getGridSizeY();
		this.cellSize = grid.getCellSize();
	}



	@Override
	public void create () {
		batch = new SpriteBatch();
		backgroundTexture = new Texture("pacmanlvl1.png");

		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		shape = new ShapeRenderer();
		pacman = new Pacman(325, 125,20, grid.getNodes(), gridSizeX, gridSizeY);
		coins = new ArrayList<>();
		walls = new ArrayList<>();
		ghosts = new ArrayList<>();

		//add coins
		int[][] coinPositions = PacmanLevel1Maze.getCoinPositions();
		for(int[] position : coinPositions) {
			coins.add(new Coin(position[0], position[1], 3));
		}

		//add maze walls
		int[][] wallPositions = PacmanLevel1Maze.getWallPositions();
		for(int[] position : wallPositions) {
			walls.add(new Wall(position[0], position[1], position[2], position[3]));
		}

		//ghost
		redGhost = new RedGhost(260,230, 100, 100,"data/red/redGhostCenter.png", "data/red/redGhostUp.png", "data/red/redGhostDown.png", "data/red/redGhostLeft.png","data/red/redGhostRight.png", walls, pacman, grid.getNodes(),gridSizeX, gridSizeY);
		ghosts.add(redGhost);
		Ghost greenGhost = new Ghost(300, 230, 0, -30, "data/green/greenGhostCenter.png", "data/green/greenGhostUp.png", "data/green/greenGhostDown.png", "data/green/greenGhostLeft.png", "data/green/greenGhostRight.png", walls);
		ghosts.add(greenGhost);
		Ghost yellowGhost = new Ghost (340, 230, -30, 0, "data/yellow/yellowGhostCenter.png", "data/yellow/yellowGhostUp.png","data/yellow/yellowGhostDown.png","data/yellow/yellowGhostLeft.png","data/yellow/yellowGhostRight.png",walls);
		ghosts.add(yellowGhost);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		ScreenUtils.clear(0,0,0,0);

//		batch.begin();
//
//		batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//
//		batch.end();

//		shape.begin(ShapeRenderer.ShapeType.Line);
//		shape.setColor(Color.WHITE);
//
//		for (int x = 0; x <= gridSizeX; x += cellSize) {
//			shape.line(x, 0, x, gridSizeY);
//		}
//
//		for (int y = 0; y <= gridSizeY; y += cellSize) {
//			shape.line(0, y, gridSizeX, y);
//		}
//		shape.end();

		stage.draw();
		shape.begin(ShapeRenderer.ShapeType.Filled);

		//wall
		for (Wall wall : walls) {
			wall.draw(shape);
		}

		//update and draw player
		pacman.update();
		pacman.updatePosition(walls);
		shape.setColor(pacman.color);
		shape.circle(pacman.x, pacman.y, pacman.size);
		shape.end();

		//draw coins
		for(Coin coin: coins) {
			coin.draw(shape);
		}

		//draw ghosts
		batch.begin();
//		for (Ghost ghost : ghosts) {
//			ghost.update(Gdx.graphics.getDeltaTime());
//			ghost.render(batch);
//		}

		if (redGhost != null) {
			redGhost.update(Gdx.graphics.getDeltaTime());
			redGhost.render(batch);
			System.out.println("Red Ghost position: (" + redGhost.getX() + ", " + redGhost.getY() + ")");
			redGhost.renderPath(shape);

		}
		batch.end();

		//check collisions
		pacman.checkCollision(coins);

		//check if all coins are collected
		if (allCoinsCollected()) {
			//end game
		}

	}

	private boolean allCoinsCollected() {
		for (Coin coin : coins) {
			if (!coin.isCollected()) {
				return false;
			}
		}
		return true;
	}

}
