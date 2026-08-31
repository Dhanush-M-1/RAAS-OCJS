import java.util.*;
public class Task4 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int k = s.nextInt();
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		int d = s.nextInt();

		if (n == 4 || k < n + 1) {
			System.out.println(-1);
			return;
		}

		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (i != a && i != b && i != c && i != d) {
				res.add(i);
			}
		}

		String res1 = a + " " + c + " ";
		String res2 = c + " " + a + " ";
		for (int elt : res) {
			res1 += elt + " ";
			res2 += elt + " "; 
		}

		res1 += d + " " + b;
		res2 += b + " " + d;

		System.out.println(res1);
		System.out.println(res2);


	}
}
