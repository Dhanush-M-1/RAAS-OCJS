import java.util.*;
import java.io.*;
public class EdD {

	public static void main(String[] args) throws Exception{
		int num = 998244353;

		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		PrintWriter out = new PrintWriter(System.out);
 		int t = Integer.parseInt(bf.readLine());
 		for(int i = 0;i<t;i++){
	 		int n = Integer.parseInt(bf.readLine());
	 		double sum =0;
	 		for(int j = 0;j<n;j++){
	 			double k = Math.PI/(2*n+0.0) + j/(n+0.0)*Math.PI;
	 			sum+=Math.sin(k);
	 			
	 		}
	 		sum = sum * Math.cos(Math.PI/(4*n));
	 		out.println(sum);
 		}
 	
 		
 		out.close();
 		
 	}
 	
 }
//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is

 		
 		
 		
 		
	


