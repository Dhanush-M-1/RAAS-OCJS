
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ac = 0;
		int wa = 0;
		int tle = 0;
		int re = 0;
		for(int i = 0 ; i < N ; ++i){
			String s = sc.next();
			switch (s) {
			case "AC":
				++ac;
				break;
			case "WA":
				++wa;
				break;
			case "TLE":
				++tle;
				break;
			case "RE":
				++re;
				break;
			default:
				break;
			}
		}
		System.out.printf("AC x %d\n" , ac);
		System.out.printf("WA x %d\n" , wa);
		System.out.printf("TLE x %d\n" , tle);
		System.out.printf("RE x %d\n" , re);
	}
}
