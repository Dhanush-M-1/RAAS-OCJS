import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt();
		int account=0;
		int tlecount=0;
		int wacount=0;int recount=0;
		while(n-->0) {
			String s=scan.next();
			if(s.equals("AC"))account++;
			else if(s.equals("WA"))wacount++;
			else if(s.equals("TLE"))tlecount++;
			else if(s.equals("RE"))recount++;
		}
		System.out.println("AC x "+account);
		System.out.println("WA x "+wacount);
		System.out.println("TLE x "+tlecount);
		System.out.println("RE x "+recount);
	}

}