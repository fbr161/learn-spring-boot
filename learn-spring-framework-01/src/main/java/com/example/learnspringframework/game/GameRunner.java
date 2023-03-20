package com.example.learnspringframework.game;

public class GameRunner {

	GameInterface game;
	
	public GameRunner(GameInterface game) {
		this.game = game;
	}
	
	public void run() {
		System.out.println(game);
		game.up();
		game.down();
		game.right();
		game.left();
	}
}
