import java.io.*;
import java.util.*;

public class OddPolygonEmbedding {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			double angle = Math.PI / (2 * n);
			sb.append(Math.cos(angle / 2) / Math.sin(angle));
			sb.append('\n');
		}
		br.close();
		System.out.print(sb.toString());
	}
}