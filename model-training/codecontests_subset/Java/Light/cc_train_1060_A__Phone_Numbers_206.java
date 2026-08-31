import java.util.*;
public class codefore{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String s=sc.next();
		int a=0,b,c;
		for(int i=0;i<n;i++)
		{
			if(s.charAt(i)=='8')
				a++;
		}
		b=n/11;
		if(a<b)
			System.out.println(a);
		else
			System.out.println(b);
	}
}
			