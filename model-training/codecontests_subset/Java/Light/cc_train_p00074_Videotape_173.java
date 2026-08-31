import java.util.Scanner;
public class Main
{
	public static void main(String aeg[])
	{
		Scanner in = new Scanner(System.in);
		int a[]= new int[3];
		while(in.hasNext())
		{
			a[0]=in.nextInt();
			a[1]=in.nextInt();
			a[2]=in.nextInt();
			if((a[0]|a[1]|a[2])==-1)
				return;
			int re=7200-a[0]*3600-a[1]*60-a[2];
			a[0]=re/3600;
			a[1]=(re%3600)/60;
			a[2]=(re%3600)%60;
			String a0 = String.valueOf(a[0]);
			String a1 = String.valueOf(a[1]);
			String a2 = String.valueOf(a[2]);
			if(a0.length()<2)
				a0="0"+a0;
			if(a1.length()<2)
				a1="0"+a1;
			if(a2.length()<2)
				a2="0"+a2;
			System.out.println(a0+":"+a1+":"+a2);
			re*=3;
			a[0]=re/3600;
			a[1]=(re%3600)/60;
			a[2]=(re%3600)%60;
			String b0 = String.valueOf(a[0]);
			String b1 = String.valueOf(a[1]);
			String b2 = String.valueOf(a[2]);
			if(b0.length()<2)
				b0="0"+b0;
			if(b1.length()<2)
				b1="0"+b1;
			if(b2.length()<2)
				b2="0"+b2;
			System.out.println(b0+":"+b1+":"+b2);
		}
	}
}