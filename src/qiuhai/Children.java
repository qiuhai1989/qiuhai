package qiuhai;

public class Children extends Father{

	static{
		System.out.println("Children静态代码块");
	}
	
	{
		System.out.println("Children代码块");
	}
	
	public Children() {
//		super();
		// TODO Auto-generated constructor stub
		System.out.println("Children构造方法");
	}

	
	
}
