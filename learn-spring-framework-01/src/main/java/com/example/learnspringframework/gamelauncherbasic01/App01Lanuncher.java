package com.example.learnspringframework.gamelauncherbasic01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.learnspringframework.game.GameRunner;

record Address(String name) {};

public class App01Lanuncher {

	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(App01GameConfig.class)) {
			var runner = (GameRunner) context.getBean("pacmanRunner");
			
			runner.run();
		}
	}

}
