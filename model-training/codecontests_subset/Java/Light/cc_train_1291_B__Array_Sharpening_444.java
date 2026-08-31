import java.util.*;
import java.io.*;

public class K {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] a = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < a.length; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}
			int l = 0;
			int i = n - 2;
			for (; i >= 0; i--) {
				if (a[i] <= l)
					break;
				else
					l++;
			}
			if (i == -1)
				pw.println("Yes");
			else {
				l = Math.min(l - 1, a[i]);
				i--;
				for (; i >= 0; i--) {
					if (a[i] < l)
						l=a[i];
					else
						l--;
				}
//				System.out.println(l);
				if (l > -1)
					pw.println("Yes");
				else {
					////////////////////////////////////
					i = 1;
					l=0;
					for (; i < n; i++) {
						if (a[i] <= l)
							break;
						else
							l++;
					}
					if (i == n)
						pw.println("Yes");
					else {
						l = Math.min(l-1, a[i]);
						
						i++;
						for (; i < n; i++) {
							if (a[i] >= l)
								l--;
							else
								l = a[i];
						}

						if (l > -1)
							pw.println("Yes");
						else {
							pw.println("NO");
						}

					}
					//////////////////////////////////
				}

			}
		}

		pw.flush();

	}

}
