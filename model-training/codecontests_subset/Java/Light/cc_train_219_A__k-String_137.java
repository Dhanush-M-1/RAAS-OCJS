import java.util.Scanner;

public class Main
{
	static Scanner scan=new Scanner(System.in);
	public static void main(String[] args)
	{
		int n=scan.nextInt();
		char c[]=scan.next().toCharArray();
		int len=c.length;
		if(len%n!=0) System.out.println(-1);
		else
		{
			char a[]=new char[26];
			for(int i=0;i<len;i++) a[c[i]-97]++;
			String s="";boolean b=true;
			for(int i=0;i<26;i++)
				if(a[i]%n==0)
					for(int j=0;j<a[i]/n;j++) s+=(char)(i+97);
				else if(a[i]%n!=0)
				{
					System.out.println(-1);
					b=false;
					break;
				}
			if(b)
				for(int i=0;i<n;i++)
					System.out.print(s);
		}
	}
}
	  						 	 	   		 	 				