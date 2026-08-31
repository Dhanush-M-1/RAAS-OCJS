import java.io.*;
import java.util.*;
import java.math.*;
import java.util.Collections.*;


public class Reverse_a_Substring{

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t;
		//t = Integer.parseInt(br.readLine());
		t=1;
		while(t-->0){
			int n = Integer.parseInt(br.readLine());

			String ar[] = br.readLine().split(" ");
			String str = ar[0];

			int fl=0;

			for(int i=1;i<n;i++){
				if(str.charAt(i-1)>str.charAt(i)){
					fl=1;
					System.out.println("YES\n"+i+" "+(i+1));
					break;
				}
			}
			if(fl==0) 
			 	System.out.println("NO");

		}
	
 	}		
}