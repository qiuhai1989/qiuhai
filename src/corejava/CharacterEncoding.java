package corejava;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;

public class CharacterEncoding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		  String en="A";
		  String ch = "人";
		  System.out.println("英文字母："+en);
		  printByteLength(en, "GB2312");
		  printByteLength(en, "GBK");
		  printByteLength(en, "GB18030");
		  printByteLength(en, "ISO-8859-1");
		  printByteLength(en, "UTF-8");
		  printByteLength(en, "UTF-16");
		  printByteLength(en, "UTF-32");
		  System.out.println();
		  System.out.println("中文汉字："+en);
		  printByteLength(ch, "GB2312");
		  printByteLength(ch, "GBK");
		  printByteLength(ch, "GB18030");
		  printByteLength(ch, "ISO-8859-1");
		  printByteLength(ch, "UTF-8");
		  printByteLength(ch, "UTF-16");
		  printByteLength(ch, "UTF-32");
		  
		  System.out.println("-----------------------------------------");
		  currentByteLength(en);
		  currentByteLength(ch);
		
		  
		  printByte(en);
		  printByte(ch);
		  
		  utf8ToGbk("我靠");
		  
		  char c = '中';
		  System.out.println((int)c);
		  
		  
	}
	
	private  static void printByteLength(String s,String encodingName){
		
		System.out.print("字节数:");
		
		try {
			int n = s.getBytes(encodingName).length;
			System.out.print(n);
			System.out.println(";编码:"+encodingName);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private  static void currentByteLength(String s){
		int n = s.getBytes().length;
		System.out.println("当前环境默认字符编码下字节数："+n);
	}
	

	private static void printByte(String s){
		byte[] bytes = s.getBytes();
		for(int i=0;i<bytes.length;i++){
			System.out.println(bytes[i]);
			
		}
		System.out.println(new BigInteger(bytes).toString(2)); ;
		System.out.println("+++++++++++++++++++++++++");
	}
	
	private static void  utf8ToGbk(String s){
		
		try {
			String string = new String(s.getBytes("GBK"), "GBK");
			System.out.println("utf8转GBK："+string);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
