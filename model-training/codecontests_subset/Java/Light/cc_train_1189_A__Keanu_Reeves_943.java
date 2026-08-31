import java.util.*;
public class Codeforces{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		s.nextLine();
		String str=s.nextLine();
		Codeforces.fun(str);
	}
	static void  fun(String str){
		if(!goodString(str))
		{
			System.out.println("2");
			System.out.print(str.substring(0,1));
			System.out.print(" ");
			System.out.print(str.substring(1,str.length()));
		}else{
			System.out.println("1");
			System.out.print(str);
		}

	}
	public static boolean goodString(String str)
	{
		int zero=0;
		int one=0;
		for(int i=0;i<str.length();i++)
		{
			if(str.charAt(i)=='0')
			{
				zero++;
			}
			else if(str.charAt(i)=='1'){
					one++;
			}
		}
		if(zero!=one)
		{
			return true;
		}
		else{
			return false;
		}
	}
}