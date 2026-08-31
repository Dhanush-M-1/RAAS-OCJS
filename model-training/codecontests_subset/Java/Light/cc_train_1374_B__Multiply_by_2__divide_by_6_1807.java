import java.util.*;
public class mul2div6
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{
			int count=0;
			int flag=0;
			int n=sc.nextInt();
			while(n!=1)
			{
				if(n%6==0)
				{
					n=n/6;
					count++;
					//System.out.println("n: "+n);
				}
				else if(n%6!=0)
				{
					n=n*2;
					//System.out.println("n: "+n);
					count++;
					if(n%6!=0)
					{
						flag=1;
						break;
					}
					else if(n%6==0)
					{
						n=n/6;
						//System.out.println("n:" +n);
						count++;
					}
				}
			}
			if(flag==0)
			{
			System.out.println(count);
			}
			else
			{
				System.out.println("-1");
			}
			
			//System.out.println("n: "+n);
		}
	}
}
