package com.db.stu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TestHello {
	public static <T> void DisplayArray(T[] anArray){
		for(T t:anArray)
		{
			System.out.println(t);
			System.out.println("----");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strArray []={"ABC","DEF","HIJ"};
		DisplayArray(strArray);
		Integer intArray []={1,2,3,4,5};
		DisplayArray(intArray);
		Map<Integer,String> map = new HashMap<>();
		map.put(1,"nice");
		map.put(2,"fantastic");
		System.out.println(map.get(2));
		
		
		

	}

}
