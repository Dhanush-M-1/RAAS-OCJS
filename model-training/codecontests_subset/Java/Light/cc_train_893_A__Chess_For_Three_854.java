import java.util.*;
public class Main {

	public static void main(String[] args)
	{
	Scanner in=new Scanner(System.in);
	int n=in.nextInt();
	int a[]=new int[n];
	int b[]=new int[2];
	b[0]=1;
	b[1]=2;
	for(int i =0;i<n;++i)
	{
	a[i]=in.nextInt();
	}
	int c[]=new int [n];
	for(int i=0;i<n;i++)
	{
		if(b[0]==a[i]&&b[1]!=a[i])
		{
			c[i]=b[0];
			b[1]=find(b);
		}
		if(b[0]!=a[i]&&b[1]==a[i])
		{
			c[i]=b[1];
			b[0]=find(b);
		}
//		if(b[0]!=a[i]&&b[1]!=a[i])
//		{
//			System.out.println("NO");
//		}
	}
	
	int count=0;
	for(int i=0;i<n;i++)
	{
		if(c[i]==a[i])
			count++;
		
	}
	if(count==n)
		System.out.println("YES");
	else
		System.out.println("NO");
	}
	
	public  static int find(int arr[])
	{
		int num=0;
		for(int i=0;i<3;i++)
		{
			if(arr[0]!=(i+1)&&arr[1]!=(i+1))
				{num= i+1;
			break;}
		}
		return num;
	
		
	}

}
	     			  	    				 				   	