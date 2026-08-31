import java.util.Scanner;

public class st {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	int o=0,c=0,h=0;
	for(int i=0;i<s.length();i++)
	{
		if(s.charAt(i)=='(')
		{
			o++;
		}
		else if(s.charAt(i)==')')
		{
			c++;
		}
		else
		{
			h++;
		}
		
		
	}
	if(o-c>=h)
	{int d=0,l=0,e=0,f=0;
		while(true)
		{
			if(s.charAt(d)=='#')
			{
				l++;
				if(l==h)
					break;
			}
		d++;	
		}
		int ds,m=0,n=0;
		for(ds=0;ds<d;ds++)
		{
			if(s.charAt(ds)=='(')
				m++;
			else
				n++;
			if(n>m)
				break;
		}
		
		int r;
		for( r=d+1;r<s.length();r++)
		{
			if(s.charAt(r)==')')
			{
				e++;
				
			}
			if(s.charAt(r)=='(')
			{	
			if(e>f)
				break;
		f++;
			}
				
		}
		if(r==s.length()  && e>=f && ds==d)
		{
		for(int j=0;j<h-1;j++)
		{
			System.out.println("1");
		}
		System.out.println((o-c)-h+1);
	}
		else
			System.out.println("-1");	
	}
	else
	{
		System.out.println("-1");
	}
	
	
	
	
	
	
		
	}
}