import java.util.Scanner;
public class P776A
{
	public static void main(String[] args)
	{
	 Scanner scan=new Scanner(System.in);
	 int n,i;
	 String[] s=new String[2002];
	 s[0]=scan.next();
	 s[1]=scan.next();
	 n=scan.nextInt();
	 for(i=2;i<2*n+2;++i)
		s[i]=scan.next();
	 System.out.println(s[0]+" "+s[1]);
	 for(i=2;i<2*n+2;++i)
		{
		 if(s[i].equals(s[i-2])&&!(s[i].equals(s[i-1])))
			s[i]=s[i-1];
		 else
			s[i]=s[i-2];
		 System.out.println(s[i]+" "+s[i+1]);
		 ++i;
		}
	}
}