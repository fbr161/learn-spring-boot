package com.example.learnspringframework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Qualifier("SuperContra")
public class SuperContra implements GameInterface {

	@Override
	public void up() {
		System.out.println("SuperContra - up");
		
	}

	@Override
	public void down() {
		System.out.println("SuperContra - down");
		
	}

	@Override
	public void left() {
		System.out.println("SuperContra - left");
		
	}

	@Override
	public void right() {
		System.out.println("SuperContra - right");
		
	}
}
