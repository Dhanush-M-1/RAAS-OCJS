import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int ac = 0, wa = 0, t = 0, re = 0;
		
		for(int i = 0; i < a; i++) {
			String asd = scan.next();
			if(asd.equals("AC")) {
				ac++;
			}else if(asd.equals("WA")) {
				wa++;
				
			}else if(asd.equals("TLE")) {
				t++;
			}else {
				re++;
			}
			
		}
		
		System.out.print("AC x " + ac + "\nWA x " + wa + "\nTLE x " + t + "\nRE x " + re);


	}


}
