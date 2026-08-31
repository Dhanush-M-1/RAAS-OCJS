import java.util.*;
import java.io.*;
public class EdB {

	public static void main(String[] args) throws Exception{
		int num = 998244353;

		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		PrintWriter out = new PrintWriter(System.out);
 		int t = Integer.parseInt(bf.readLine());
 		for(int i = 0;i<t;i++){
//	 		String input1 = bf.readLine().trim();
//	 		String input2 = bf.readLine().trim();
 			int n = Integer.parseInt(bf.readLine());
 			StringTokenizer st = new StringTokenizer(bf.readLine());
 			long [] array = new long[n];
 			
 			for(int j=0;j<n;j++){
 				array[j] = Long.parseLong(st.nextToken());
 			}
 			int count = 0;
 			for(int j = 0;j<n;j++){
 				if (array[j] >= j)
 					count++;
 				else
 					break;
 			}
 			int count2 =0;
 			for(int j = n-1;j>=0;j--){
 				if (array[j] >= n-1-j)
 					count2++;
 				else
 					break;
 			}
 			if (count2+count >n){
 				out.println("Yes");
 			}
 			else
 				out.println("No");
	 		
	 		
	 		
 		}
 		
 		
 		out.println();
	 		
 		out.close();
 		
 		
 		
 	}
}
 	
 
//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is

 		
 		
 		
 		
	


