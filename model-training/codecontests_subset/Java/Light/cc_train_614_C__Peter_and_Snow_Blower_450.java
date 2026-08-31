import java.text.*;
import java.util.*;
public class ProC {
	static int n;
	static long xx,yy,a,b,x,y,p,q;
	static double min,max,c,eps=0.0000000001;
	static double work(long a,long b,long c,long d)
	{
		double x,y;
		if(a==c) { x=a;y=yy;}
		else if(b==d) { x=xx;y=b;}
		else
		{
			double k1=((double)a-c)/(d-b);
			double t1=(double)yy-k1*xx;
			double k2=((double)b-d)/(a-c);
			double t2=(double)b-k2*a;
			x=(t1-t2)/(k2-k1);
			y=k1*x+t1;
		}
		if((x-a)*(x-c)+(y-b)*(y-d)>eps) return -1.0;
		return (double)(x-xx)*(x-xx)+(y-yy)*(y-yy);
	}

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		DecimalFormat ff=new DecimalFormat("0.000000000000000000");
		n=in.nextInt();
		xx=in.nextInt();yy=in.nextInt();
		min=10000000000000l;max=0;
		for(int i=0;i<n;i++)
		{
			x=in.nextInt();y=in.nextInt();
			c=(x-xx)*(x-xx)+(y-yy)*(y-yy);
			min=Math.min(min,c);
			max=Math.max(max,c);
			if(i>0)
			{
				c=work(a,b,x,y);
				if(c>=eps) min=Math.min(min,c);
			}
			else { p=x;q=y;}
			a=x;b=y;
		}
		c=work(a,b,p,q);
		if(c>=eps) min=Math.min(min,c);
		System.out.println(ff.format(Math.PI*(max-min)));
	}
}
