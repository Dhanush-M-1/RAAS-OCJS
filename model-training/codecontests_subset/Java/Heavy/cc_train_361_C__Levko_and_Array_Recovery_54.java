import java.io.PrintWriter;
import java.util.Scanner;


public class c {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		PrintWriter out = new PrintWriter (System.out);
		int n = in.nextInt();
		int m = in.nextInt();
		int[] add = new int[n+1];
		int[] max = new int[n+1];
		for (int i = 0;i<=n;i++){
			max[i] = 1000000000;
		}
		int[] t = new int[m+1];
		int[] l = new int[m+1];
		int[] r = new int[m+1];
		int[] d = new int[m+1];
		int[] ma = new int[m+1];
		for (int i = 0;i<m;i++){
			t[i] = in.nextInt();
			if (t[i]==1) {
				l[i] = in.nextInt();
				r[i] = in.nextInt();
				d[i] = in.nextInt();
				for (int j = l[i];j<=r[i];j++){
					add[j]+=d[i];
				}
			} else {
				l[i] = in.nextInt();
				r[i] = in.nextInt();
				ma[i] = in.nextInt();
				for(int j = l[i];j<=r[i];j++){
					max[j] = Math.min(ma[i] - add[j],max[j]);
				}
			}
		}
		boolean ok = true;
		int[] add2 = new int[n+1];
		for (int i = 0;i<m;i++){
			if (t[i]==1) {
				for (int j = l[i];j<=r[i];j++){
					add2[j]+=d[i];
				}
			} else {
				boolean ok1 = false;
				for(int j = l[i];j<=r[i];j++){
					if (max[j]+add2[j] == ma[i]) {
						ok1 = true;
						//out.println(i+" "+j+" "+max[j]+" "+add2[j]+" "+ma[i]);
						break;
					}
				}
				if (!ok1) {
					ok = false;
					break;
				}
			}
		}
		if (ok) {
			out.println("YES");
			for (int i = 1;i<=n;i++){
				out.print(max[i]+" ");
			}
		} else out.println("NO");
		out.flush();
	}

}
