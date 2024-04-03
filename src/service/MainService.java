package service;

import datastr.MyLinkedList;

public class MainService {

	public static void main(String[] args) {
		MyLinkedList<Integer> myList = new MyLinkedList<Integer>();
		try {
			
			myList.add(23);
			myList.add(100);
			myList.add(-5);
			myList.print();//23 100 -5
			myList.add(-1000, 1);
			myList.print();//23 -1000 100 -5
			myList.remove(2);
			myList.print();//23 -1000 -5
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
