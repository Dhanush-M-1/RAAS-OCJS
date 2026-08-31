import java.util.*;

public class cf20b {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		if(a==0 && b==0) {
			System.out.println(c==0?-1:0);
			return;
		}
		if(a==0) {
			System.out.println(1);
			System.out.printf("%.10f%n", -c/(1.*b));
			return;
		}
		ArrayList<Double> ans = solve(a,b,c);
		System.out.println(ans.size());
		for(double x : ans)
			System.out.printf("%.10f%n", x);
	}
	static ArrayList<Double> solve(long a, long b, long c) {
		ArrayList<Double> ret = new ArrayList<Double>();
		long disc = b*b-4*a*c;
		if(disc < 0) return ret;
		if(disc ==0) {
			ret.add(-b/(2.*a));
			return ret;
		}
		ret.add((-b-Math.sqrt(disc))/(2.*a));
		ret.add((-b+Math.sqrt(disc))/(2.*a));
		Collections.sort(ret);
		return ret;
	}
}
