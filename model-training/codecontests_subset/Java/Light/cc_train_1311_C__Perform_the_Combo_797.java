import java.io.*; 
public class c3_02_24 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		for(int t = 1; t <= tc; t++) {
			int alpha[] = new int[26];

			String sa[] = br.readLine().split(" ");
			int n = Integer.parseInt(sa[0]);
			int m = Integer.parseInt(sa[1]);
			String s = br.readLine();
			int mis[] = new int[m];
			sa = br.readLine().split(" ");
			
			for(int i = 0; i < m; i++)
				mis[i] = Integer.parseInt(sa[i]);
			int index[] = new int[n];
			
			for(int i = 0; i < m; i++) {
				index[mis[i] -1] ++;
			}
			
			int len = m+1;
			for(int i = 0; i < n; i++) {
				alpha[s.charAt(i)-'a'] += (len);
				if(index[i] != 0)
					len -= index[i];
			}


			for(int i = 0; i < 26; i++)
				System.out.print(alpha[i] + " ");
			System.out.println();
		}

	}
}
