package corejava;

import java.util.Comparator;

public class Animal implements Comparable<Animal> {

	public void eat(){
		System.out.println("eat....");
	}
	
	public final void run(){
		System.out.println("run....");
	}

	@Override
	public int compareTo(Animal o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	class ByName implements Comparator<Animal>{

		@Override
		public int compare(Animal o1, Animal o2) {
			// TODO Auto-generated method stub
			return 0;
		}
		
	}
}
