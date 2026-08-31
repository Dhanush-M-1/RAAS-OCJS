import java.util.*;
import java.io.*;
public class EdB {
	static long num = 998244353;
	public static void main(String[] args) throws Exception{
		

		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		PrintWriter out = new PrintWriter(System.out);
 		int t = Integer.parseInt(bf.readLine());
 		for(int i = 0;i<t;i++){
//	 		String input1 = bf.readLine().trim();
//	 		String input2 = bf.readLine().trim();
	 		int n = Integer.parseInt(bf.readLine());
	 		char[][] grid = new char[n][n];
	 		for(int j =0 ;j<n;j++){
	 			grid[j] = bf.readLine().trim().toCharArray();
	 		}
	 		if (grid[0][1] == grid[1][0]){
	 			int count = 0;
	 			if (grid[n-1][n-2] == grid[0][1])
	 				count++;
	 			if (grid[n-2][n-1] == grid[0][1])
	 				count++;
	 			out.println(count);
	 			if (grid[n-1][n-2] == grid[0][1])
	 				out.println(n+ " " + (n-1));
	 			if (grid[n-2][n-1] == grid[0][1])
	 				out.println((n-1)+ " " + n);
	 		}
	 		else if (grid[n-2][n-1] == grid[n-1][n-2]){
	 			int count = 0;
	 			if (grid[n-1][n-2] == grid[0][1])
	 				count++;
	 			if (grid[n-2][n-1] == grid[1][0])
	 				count++;
	 			out.println(count);
	 			if (grid[n-1][n-2] == grid[0][1])
	 				out.println(1+ " " + 2);
	 			if (grid[n-2][n-1] == grid[1][0])
	 				out.println(2+ " " + 1);
	 		}
	 		else{
	 			int count = 0;
	 			if (grid[n-1][n-2] == '0')
	 				count++;
	 			if (grid[n-2][n-1] == '0')
	 				count++;
	 			if (grid[0][1] == '1')
	 				count++;
	 			if (grid[1][0] =='1')
	 				count++;
	 			out.println(count);
	 			if (grid[n-1][n-2] == '0')
	 				out.println(n+" " + (n-1));
	 			if (grid[n-2][n-1] == '0')
	 				out.println((n-1)+" " + n);
	 			if (grid[0][1] == '1')
	 				out.println(1+" " + 2);
	 			if (grid[1][0] =='1')
	 				out.println(2+" " + 1);
	 			
	 		}
	 		
	 	}
 		
 		
 		out.println();
	 		
 		out.close();
 		
 		
 		
 	}
}
 	
 
//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is

 		
 		
 		
 		
	


