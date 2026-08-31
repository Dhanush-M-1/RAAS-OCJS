import java.io.*;
import java.lang.*;
import java.util.*;
import java.text.*;


public class Main {
	

	public static void main(String[] args) throws IOException {

		//BufferedReader cin = new BufferedReader(new FileReader("test.txt"));
		 BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	
		
		String line;
		StringTokenizer st;
		
		line = cin.readLine();
		st = new StringTokenizer(line);
		int n=Integer.parseInt(st.nextToken());
		  
		int[] pos = new int[n];
		int[] high = new int[n];
	
		for(int i=0;i<n;i++){
			line = cin.readLine();
			st = new StringTokenizer(line);
			pos[i]=Integer.parseInt(st.nextToken());
			high[i]=Integer.parseInt(st.nextToken());
		}
		int ans=2;
		for(int i=1;i<n-1;i++){
			if(high[i]<(pos[i]-pos[i-1])){//left fall
				ans++;
			}
			else if(high[i]<(pos[i+1]-pos[i])){//right fall
					ans++;
					pos[i]+=high[i];
				}
		}

		if(n<2)System.out.println(n);
		else System.out.println(ans);
		
		cin.close();
	}

}