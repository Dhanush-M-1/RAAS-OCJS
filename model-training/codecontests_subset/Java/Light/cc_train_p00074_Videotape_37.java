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
			System.out.printf("%02d:%02d:%02d",a[0],a[1],a[2]);
			System.out.println();
			re*=3;
			a[0]=re/3600;
			a[1]=(re%3600)/60;
			a[2]=(re%3600)%60;
			System.out.printf("%02d:%02d:%02d",a[0],a[1],a[2]);
			System.out.println();
		}
	}
}