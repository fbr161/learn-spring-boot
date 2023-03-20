package com.example.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	GameInterface game;
	
	public GameRunner(@Qualifier("SuperContra") GameInterface game) {
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
