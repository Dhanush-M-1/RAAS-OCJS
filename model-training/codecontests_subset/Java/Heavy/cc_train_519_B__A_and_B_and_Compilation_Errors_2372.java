import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CompilationErrors {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String fi = bf.readLine();
		String se = bf.readLine();
		String th = bf.readLine();
		StringTokenizer st = new StringTokenizer(fi);
		int f[] = new int[n];
		for(int i =0 ; i<f.length;i++){
			f[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(se);
		int s[] = new int[n-1];
		for(int i =0 ; i<s.length;i++){
			s[i]=Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(th);
		int t[] = new int[n-2];
		for(int i =0 ; i<t.length;i++){
			t[i]=Integer.parseInt(st.nextToken());
		}
		Arrays.sort(f);
		Arrays.sort(s);
		Arrays.sort(t);
		for (int i = 0; i < n; i++){
			if (i<n-1){
				if (f[i]!=s[i]){
					System.out.println(f[i]);
					break;
				}

			}
			else{
				System.out.println(f[i]);
			}
		}
		for (int i = 0; i < n-1; i++){
			if (i<n-2){
				if (s[i]!=t[i]){
					System.out.print(s[i]);
					break;
				}

			}
			else {
				System.out.print(s[i]);
			}

		}

	}
}