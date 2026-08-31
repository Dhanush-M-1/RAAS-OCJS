import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 
 * Comments Here
 * 
 */
public class E33D
{
	static BufferedReader br; 
	static BufferedWriter bw; 
	static StringTokenizer st;
	static FileReader fr;

	public static void main(String[] args) throws java.lang.Exception
	{
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		/**/
		br = new BufferedReader(new InputStreamReader(System.in));
    		/*/
    		File file = new File("src/in.txt");
		fr = new FileReader(file);
		/**/
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		long[] b = new long[n+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; ++i){
			b[i] = b[i-1]+Long.parseLong(st.nextToken());
		}
		
		
		long[] minc = new long[n+1];
		long[] maxc = new long[n+1];
		
		maxc[0] = d;
		
		for(int i = 1; i <= n; ++i){
			
			maxc[i] = d-b[i];
			
			if(b[i] == b[i-1]) {
				
				minc[i] = Math.max(0L, 0L-b[i]);
				
			} 
			
			
		}
		
		for(int i = 1; i <= n; ++i) {
			minc[i] = Math.max(minc[i], minc[i-1]);
		}
		
		for(int i = n-1; i >= 0; --i) {
			maxc[i] = Math.min(maxc[i], maxc[i+1]);
		}
		

		
		for(int i = 0; i <= n; ++i) {
			if(maxc[i] < minc[i]){
				bw.write("-1\n");
				bw.close();
				br.close();
				return;
			}
		}
		
		int trans = 0;
		long val = 0L;
		
		for(int i = 0; i <= n; ++i) {
			if(val < minc[i]) {
				++trans;
				val = maxc[i];
			}
		}
		
		bw.write(trans+"\n");
		
		
//		bw.write(Arrays.toString(b) + "\n");
//		bw.write(Arrays.toString(minc) + "\n");
//		bw.write(Arrays.toString(maxc) + "\n");
		
		br.close();
		bw.close();
	}
	

	
	
}

