import java.util.*;
import java.io.*;

public class compete {
	
    public static void main(String args[] ) throws Exception {
        Scanner hb=new Scanner(System.in);
        String a=hb.next();
        String b=hb.next();
        int n=hb.nextInt();
		System.out.println(a+" "+b);
		for(int i=0;i<n;i++)
		{
			String x=hb.next();
			String y=hb.next();
			//System.out.println(x.equals(a));
			//System.out.println(x.equals(b));
			if(x.equals(a))
			{
				a=y;
				System.out.println(a+" "+b);
			}
				
			else if(x.equals(b))
			{
				b=y;
				System.out.println(a+" "+b);
			}
				
			
			
		}
    }
}
