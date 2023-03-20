package com.example.learnspringaopsec17.aop.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

	public int[] retrieveData() {
		return new int[] {33, 45, 60, 80, 12};
	}
}
