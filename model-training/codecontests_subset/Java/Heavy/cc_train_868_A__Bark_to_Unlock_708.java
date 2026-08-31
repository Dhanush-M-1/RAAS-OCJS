import java.util.*;

public class Main {
	public static void main(String[] args) {
		String[] a = new String[100];
		Scanner in = new Scanner(System.in);
		String key = in.next();
		int n = in.nextInt();
		for(int i = 0;i < n; ++i) a[i] = in.next();
		for(int i = 0;i < n; ++i) {
			if(key.equals(a[i])) {
				System.out.println("YES");
				return;
			}
		}
		for(int i = 0;i < n; ++i) {
			for(int j = i;j < n; ++j) {
				if(jud(a[i],a[j],key)) {
					System.out.println("YES");
					return;
				}
			}
		}
		System.out.println("NO");
	}
	public static boolean jud(String x,String y,String z) {
		return x.charAt(1) == z.charAt(0) && y.charAt(0) == z.charAt(1) || 
				y.charAt(1) == z.charAt(0) && x.charAt(0) == z.charAt(1);
	}
}
