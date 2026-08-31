
import java.util.*;

public class Main {

	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int tle=0,ac=0,wa=0,re=0;
		for(int i=0;i<t;i++)
		{
			String ar=sc.next();
			
			if(ar.equals("TLE")) tle++;
			else if(ar.equals("WA")) wa++;
			else if(ar.equals("RE")) re++;
			else if(ar.equals("AC")) ac++;
			
			
			
		}
		System.out.println("AC x "+ac);
		System.out.println("WA x "+wa);
		System.out.println("TLE x "+tle);
		System.out.println("RE x "+re);
	}

}
