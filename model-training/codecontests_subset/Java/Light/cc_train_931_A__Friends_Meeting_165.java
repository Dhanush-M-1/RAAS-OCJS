import java.util.*;
import java.lang.*;
public class Main {
	
	public static void main(String [] args)
	{
		Scanner s = new Scanner(System.in);
			int a = s.nextInt();
			int b = s.nextInt();
			int dif = b-a;
			int s1=0,s2=0;
			
			if((b-a)<0)
			dif = dif*-1;
			if(dif==1)
			{
				System.out.println("1");
			}
			else
			{
			if(dif%2!=0)
			{
				
				dif = dif/2;
				s1 = (dif*(dif+1))/2;
				s2 = ((dif+1)*(dif+2))/2;
			}
			else
			{
				dif = dif/2;
				s1 = (dif*(dif+1))/2;
				s2 = (dif*(dif+1))/2;
			}
			
			System.out.println(s1+s2);
		 }
			
	}

}

