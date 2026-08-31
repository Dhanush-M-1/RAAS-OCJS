import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Codeforces421A {
 public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int c = Integer.parseInt(st.nextToken());
	int vi = Integer.parseInt(st.nextToken());
	int vf = Integer.parseInt(st.nextToken());
	int a = Integer.parseInt(st.nextToken());
	int l = Integer.parseInt(st.nextToken());
	
	int days=0;
	int done = 0;
	

	

	
	while(done < c){
		int toread = vi + (a*days);
		
		if(toread>vf)
			toread = toread - (toread - vf);
		
		done += toread;
		
		if(days>=1)
			done -= l;
			days++;
	}
		
		System.out.println(days);
}
}
