import java.util.*;

class Main {

	static int N;
	static void dfs(int cnt, StringBuilder x) {
		if (x.length()==N) {
			System.out.println(x);
		} else {
			for (int i=(int)'a';i<=(int)'a'+cnt+1;i++) {
				StringBuilder sb = new StringBuilder(x);
				sb.append((char)i);
				if (i==(int)'a'+cnt+1) {
					dfs(cnt+1, sb);
				} else {
					dfs(cnt, sb);
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		sb.append('a');
		dfs(0, sb);
	}
}