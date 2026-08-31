import java.io.*;
import java.util.*;
public class Bulbs {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < m; i++) {
			list.add(i+1);
		}
		for(int i = 0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			int len = st.countTokens();
			for(int j = 0; j < len; j++) {
				list.remove(new Integer(Integer.parseInt(st.nextToken())));
			}
		}
		if(list.size() == 0) System.out.println("YES");
		else System.out.println("NO");
	}

}
