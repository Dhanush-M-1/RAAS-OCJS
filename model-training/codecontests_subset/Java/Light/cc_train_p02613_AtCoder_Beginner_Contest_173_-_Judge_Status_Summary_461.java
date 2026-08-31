import java.util.Scanner;



public class Main {
 
	public static void main(String[] args) {
 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;
		
		for(int i = 0; i < n; i++) {
			String judge = sc.next();
			if(judge.equals("AC")) {
				ac++;
			}else if(judge.equals("WA")) {
				wa++;
			}else if(judge.equals("TLE")) {
				tle++;
			}else if(judge.equals("RE")) {
				re++;
			}
		}

		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
		sc.close();
	}
 
}