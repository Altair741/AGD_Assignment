package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class MyGdxGame extends Game implements ApplicationListener {

	// The class with the menu
	public static MenuScreen menuScreen;

	// The class with the game
	public static GameScreen gameScreen;
	private SpriteBatch batch;

	private Player player;
	//private Enemy enemy;

	private float speed = 50f;


	@Override
	public void create() {
		Gdx.app.log("MyGdxGame: "," create");
		gameScreen = new GameScreen();
		menuScreen = new MenuScreen(this);
		Gdx.app.log("MyGdxGame: ","about to change screen to menuScreen");
		// Change screens to the menu
		setScreen(menuScreen);
		Gdx.app.log("MyGdxGame: ","changed screen to menuScreen");

		this.batch = new SpriteBatch();
		this.player = new Player("player.png");
		//this.enemy  = new Enemy("enemy.png");
		}


	@Override
	public void dispose() {
		super.dispose();
		this.player.dispose();
		//this.enemy.dispose();
		this.batch.dispose();

	}

	@Override
	// this method calls the super class render
	// which in turn calls the render of the actual screen being used
	public void render() {
		this.update();

		// Clear the screen
		ScreenUtils.clear(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		// Start the batch
		this.batch.begin();
		this.player.render(this.batch);
		//this.enemy.render(this.batch);
		// End the batch
		this.batch.end();
	}
	/**
	 * Updates the game each tick.
	 */
	public void update() {
		this.player.update();
		//this.enemy.update(this.player);
	}
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}
}