package qiuhai;

public class C extends B implements A{
	
	public void pX(){
		System.out.println(super.x);
		System.out.println(A.x);
	}

}
