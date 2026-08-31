import java.util.*;
import java.io.*;
public class EdF {

	public static void main(String[] args) throws Exception{
		int num = 998244353;

		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		PrintWriter out = new PrintWriter(System.out);
//	 		String input1 = bf.readLine().trim();
//	 		String input2 = bf.readLine().trim();
 		int n = Integer.parseInt(bf.readLine());
	 	StringTokenizer st = new StringTokenizer(bf.readLine());
	 	ArrayList<Integer> array = new ArrayList<Integer>();
	 	for(int j = 0;j<n;j++){
	 		array.add(Integer.parseInt(st.nextToken()));
	 	}
	 	Collections.sort(array);
	 	int min = Integer.MAX_VALUE;
	 	for(int j = 0;j<n-1;j++){
	 		min = Math.min(min,  Math.max(array.get(j)-1, 1000000-array.get(j+1)));
	 	}
	 	min = Math.min(array.get(n-1)-1,  min);
	 	min = Math.min(1000000-array.get(0), min);
	 	out.println(min);
 		out.close();
 		
 		
 		
 	}

}
 	
 
//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is

 		
 		
 		
 		
	


