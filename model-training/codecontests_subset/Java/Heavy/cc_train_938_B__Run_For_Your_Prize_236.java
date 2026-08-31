import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * 
 * Comments Here
 * 
 */
public class B38
{
	static BufferedReader br; 
	static BufferedWriter bw; 
	static StringTokenizer st;

	public static void main(String[] args) throws java.lang.Exception
	{
		/**/
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
    		//Uncomment to read from file
    		/*/
		File file = new File("2016/A.in");
		br = new BufferedReader(new FileReader(file));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		/**/
		
		int n = Integer.parseInt(br.readLine());
		
		int[] ps = new int[n+2];
		ps[0] = 1;
		ps[n+1] = 1000000;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= n; ++i) {
			ps[i] = Integer.parseInt(st.nextToken());
		}
		
		int mindist = Integer.MAX_VALUE;
		for(int i = 0; i < n+1; ++i) {
			int dist = Math.max(ps[i]-1, 1000000-ps[i+1]);
			mindist = Math.min(dist, mindist);
		}
		
		bw.write(mindist+"\n");
		
				
		
		br.close();
		bw.close();
	}
	

	
	
}

