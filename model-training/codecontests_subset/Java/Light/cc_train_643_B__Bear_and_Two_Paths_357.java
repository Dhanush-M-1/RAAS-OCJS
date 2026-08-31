import java.util.*;
public class ProD {
	static int n,k,a,b,c,d;

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		n=in.nextInt();k=in.nextInt();
		a=in.nextInt();b=in.nextInt();
		c=in.nextInt();d=in.nextInt();
		if(n==4||k<n+1) System.out.println(-1);
		else
		{
			System.out.print(a+" "+d+" ");
			for(int i=1;i<=n;i++)
				if(i!=a&&i!=b&&i!=c&&i!=d) System.out.print(i+" ");
			System.out.println(c+" "+b);
			System.out.print(c+" "+b+" ");
			for(int i=1;i<=n;i++)
				if(i!=a&&i!=b&&i!=c&&i!=d) System.out.print(i+" ");
			System.out.println(a+" "+d);	
		}
	}
}
