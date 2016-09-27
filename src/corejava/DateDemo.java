package corejava;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 HH:mm:ss");
		System.out.println(sdf.format(new Date()));
		System.out.println(new Date(System.currentTimeMillis()+1000*60*60));
		
		Date date = new Date();
		 sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		String str = sdf.format(date);
		System.out.println(str);
	}

}
