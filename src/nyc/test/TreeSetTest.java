package nyc.test;

import java.util.TreeSet;

class Parent implements Comparable {
	private int age = 0;
	public Parent(int age){
		this.age = age;
	}
	public int compareTo(Object o) {
		System.out.println("method of parent");
		Parent o1 = (Parent)o;
		
		System.out.println(age>o1.age?1:age<o1.age?-1:0);
		return age>o1.age?1:age<o1.age?-1:0;
	}
	protected void testPublic(){

	}
}

class Child extends Parent {
	public Child(){
		super(3);
	}
	public int compareTo(Object o) {
		System.out.println("method of child");
		Child o1 = (Child)o;
		return 1;
	}

	public void testPublic() {
	}
}
public class TreeSetTest {
	public static void main(String[] args) {
		TreeSet set = new TreeSet();
		set.add(new Parent(3));
		set.add(new Child());
		set.add(new Parent(4));
		System.out.println(set.size());
	}
}
