package com.example.learnspringframework.exaples.a0;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Component
interface DataService { 
	int [] retrieveData(); 
}

@Component
@Primary
class MongoDBDataService implements DataService{

	@Override
	public int[] retrieveData() {
		return new int[] {11, 22, 33, 44, 55};
	}
	
}

@Component
@Qualifier("MySqlDataService")
class MySqlDataService implements DataService{

	@Override
	public int[] retrieveData() {
		return new int[] {1, 2, 3, 4, 5};
	}
	
}

@Component
class BusinessCalculationService {

//	@Autowired
//	@Qualifier("MySqlDataService")
	DataService dataService;
	
//	public BusinessCalculationService(@Qualifier("MySqlDataService") DataService dataService) {
//		super();
//		this.dataService = dataService;
//	}

	public int findMax() {
		return Arrays.stream(dataService.retrieveData()).max().orElse(0);
	}

	@Autowired
	public void setDataService(@Qualifier("MySqlDataService") DataService dataService) {
		this.dataService = dataService;
	}
	
}

@ComponentScan
public class SimpleSpringContextLanuncherApp {
	
	public static void main(String[] args) {
		try(var context = new AnnotationConfigApplicationContext(SimpleSpringContextLanuncherApp.class)) {
			
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			System.out.println();
			
			System.out.println(context.getBean(BusinessCalculationService.class).findMax());
		}
	}

}
