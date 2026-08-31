import java.util.*;
public class Minimuminteegr {

	private static Scanner s;

	public static void main(String[] args)
	{
		s = new Scanner(System.in);
		int q=s.nextInt();
		s.nextLine();
		for(int k1=0;k1<q;k1++)
		{
			String[] lrd=s.nextLine().split(" ");
			long l=Long.parseLong(lrd[0]);
			long r=Long.parseLong(lrd[1]);
			long d=Long.parseLong(lrd[2]);
			if(d<l)
				System.out.println(d);
			else
			{
			//	int a=0;
				r++;
//				while(a!=1)
//				{
//					if(r%d==0)
//					{
//						System.out.println(r);
//						a=1;
//						break;
//					}
//					else
//						r++;
//				}	
				System.out.println(r%d==0?r:((r/d)+1)*d);
			}
		}
		
	}
}