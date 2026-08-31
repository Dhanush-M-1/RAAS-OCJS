public class Main {
	public static void main(String[] args) {
		var sc = new java.util.Scanner(System.in);

		var ac = 0;
		var wa = 0;
		var tle = 0;
		var re = 0;
		var n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			var s = sc.next().charAt(0);
			switch (s) {
			case 'A':
				ac++;
				break;
			case 'W':
				wa++;
				break;
			case 'T':
				tle++;
				break;
			case 'R':
				re++;
				break;
			}
		}
		System.out.println("AC x " + ac);
		System.out.println("WA x " + wa);
		System.out.println("TLE x " + tle);
		System.out.println("RE x " + re);
	}
}