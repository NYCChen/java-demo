package nyc.test;

public class From16ToInt
{
	public static void main(String[] args) 
	{
		String str = "af";
		int len = str.length();
		int sum = 0;
		From16ToInt f16 = new From16ToInt();
		for (int i = 0; i<len; i++)
		{
			//sum = sum<<4;
			//sum = sum<<4 + f16.CharToInt(str.charAt(i));
			sum = (sum<<4) + f16.CharToInt(str.charAt(i));
			System.out.println(sum);
		}
		System.out.println(sum);
		System.out.println("==================");
		System.out.println("��λ��������ȼ�û�� + - ��");
		int i = 1, j = 1;
		i = (i<<2) +10;
		j = j<<2 +10;
		System.out.println(i);
		System.out.println(j);
	}

	public int CharToInt(char ch){
		

		System.out.println(super.getClass().getName());
		if(ch>='0' && ch <= '9')
		{
			return ch-'0';
		}
		else if (ch >= 'a' && ch <= 'f')
		{
			return ch-'a'+10;
		}
		else return ch-'A'+10;
	}
}
