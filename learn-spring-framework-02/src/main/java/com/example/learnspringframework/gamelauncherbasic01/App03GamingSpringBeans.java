package com.example.learnspringframework.gamelauncherbasic01;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.learnspringframework.game.GameInterface;
import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.MarioGame;
import com.example.learnspringframework.game.PacmanGame;
import com.example.learnspringframework.game.SuperContra;

record Address(String name) {};

@Configuration
@ComponentScan("com.example.learnspringframework.game")
public class App03GamingSpringBeans {
	
//	@Bean
//	public GameRunner runner(GameInterface game) {
//		return new GameRunner(game);
//	}
	
//	@Bean
//	public GameRunner pacmanRunner(@Qualifier("pacmanGame") GameInterface game) {
//		return new GameRunner(game);
//	}
//	
//	@Bean
//	public GameRunner superContraRunner(@Qualifier("superContra") GameInterface game) {
//		return new GameRunner(game);
//	}
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App03GamingSpringBeans.class)) {
			var runner = (GameRunner) context.getBean(GameRunner.class);
			
			runner.run();
		}
	}

}
