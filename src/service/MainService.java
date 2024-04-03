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
			myList.add(200);
			myList.add(1000);
			myList.print();//23 -1000 -5 200 1000
			System.out.println("get (2): " + myList.get(2));//-5
			System.out.println("search (3): " + myList.search(3));//false
			System.out.println("search (200): " + myList.search(200));//true
			myList.makeEmpty();
			myList.add(5000);
			myList.print();//5000
			
			//TODO pārliecināties, lai strādā ar Student klasi
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		

	}

}
