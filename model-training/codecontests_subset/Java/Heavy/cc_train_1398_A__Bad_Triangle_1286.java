import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Practice {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while ((t--) > 0) {

			int n = Integer.parseInt(br.readLine());
			long []arr=new long[n];
		    String str=(br.readLine());
		    String[] s1=str.split(" ");
		    for(int i=0;i<n;i++){
		        arr[i]=Long.parseLong(s1[i]);
		    }
		    if(arr[0]+arr[1]<=arr[n-1]) {
		    	System.out.println("1 2 "+(n));
		    }else {
		    	System.out.println(-1);
		    }
		}
	}

}
