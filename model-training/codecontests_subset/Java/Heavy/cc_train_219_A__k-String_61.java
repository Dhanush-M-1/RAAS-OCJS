import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.math.BigInteger;

public class Codeforces{
	
	static class MyScanner{
		BufferedReader br;
		StringTokenizer st;
		
		MyScanner(FileReader fileReader){
			br = new BufferedReader(fileReader);
		}
		
		MyScanner(){
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		
		String nn(){
			while(st == null || !st.hasMoreElements()){
				try{
					st = new StringTokenizer(br.readLine());
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		
		int ni(){
			return Integer.parseInt(nn());
		}
		
		long nl(){
			return Long.parseLong(nn());
		}
		
		double nd(){
			return Double.parseDouble(nn());
		}
	}
	
	private static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		
		// Input from file
		// File inputFile = new File("input.txt");
		// File outputFile = new File("output.txt");
		// FileReader fileReader = new FileReader(inputFile);
		// Here it ends
			
		MyScanner sc = new MyScanner();
		
		out = new PrintWriter(new BufferedOutputStream(System.out)); // Output to console
		// out = new PrintWriter(new PrintStream(outputFile)); // Output to file
		
		int k = sc.ni();
		String s = sc.nn();
		int n = s.length();
		HashMap<Character, Integer> hashMap = new HashMap<>();
		
		for(int i = 0; i < n; i++){
			if(!hashMap.containsKey(s.charAt(i))) hashMap.put(s.charAt(i), 1);
			else hashMap.put(s.charAt(i), 1 + hashMap.get(s.charAt(i)));
		}
		
		if(conditionSatisfies(k, n, hashMap)){
			StringBuilder sb = new StringBuilder();
			Set<Character> set = hashMap.keySet();
			
			for(Character c: set){
				for(int i = 0; i < hashMap.get(c); i++) sb.append(c);
			}
			
			for(int i = 0; i < k; i++) out.print(sb);
			
		}else{
			out.println(-1);
		}
		
		out.close();
	}
	
	private static boolean conditionSatisfies(int k, int n, HashMap<Character, Integer> hashMap){
		Set<Character> set = hashMap.keySet();
		
		// System.out.println(hashMap);
		
		for(Character c: set){
			if(hashMap.get(c) % k != 0)
				return false;
			hashMap.put(c, hashMap.get(c) / k);
		}
		return true;
	}
}