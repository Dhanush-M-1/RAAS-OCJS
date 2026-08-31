import java.util.*;
public class Main
{
	public static void main(String args[])
	{
		Scanner scan = new Scanner(System.in);
		int a,b,c,d,e,f,x1,x2,y1,y2,ans=0;
		a = scan.nextInt();
		b = scan.nextInt();
		c = scan.nextInt();
		d = scan.nextInt();
		e = scan.nextInt();
		f = scan.nextInt();
		for(x1=1;x1<10 && ans==0;x1++)
		{
			for(x2=1;x2<10 && ans==0;x2++)
			{
				if(x2==x1) continue;
				for(y1=1;y1<10 && ans==0;y1++)
				{
					if(y1==x2 || y1==x1) continue;
					for(y2=1;y2<10 && ans==0;y2++)
					{
						if(y2==y1 || y2==x2 || y2==x1) continue;
						if(x1+x2==a && y1+y2==b && x1+y1==c && x2+y2==d && x1+y2==e && x2+y1==f)
						{
							ans = 1;
							System.out.println(x1+" "+x2);
							System.out.println(y1+" "+y2);
						}
					}
				}
			}
		}
		if(ans==0) System.out.println("-1");
		
	}
}