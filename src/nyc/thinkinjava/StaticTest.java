package nyc.thinkinjava;

public class StaticTest
{
	static int x, y;
	static{
		int x = 5;
		System.out.println(x);
	}
	public static void main(String[] args) 
	{
		System.out.println(x+""+y );

		StaticTest st = new StaticTest();
		st.jadd();
	}
	public void jadd(){
		int j = 0,k =0;
		for (int i = 0; i<100;i++ )
		{
			k = j++;
			//j = j++;
		}
		System.out.println("kadd:" + k);
		System.out.println("jadd:" + j);
	}
}
