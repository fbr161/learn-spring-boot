package com.example.learnspringframework.gamelauncherbasic01;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.learnspringframework.game.GameInterface;
import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.PacmanGame;
import com.example.learnspringframework.game.SuperContra;
import com.example.learnspringframework.game.MarioGame;

@Configuration
public class App01GameConfig {

	@Bean
	@Qualifier
	public GameInterface pacmanGame() {
		return new PacmanGame();
	}
	
	@Bean
	@Primary
	public GameInterface marioGame() {
		return new MarioGame();
	}
	
	@Bean
	@Qualifier
	public GameInterface superContra() {
		return new SuperContra();
	}
	
	@Bean
	@Primary
	public GameRunner runner(GameInterface game) {
		return new GameRunner(game);
	}
	
	@Bean
	public GameRunner pacmanRunner(@Qualifier("pacmanGame") GameInterface game) {
		return new GameRunner(game);
	}
	
	@Bean
	public GameRunner superContraRunner(@Qualifier("superContra") GameInterface game) {
		return new GameRunner(game);
	}
	
}
