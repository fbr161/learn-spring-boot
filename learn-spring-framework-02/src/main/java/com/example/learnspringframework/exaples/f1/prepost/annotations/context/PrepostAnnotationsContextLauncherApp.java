package com.example.learnspringframework.exaples.f1.prepost.annotations.context;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.learnspringframework.game.GameInterface;
import com.example.learnspringframework.game.GameRunner;
import com.example.learnspringframework.game.MarioGame;
import com.example.learnspringframework.game.PacmanGame;
import com.example.learnspringframework.game.SuperContra;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
class SomeClass {
	
	private SomeDependency dependency;
	
	SomeClass(SomeDependency dependency) {
		this.dependency = dependency;
		System.out.println("constructor - SomeClass");
	}
	
	@PostConstruct
	void init() {
		dependency.doSomething();
	}
	
	@PreDestroy
	void destroy() {
		System.out.println("destroy - SomeClass");
	}
}

@Component
class SomeDependency {
	void doSomething () {
		System.out.println("doing something - SomeDependency");
	}
}

@ComponentScan
public class PrepostAnnotationsContextLauncherApp {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(PrepostAnnotationsContextLauncherApp.class)) {
			
//			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			 
			System.out.println();
			
		}
	}

}
