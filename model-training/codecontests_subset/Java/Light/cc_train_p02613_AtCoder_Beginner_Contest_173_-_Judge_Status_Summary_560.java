import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int countAC = 0;
		int countWA = 0;
		int countTLE = 0;
		int countRE = 0;
		while(n-->=0) {
			String curr = sc.nextLine();
			if(curr.equals("AC")) countAC++;
			if(curr.equals("WA")) countWA++;
			if(curr.equals("TLE")) countTLE++;
			if(curr.equals("RE")) countRE++;

		}
		System.out.println("AC x "+ countAC);
		System.out.println("WA x "+ countWA);
		System.out.println("TLE x "+ countTLE);
		System.out.println("RE x "+ countRE);

	}

}
