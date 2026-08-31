import java.io.*;
import java.util.*;

public class Div2_351_D {
	public static void main(String[] args) throws IOException {
		BufferedInputStream bis = new BufferedInputStream(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(bis));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String line;
		StringTokenizer st;
		while ((line = br.readLine()) != null && !line.equals("")) {
			st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int [] vertices = new int[4];
			HashSet <Integer> endpoints = new HashSet<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < vertices.length; i++) {
				vertices[i] = Integer.parseInt(st.nextToken());
				endpoints.add(vertices[i]);
			}
			if(n == 4 || k <= n)
				out.println(-1);
			else {
				int [] others = new int[n-4];
				out.print(vertices[0]+" "+vertices[2]+" ");
				int last = 0, cnt = 0;
				for(int i = 1;i <= n;i++) {
					if(!endpoints.contains(i)) {
						last = i;
						others[cnt++] = i;
					}
				}
				for(int x:others)
					out.print(x+" ");
				out.println(vertices[3]+" "+vertices[1]);
				out.print(vertices[2]+" "+vertices[0]+" ");
				for(int x:others)
					out.print(x+" ");
				out.println(vertices[1]+" "+vertices[3]);
			}
		}
		out.close();
	}
}