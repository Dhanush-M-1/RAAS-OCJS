import java.io.*;
import java.util.*;
 
public class Main {
		
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		for(int pt=0;pt<tc;pt++) {
			int n = in.nextInt();
			int m = in.nextInt();
			HashSet<Integer> set = new HashSet<Integer>();
			for(int i=0;i<n;i++) {
				int x = in.nextInt();
				set.add(x);
			}
			int ans = -1;
			for(int i=0;i<m;i++) {
				int y = in.nextInt();
				if(set.contains(y)) {
					ans = y;
				}
			}
			if(ans !=-1) {
				System.out.println("YES");
				System.out.println(1+" "+ans);
			}
			else {
				System.out.println("NO");
			}
		}
	}
}