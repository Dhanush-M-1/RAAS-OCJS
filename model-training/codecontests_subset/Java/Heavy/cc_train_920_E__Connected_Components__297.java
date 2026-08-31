import java.io.*;
import java.util.*;
public class Codeforces920E {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m =Integer.parseInt(st.nextToken());
		TreeSet<Integer>[] a = new TreeSet[n];
		for (int i = 0; i < a.length; i++) {
			a[i]= new TreeSet<Integer>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int u= Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			a[Math.min(u, v)].add(Math.max(u, v));
		}
		int[] size = new int[n];
		Arrays.fill(size, 1);
		ArrayList<Integer> setSizes= new ArrayList<Integer>();
		w:for (int i = 0; i < n; i++) {
			for (int j = i+1; j < n; j++) {
				if(!a[i].contains(j))
				{
					size[j]+=size[i];
					TreeSet<Integer> set = new TreeSet<Integer>();
					for (int x: a[i]) {
						if(a[j].contains(x))
						{
							set.add(x);
						}
					}
					a[j]=set;
					continue w;
				}
			}
			setSizes.add(size[i]);
		}
		pw.println(setSizes.size());
		Collections.sort(setSizes);
		for (int i = 0; i < setSizes.size(); i++) {
			pw.print(setSizes.get(i) + " ");
		}
		pw.println();
		pw.close();
	}
}
