import java.util.HashMap;
import java.util.Scanner;

public class TwoGram {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int max = -1;
		String res = "";
		String s = scn.next();
		for (int i = 0; i < n - 1; i++) {
			char ch1 = s.charAt(i);
			char ch2 = s.charAt(i + 1);
			String ans = "";
			ans += Character.toString(ch1) + Character.toString(ch2);
//			System.out.println(ans);
			if (map.containsKey(ans)) {
				int ov = map.get(ans);
				int nv = ov + 1;
				if (nv >= max) {
					max = nv;
					res = ans;
				}
				map.put(ans, nv);
			} else {
				if (1 > max) {
					max = 1;
					res = ans;
				}
				map.put(ans, 1);
			}
		}
		System.out.println(res);
		scn.close();
	}

}
