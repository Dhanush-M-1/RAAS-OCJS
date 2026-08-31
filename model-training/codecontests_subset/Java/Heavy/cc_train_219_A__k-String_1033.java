import java.util.Scanner;
import java.util.TreeMap;

public class C_219A {
	public static void main(String[] args) {
		TreeMap<String, Integer> mp = new TreeMap<String, Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		for (int i = 0; i < s.length(); i++) {
			if (mp.containsKey(s.substring(i,i+1))) {
				mp.put(s.substring(i,i+1), mp.get(s.substring(i,i+1))+1);
			}else{
				mp.put(s.substring(i,i+1), 1);
			}
		}
		int a;
		String ss="";
		for (int j = 1; j <= n; j++) {
			for (String i : mp.keySet()) {
				a = mp.get(i);
				if (a % n !=0) {
					System.out.println(-1); return;
				}else{
					for (int k = 1; k <= a/n; k++) {
						ss+=i;
					}
				}
			}
		}
		System.out.println(ss);
	}
}