import java.util.*;
public class C21a
{
	
	public static void main(String[] args)
	{
	Scanner s=new Scanner(System.in);
	int t=s.nextInt();
	while(t>0)
	{	
	int n=s.nextInt();
	 double ans=Math.cos(Math.PI/(4*n))/Math.sin(Math.PI/(2*n));
	System.out.println(ans);
	  t--;
	}
	}
}
