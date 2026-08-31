import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int AC = 0;
		int WA = 0;
		int TLE = 0;
		int RE = 0;
		for(int i = 0; i < n; i++) {
            String res = sc.next();
			if(res.equals("AC"))
			AC++;
			else if(res.equals("WA"))
			WA++;
			else if(res.equals("TLE"))
			TLE++;
			else if(res.equals("RE"))
			RE++;
		}
		System.out.println("AC x " + AC);
		System.out.println("WA x " + WA);
		System.out.println("TLE x " + TLE);
		System.out.println("RE x " + RE);
	}
}