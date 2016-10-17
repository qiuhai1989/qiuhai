package corejava;

import java.util.ArrayList;
import java.util.List;


public class MathDemo {

	public static void main(String[] args) {
		printData();
	}
	
	public static void printData(){
		List<Integer> oddList = new ArrayList<>();
		List<Integer> evenList = new ArrayList<>();
		for(int i=1;i<=100;i++){
			if(i%3==0&&i%2==0){
				evenList.add(new Integer(i));
			}else if(i%3==0&&i%2==1){
				oddList.add(new Integer(i));
			}
		}
		
		int oddSum = 0;
		int evenSum = 0;
		System.out.print("符合奇数有：");
		for(Integer n1:oddList){
			System.out.print(n1+",");
			oddSum += n1;
		}
		System.out.println();
		System.out.println("奇数综合为："+oddSum);
		System.out.print("符合偶数有：");
		for(Integer n2:evenList){
			System.out.print(n2+",");
			evenSum += n2;
		}
		System.out.println();
		System.out.println("偶数综合为："+evenSum);
	}
	
}
