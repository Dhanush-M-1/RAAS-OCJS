import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ac, wa, tle, re;
		ac = 0;
		wa = 0;
		tle = 0;
		re = 0;
		for(int i=0;i<N;++i){
			String S = sc.next();
			if (S.equals("AC")) ac++;
			if (S.equals("WA")) wa++;
			if (S.equals("TLE")) tle++;
			if (S.equals("RE")) re++;
		}
		sc.close();
		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
	}
}
