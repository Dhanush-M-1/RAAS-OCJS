import java.util.*;
import java.io.*;
public class EdA {

	public static void main(String[] args) throws Exception{
		int num = 998244353;

		// TODO Auto-generated method stub
 		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
 		PrintWriter out = new PrintWriter(System.out);
 		int t = Integer.parseInt(bf.readLine());
 		for(int i = 0;i<t;i++){
//	 		String input1 = bf.readLine().trim();
//	 		String input2 = bf.readLine().trim();
	 		StringTokenizer st = new StringTokenizer(bf.readLine());
	 		int n = Integer.parseInt(st.nextToken());
	 		int m = Integer.parseInt(st.nextToken());
	 		ArrayList<Integer> array1 = new ArrayList<Integer>();
	 		StringTokenizer st2 = new StringTokenizer(bf.readLine());
	 		Set<Integer> one = new HashSet<Integer>();
	 		for(int j=0;j<n;j++){
	 			array1.add(Integer.parseInt(st2.nextToken()));
	 			one.add(array1.get(j));
	 		}
	 		
	 		ArrayList<Integer> array2 = new ArrayList<Integer>();
	 		Set<Integer> two = new HashSet<Integer>();
	 		StringTokenizer st3 = new StringTokenizer(bf.readLine());
	 		for(int j=0;j<m;j++){
	 			array2.add(Integer.parseInt(st3.nextToken()));
	 			two.add(array2.get(j));
	 		}
	 		one.retainAll(two);
	 		if (one.size() == 0){
	 			out.println("NO");
	 		}
	 		else{
	 			for(int j : one){
	 				out.println("YES");
	 				out.println("1 " + j);
	 				break;
	 			}
	 		}
 		}
 		
 		
 		out.println();
	 		
 		out.close();
 		
 		
 		
 	}
}
 	
 
//StringJoiner sj = new StringJoiner(" "); 
//sj.add(strings)
//sj.toString() gives string of those stuff w spaces or whatever that sequence is

 		
 		
 		
 		
	


