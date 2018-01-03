package com.zhenglinj.java.samples.annotations;

public class MyHouse implements House {
	@SuppressWarnings("deprecation")
    public void open() { System.out.println("This is method open()"); }
    public void openFrontDoor() {}
    public void openBackDoor() {}
    
    public static void main(String[] args) {
    	MyHouse myhouse = new MyHouse();
    	myhouse.open();
	}
}
