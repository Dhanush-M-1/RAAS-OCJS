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
		int q = sc.ni();
		while(q-- > 0){
			long l = sc.nl(), r = sc.nl(), d = sc.nl();
			if(d < l) out.println(d);
			else out.println((r / d + 1) * d);
		}
	}
}