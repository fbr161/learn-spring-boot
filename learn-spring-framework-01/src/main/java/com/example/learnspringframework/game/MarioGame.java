package com.example.learnspringframework.game;

public class MarioGame implements GameInterface {

	@Override
	public void up() {
		System.out.println("mario - up");
		
	}

	@Override
	public void down() {
		System.out.println("mario - down");
		
	}

	@Override
	public void left() {
		System.out.println("mario - left");
		
	}

	@Override
	public void right() {
		System.out.println("mario - right");
		
	}

}
