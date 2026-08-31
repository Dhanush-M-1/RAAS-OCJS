import java.util.*;
public class coin
{
	public static void main(String[]st)
	{
		Scanner scan=new Scanner(System.in);
		int i,n,a=0;
		String na;
		n=scan.nextInt();
		na=scan.next();
		if(n<11)
			System.out.println("0");
		else
		{
			for(i=0;i<na.length();i++)
			{
				if(na.charAt(i)=='8')
				{
					a++;
				}
				
			}
			if((n/11)>=a)
				System.out.println(""+a);
			else
				System.out.println(""+(n/11));

		}
	}
}