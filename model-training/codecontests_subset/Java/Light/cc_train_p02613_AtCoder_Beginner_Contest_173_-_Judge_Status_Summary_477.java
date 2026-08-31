import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
	  Scanner s=new Scanner(System.in);
	  int n=s.nextInt();
	  int ac=0;
	  int wa=0;
	  int tle=0;
	  int re=0;
	  for(int i=0;i<n;i++)
	  {
	    String k=s.next();
	    if(k.equals("AC"))
	     ac++;
	    else if(k.equals("WA"))
		wa++;
	    else if(k.equals("TLE"))
		tle++;
	    else
		re++;
	  }
	  
		System.out.println("AC x "+ac);
		System.out.println("WA x "+wa);
		System.out.println("TLE x "+tle);
		System.out.println("RE x "+re);
	  
	
	}
}