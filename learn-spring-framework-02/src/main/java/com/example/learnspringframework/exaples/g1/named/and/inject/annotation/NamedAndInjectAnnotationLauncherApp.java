package com.example.learnspringframework.exaples.g1.named.and.inject.annotation;

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


//@Named
@Component
class ClassA {
//	@Inject
	@Autowired
	ClassB classB;
}

@Component 
class ClassB {
	
}

@ComponentScan
public class NamedAndInjectAnnotationLauncherApp {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(NamedAndInjectAnnotationLauncherApp.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println();
			
		}
	}

}
