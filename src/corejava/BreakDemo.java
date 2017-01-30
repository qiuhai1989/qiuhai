package corejava;

public class BreakDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<5;i++){
			System.out.print("i="+i);
			for(int j=0;j<10;j++){
				System.out.println("j="+j);
				if(j==5){
					break;
				}
			}
		}
		
	}

}
