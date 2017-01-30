package qiuhai;

public class Father {

	static{
		System.out.println("father静态代码块");
	}
	
	{
		System.out.println("father代码块");
	}
	
	public Father(){
		System.out.println("father构造方法");
	}
	
}
