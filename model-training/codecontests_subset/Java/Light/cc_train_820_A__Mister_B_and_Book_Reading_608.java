import java.util.*;

public class Main
{
	public static int c,v0,v1,a,l,i;
	public static int address;
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		c = in.nextInt();
		v0 = in.nextInt();
		v1 = in.nextInt();
		a = in.nextInt();
		l = in.nextInt();
		address = 0;
		for(i=0 ; address<c ; i++)
			go(i);
		System.out.println(i);
	}
	public static void go(int x)
	{
		int step = v0+x*a;
		step = Math.min(v1, step);
		if(x>0)step -= l;
		address += step;
	}
}