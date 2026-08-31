import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = Integer.parseInt(scanner.next());
		int AC = 0,WA = 0,TLE = 0,RE = 0;
		for(int i=0;i<N;i++) {
			switch(scanner.next()) {
			case "AC":
				AC++;
				break;
			case "WA":
				WA++;
				break;
			case "TLE":
				TLE++;
				break;
			case "RE":
				RE++;
				break;
			}
		}
		System.out.printf("AC x %d\n",AC);
		System.out.printf("WA x %d\n",WA);
		System.out.printf("TLE x %d\n",TLE);
		System.out.printf("RE x %d\n",RE);
		scanner.close();
	}
}