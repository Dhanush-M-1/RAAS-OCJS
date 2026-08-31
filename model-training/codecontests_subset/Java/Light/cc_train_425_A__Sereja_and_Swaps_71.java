import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Codeforces {

	public static void main(String[] args) {
		new TaskA().run();
	}
	
}

class TaskA {
	
	Scanner in = new Scanner(System.in);
	PrintWriter out = new PrintWriter(System.out);
	int[] a;
	int n,m;
	public void run() {
		n = in.nextInt();
		m = in.nextInt();
		a = new int[n];
		int ans = 0xafffffff;
//		System.out.println(ans);
		for (int i = 0; i < n; ++i) {
			a[i] = in.nextInt();
		}
		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				ans = Math.max(ans,judge(i,j));
			}
		}
		out.println(ans);
		out.flush();
	}
	
	void asign(int begin, int l, int r, int[] arr) {
		for (int i = l; i <= r; ++i) {
			arr[begin] = a[i];
			begin++;
		}
	}
	
	int judge(int l, int r) {
		int[] cal = new int[r-l+1];
		asign(0, l, r, cal);
		if (cal.length < n) {
			int[] lef = new int[n-cal.length];
			asign(0, 0, l-1, lef);
			asign(l, r+1, n-1, lef);
		
			Arrays.sort(cal);
			Arrays.sort(lef);
			int j = lef.length-1;
			for (int i = 0; i < cal.length && j >= 0 && lef[j] >= cal[i] && lef.length-1-j < m; ++i) {
				cal[i] = lef[j];
				--j;
			}
		}
		int ret = 0;
		for (int i = 0; i < cal.length; ++i) {
			ret += cal[i];
		}
		return ret;
	}
}
