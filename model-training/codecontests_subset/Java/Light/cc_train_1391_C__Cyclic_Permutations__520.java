import java.util.*;
public class C45
{
	static int MAX=1000000007;
	public static void main(String[] args)
	{
	  Scanner s=new Scanner(System.in);
	  int n=s.nextInt();
	  long k=1;
	  long m=1;
	   for(int i=n;i>0;i--)
	   {
		k=k*i%MAX;
	   }
	  for(int i=0;i<n-1;i++)
	  {	   
		m=m*2%MAX;
	  }
	  System.out.println((k-m+MAX)%MAX);
	}
	
}
