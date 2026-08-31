import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		String n[] = new String[N];
		int AC = 0;
		int WA = 0;
		int TLE = 0;
		int RE = 0;
		
		for(int i=0; i<N; i++) {
			n[i] = scan.next();
			if(n[i].equals("AC")) {
				AC++;
			}else if(n[i].equals("WA")){
				WA++;
			}else if(n[i].equals("TLE")){
				TLE++;
			}else if(n[i].equals("RE")){
				RE++;
			}
		}
		System.out.println("AC x "+AC);
		System.out.println("WA x "+WA);
		System.out.println("TLE x "+TLE);
		System.out.println("RE x "+RE);
	}
}