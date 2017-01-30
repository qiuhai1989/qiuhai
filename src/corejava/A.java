package corejava;

import java.util.HashSet;
import java.util.Set;

public class A {

	private String name;
	
	private Integer age;

	
	
	public A() {
		super();
	}

	public A(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		System.out.println("调用了hashCode");
		final int prime = 31;
		int result = 1;
		result = prime * result + ((age == null) ? 0 : age.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("调用了equals");
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public static void main(String[] args) {
		/**
		 * Set 存储根据对象hashcode方法判断是否重复
		 */
		Set<A> set = new HashSet<>();
		set.add(new A("test1",10));
		set.add(new A("test2",10));
		set.add(new A("test3",10));
		set.add(new A("test4",10));
		set.add(new A("test1",20));
		for(A a:set){
			System.out.println(a.getName());
		}
			
	}
	
	
}
