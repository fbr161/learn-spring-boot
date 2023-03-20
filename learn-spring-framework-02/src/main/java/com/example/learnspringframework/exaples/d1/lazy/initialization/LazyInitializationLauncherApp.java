package com.example.learnspringframework.exaples.d1.lazy.initialization;

import java.util.Arrays;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.learnspringframework.game.GameInterface;
import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.MarioGame;
import com.example.learnspringframework.game.PacmanGame;
import com.example.learnspringframework.game.SuperContra;

@Component
class ClassA {
	public ClassA () {
		System.out.println("initializing - ClassA");
	}
}

@Component
@Lazy
class ClassB {
	private ClassA classA;

	public ClassB(ClassA classA) {
		System.out.println("initializing - ClassB");
		this.classA = classA;
	}

	public ClassA getClassA() {
		return classA;
	}

	public void setClassA(ClassA classA) {
		this.classA = classA;
	}
	
	
	
}

@ComponentScan
public class LazyInitializationLauncherApp {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApp.class)) {
			
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
//			System.out.println(context.getBean(ClassB.class).getClassA() == context.getBean(ClassA.class));
			
		}
	}

}
