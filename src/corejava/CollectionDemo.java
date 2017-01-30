package corejava;

import java.util.Stack;
import java.util.Vector;

public class CollectionDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Stack<String> carList = new Stack<>();
		carList.add("cartA");
		carList.add("cartB");
		carList.add("cartC");
		carList.add("cartD");
		carList.add("cartE");
		
		System.out.println(carList.get(2));
		carList.remove(2);
		carList.push("cartF");
		for(String car:carList){
			System.out.println(car);
		}
		
		System.out.println("pop:"+carList.pop());
		System.out.println("pop:"+carList.pop());
		
		Vector<String> vector = new Vector<>();
	}

	
	
	
}
