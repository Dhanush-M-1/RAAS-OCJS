import java.util.*;
public final class Candle
{
	public static void main(String arg[])
	{
	Scanner br=new Scanner(System.in);
	int n=br.nextInt();
	int d=br.nextInt();
	int c=0,l=0;
	c=c+n;
	while(n>0 && l<d)
	{
		l=l+n-((n/d)*d);
		n=n/d+l/d;
		
		c=c+n;
		l=l-(l/d)*d;
	}
	System.out.println(c);
	}
}