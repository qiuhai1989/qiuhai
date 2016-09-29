package corejava;

public class SortDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ary = new int[]{3,5,2,1,4};
		
//		selectSort(ary);
		
//		bubbleSort(ary);
		
		insertSort(ary);
		
		printAry(ary);
		
	}
	
		
	/**选择排序：每次与第一个元素比较，如果这个元素小于第一个元素，则交换这个连个元素的位置
	 * 
	 * @param srcArray
	 * @return
	 */
	private static void selectSort(int[] srcArray){
		
		for(int i=0;i<srcArray.length-1;i++){
			for(int j=i+1;j<srcArray.length;j++){
				if(srcArray[i]>srcArray[j]){
					int temp = srcArray[i];
					srcArray[i] = srcArray[j];
					srcArray[j] = temp;
				}
			}
		}
	}
	/**
	 * 冒泡排序：比较相邻的元素，小的放前面
	 * @param ary
	 */
	@SuppressWarnings("unused")
	private static void bubbleSort(int[] ary){
		
		for(int i=0;i<ary.length-1;i++){
			for(int j=0;j<ary.length-i-1;j++){
				if(ary[j]>ary[j+1]){
				int temp = ary[j];
				ary[j] = ary[j+1];
				ary[j+1] = temp;
				}
			}
		}
	}
	
	/**
	 * 插入排序:将数组分为两部分，将后部分第一个逐一与前部分比较，在合理位置插入
	 * @param ary
	 */
	private static void insertSort(int [] ary){
		int i,j,t;
		for(i=1;i<ary.length;i++){
			t = ary[i];
			System.out.print("i="+i);
			for(j=i-1;j>=0;j--){
				if(t<ary[j]){
					ary[j+1] = ary[j];
				}else {
					break;
				}
			}
			System.out.println(",j+1="+(j+1)+",ary[j+1]="+ary[j+1]);
			ary[j+1] = t;
			System.out.println("--------------");
		}
	}
	

	private static void printAry(int[] ary){
		for(int n:ary){
			System.out.print(n+",");
		}
	}

}
