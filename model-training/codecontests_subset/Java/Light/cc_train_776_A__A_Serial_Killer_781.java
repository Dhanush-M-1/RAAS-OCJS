import java.util.Scanner;
public class Main
{
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		String s1=in.next();
		String s2=in.next();
		int n=in.nextInt();
		String S[]=new String[n+1];
		S[0]=s1+" "+s2;
		for(int i=1;i<=n;i++)
		{
			String s3=in.next();
			String s4=in.next();
			if(s3.equals(s1))
				s1=s4;
			if(s3.equals(s2))
				s2=s4;
			S[i]=s1+" "+s2;
		}
		for(int i=0;i<=n;i++)
			System.out.println(S[i]);
	}
}
 	 	       		      		 					