import java.util.*;
import java.io.*;

public class codeforcesc {

	static void methods() {
		Integer arr[] = { 1, 1, 1, 1, 1, 1 };
		Integer arr2[] = { 1, 1, 1, 1, 1, 1 };
		List<Integer> l1 = new ArrayList<>();
		l1 = Arrays.asList(arr);
		ArrayList<Integer> ll = new ArrayList<>(l1);
		boolean bb = Arrays.equals(arr, arr2);
	}

	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			int c=sc.nextInt();
			int ans=0;
			ans=Math.min(b, c/2);
			b=b-ans;
			ans=3*ans;
			int a2=Math.min(a, b/2);
			a2=3*a2;
			ans+=a2;
			System.out.println(ans);
			
			
			
			
	}

	}

}