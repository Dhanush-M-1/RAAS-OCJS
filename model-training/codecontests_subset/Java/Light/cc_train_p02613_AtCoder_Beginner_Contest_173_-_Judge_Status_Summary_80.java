import java.util.Scanner;

public class Main {
		static String s1="AC";
		static String s2="WA";
		static String s3="TLE";
		static String s4="RE";
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n=scan.nextInt();
		int c1=0,c2=0,c3=0,c4=0;
		for	(int i=0;i<n;i++)
		{
			
			String s=scan.next();
			if(s.contains(s1)) c1++;
			else if(s.contains(s2)) c2++;
			else if (s.contains(s3)) c3++;
			else if(s.contains(s4)) c4++;
		}
		System.out.println(s1+" "+"x"+" "+c1);
		System.out.println(s2+" "+"x"+" "+c2);
		System.out.println(s3+" "+"x"+" "+c3);
		System.out.println(s4+" "+"x"+" "+c4);
		

	}

}
