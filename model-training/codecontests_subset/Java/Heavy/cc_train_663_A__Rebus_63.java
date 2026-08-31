import java.util.*;
public class ProB {
	static int len,n,a,b,c,p;
	static String ss;
	static char[] s;
	static int[] aa=new int[105];
	static int[] bb=new int[105];

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		ss=in.nextLine();
		s=ss.toCharArray();
		len=ss.length();
		a=p=1;
		for(int i=0;i<len;i++)
		{
			if(s[i]=='=')
			{
				n=Integer.parseInt(ss.substring(i+2,len));
				break;
			}
			else if(s[i]=='?')
			{
				aa[++c]=1;
				bb[c]=p;
			}
			else if(s[i]=='+') { a++;p=1;}
			else if(s[i]=='-') { b++;p=0;}
		}
		if(a>n*(b+1)||a*n<n+b)
			System.out.println("Impossible");
		else
		{
			System.out.println("Possible");
			if(a>n+b) p=a-n-b;
			else p=n+b-a;
			for(int i=1;i<=c;i++)
			{
				if((a>n+b&&bb[i]==0)||(a<n+b&&bb[i]==1))
				{
					while(p>0&&aa[i]<n)
					{
						p--;aa[i]++;
					}
				}
			}
			c=0;
			for(int i=0;i<len;i++)
			{
				if(s[i]=='?') System.out.print(aa[++c]);
				else System.out.print(s[i]);
			}
		}
	}
}
