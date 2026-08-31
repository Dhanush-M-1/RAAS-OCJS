import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Practice{
	
	public static void main(String[] args) throws Exception{
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int home[] = new int[n];
		int away[] = new int[n];
		
		for(int j = 0; j < n; j++){
			String inp[] = br.readLine().split(" ");
			home[j] = Integer.parseInt(inp[0]);
			away[j] = Integer.parseInt(inp[1]);
		}
		int count = 0;
		for(int j = 0; j < home.length; j++){
			for(int k = 0; k < away.length; k++){
				if((home[j] == away[k]) && (j != k))
					count++;
			}
		}
		
		System.out.println(count);
	}
}