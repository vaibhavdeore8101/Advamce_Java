package com.designpatterns.creational;

public class SingletonLazy {
	
	private static SingletonLazy singletonLazy;
	
	public SingletonLazy() {
		System.out.println("Constructor is invoked");
	}
	
	public static SingletonLazy getObject() {
		if(singletonLazy==null) {
			singletonLazy=new SingletonLazy();
		}
		return singletonLazy;
	}

}
