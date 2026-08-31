import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		//AC, WA, TLE, RE
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;
		String str = sc.nextLine();
		for (int i=0; i<a; i++) {
			str = sc.nextLine();
			if (str.compareTo("AC")== 0) ac++;
			if (str.compareTo("WA")== 0) wa++;
			if (str.compareTo("TLE")== 0) tle++;
			if (str.compareTo("RE")== 0) re++;
		}
		sc.close();
		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);

	}
}
