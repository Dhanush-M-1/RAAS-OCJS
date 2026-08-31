import java.util.Scanner;

public class Helpful_maths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str = new String();
		String res = "";
		int one=0,two=0,three=0;
		str = input.nextLine();
		
		int len = str.length();
		
		for(int i=0;i<len;i=i+2)
		{
			if(str.charAt(i)=='1')
				one++;
			else if(str.charAt(i)=='2')
				two++;
			else
				three++;
		}
		
		for (int i=0;i<len;i=i+2)
		{
			if(one!=0)
			{
				res = res + '1' + '+';
				one--;
			}
			else if(two!=0)
			{
				res = res + '2' + '+';
				two--;
			}
			else
			{
				res = res + '3' + '+';
				three--;
			}

		}
		System.out.println(res.substring(0, len));
	}

}
