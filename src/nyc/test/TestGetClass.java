package nyc.test;

import java.util.Date;
public class TestGetClass extends Date{
	public static void main(String[] args) {
		new TestGetClass().test();
		String s = "a" + "b" + "c" + "d";
System.out.println(s == "abcd");
	}
	public void test(){
		
		System.out.println(this.getClass().getName());
		System.out.println(super.getClass().getName());
	}
}