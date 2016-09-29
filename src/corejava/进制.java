package corejava;

public class 进制 {

	
	public static void main(String[] args) {
		
		int n1 = 0123;
		System.out.println(n1);
		int n2 = 0b10;
		System.out.println(n2);
		int n3 = 0x10;
		System.out.println(n3);
		
		int n4 = 102;
		
		System.out.println("二进制表示："+Integer.toBinaryString(n4));
		
		System.out.println("八进制表示："+Integer.toOctalString(n4));
		
		System.out.println("十六进制表示："+Integer.toHexString(n4));
		
	}
	
}
