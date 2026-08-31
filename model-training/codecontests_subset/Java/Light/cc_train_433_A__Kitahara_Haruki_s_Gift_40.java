import java.util.*;
public class Kithahara 
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int w[]=new int[n];int sum=0,a=0,b=0,half;
		for(int i=0;i<n;i++)
		{
			w[i]=sc.nextInt();
			sum=sum+w[i];
			if(w[i]==100) a++;
			else b++;
		}
		if(sum%200!=0)
			System.out.println("NO");
		else 
		{
			half=sum/2;
			boolean flag=false;
			for(int i=0;i<=b;i++)
				if(200*i<=half && half-200*i<=a*100)
					flag=true;
			if(flag==true)
				System.out.print("YES");
			else
				System.out.println("NO");
		}			
	}
}
