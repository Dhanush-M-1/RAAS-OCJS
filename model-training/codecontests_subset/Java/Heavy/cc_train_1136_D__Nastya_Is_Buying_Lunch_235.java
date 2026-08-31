import java.util.*;
import java.io.*;
import java.util.regex.*;

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
		
		char nc(){
			return nn().charAt(0);
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
		
		int[] niArr0(int n){
			int[] ar = new int[n];
			for(int i = 0; i < n; i++) ar[i] = ni();
			return ar;
		}
		
		int[] niArr1(int n){
			int[] ar = new int[n + 1];
			for(int i = 1; i <= n; i++) ar[i] = ni();
			return ar;
		}
		
		long[] nlArr0(int n){
			long[] ar = new long[n];
			for(int i = 0; i < n; i++) ar[i] = nl();
			return ar;
		}
	}
	
	public static <T> void mprintln(T ... ar){
		for(T i: ar) out.print(i + " ");
		out.println();
	}
	
	private static PrintWriter out;
	
	public static void main(String[] args) throws FileNotFoundException{
		
		// Input from file
		// File inputFile = new File("JavaFile.txt");
		// File outputFile = new File("JavaOutputFile.txt");
		// FileReader fileReader = new FileReader(inputFile);
		// Here it ends
			
		MyScanner sc = new MyScanner();
		// MyScanner sc = new MyScanner(fileReader);
		
		out = new PrintWriter(new BufferedOutputStream(System.out)); // Output to console
		// out = new PrintWriter(new PrintStream(outputFile)); // Output to file
		
		getAns(sc);
		
		out.close();
	}
	
	private static void getAns(MyScanner sc){
		int n = sc.ni(), m = sc.ni();
		int[] pi = sc.niArr1(n);
		
		ArrayList<Integer> list[] = new ArrayList[n + 1];
		for(int i = 1; i <= n; i++) list[i] = new ArrayList();
		
		while(m-- > 0){
			int u = sc.ni(), v = sc.ni();
			list[u].add(v);
		}
		
		boolean[] pro = new boolean[n + 1];
		
		int ans = 0, count = 1;
		pro[pi[n]] = true;
		
		for(int i = n - 1; i >= 1; i--){
			int cur = 0;
			for(Integer in: list[pi[i]]) if(pro[in]) cur++;
			
			if(count == cur){
				ans++;
			}else{
				count++;
				pro[pi[i]] = true;
			}
		}
		
		out.println(ans);
	}
}