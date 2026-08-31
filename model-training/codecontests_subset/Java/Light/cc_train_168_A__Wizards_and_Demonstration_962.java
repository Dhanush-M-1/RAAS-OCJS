import java.util.*;
public class Tester
{
	public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		
		int n=s.nextInt();
		int x=s.nextInt();
		int y=s.nextInt();
		
		double req1=(double)(y*n)/100;
		double req2=Math.ceil(req1);
		//System.out.println(req1+" "+req2);
		
		if(x>=req1)
			System.out.println("0");
		else
			System.out.println((int)req2-x);
	}
}
