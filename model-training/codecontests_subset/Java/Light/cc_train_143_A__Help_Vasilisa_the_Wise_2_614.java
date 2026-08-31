import java.util.*;
public class Main
{
	public static void main(String[] args)
	{
	   Scanner sc=new Scanner(System.in);
	    int a[]=new int[7];
	    for(int i=1;i<7;i++)
	    a[i]=sc.nextInt();
	    int a1=(a[1]-a[4]+a[5])/2;
	    int b=a[1]-a1;
	    int c=a[3]-a1;
	    int d=a[5]-a1;
	    if((b+c)!=a[6] || (c+d)!=a[2] || (b+d)!=a[4] || a1==b || a1==c || a1==d || b==c || b==d || c==d || a1<1 || a1>9  ||
	       b<1 || b>9 || c<1 || c>9 || d<1 || d>9)
	    {
	        System.out.println("-1");
	        return;
	    }
	    System.out.println(a1+" "+b);
	    System.out.println(c+" "+d);
	}
}
