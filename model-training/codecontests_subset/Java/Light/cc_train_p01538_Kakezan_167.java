
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer> box;
	
	static int max(int n) {
		int m = 0;
		String s = String.valueOf(n);
		for(int i=0;i<=s.length()-1;i++) {
			for(int j=i+1;j<=s.length()-1;j++) {
				m = Math.max(m, Integer.parseInt(s.substring(i, j))*Integer.parseInt(s.substring(j)));
			}
		}
		return m;
	}
	
	static int count(int n,int cnt) {
		cnt++;
		for(int a:box) {
			if(a==n)
				return -1;
		}
		box.add(n);
		
		if(String.valueOf(n).length()==1) {
			return cnt-1;
		}
		else {
			return count(max(n),cnt);
		}
	}
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		while(q--!=0) {
			int n = sc.nextInt();
			box = new ArrayList<>();
			int cnt=0;
			System.out.println(count(n,cnt));
		}
	}
}
