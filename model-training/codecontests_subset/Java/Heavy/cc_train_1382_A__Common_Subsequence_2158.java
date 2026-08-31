import java.io.*;
import java.util.*;

public class common {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			HashSet<Integer> h = new HashSet<Integer>();
			for (int k = 0; k < n; k++){
				h.add(Integer.parseInt(st.nextToken()));
			}
			
			st = new StringTokenizer(br.readLine());
			boolean yes = false;
			
			for (int k = 0; k < m; k++){
				int x = Integer.parseInt(st.nextToken());
				if (h.contains(x)){
					pw.println("YES");
					pw.println("1 " + x);
					yes = true;
					break;
				}
			}
			
			if (yes == false){
				pw.println("NO");
			}
		}
		
		pw.close();
		br.close();
	}
}
