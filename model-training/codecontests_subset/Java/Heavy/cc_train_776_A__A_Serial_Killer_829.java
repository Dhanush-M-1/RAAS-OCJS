/*
 *
 * @author Mukesh Singh
 *
 */

import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
@SuppressWarnings("unchecked")
public class AB {	
	//solve test cases
	void solve() throws Exception {
			String str1=in.nextToken();
			String str2=in.nextToken();
			int n=in.nextInt();
			System.out.println(str1+" "+str2);
			for(int i=0;i<n;i++){
				String str3=in.nextToken();
				String str4=in.nextToken();
				if(str1.equals(str3)){
					str1=str4;
				}else if(str1.equals(str4)){
					str1=str3;
				}else if(str2.equals(str3)){
					str2=str4;
				}else if(str2.equals(str4)){
					str2=str3;
				}
				System.out.println(str1+" "+str2);
			}
	}
	//@ main function
	public static void main(String[] args) throws Exception {
		new AB();
	}
	
	InputReader in;
	PrintStream out ;
	DecimalFormat df ;
	AB() {
		try {
			File defaultInput = new File("file.in");
			if (defaultInput.exists()) 
				in = new InputReader("file.in");
			else 
				in = new InputReader();
			defaultInput = new File("file.out");
			if (defaultInput.exists()) 
				out = new PrintStream(new FileOutputStream("file.out"));
			else
				out = new PrintStream(System.out);
			df = new DecimalFormat("######0.00");
			solve();
			out.close();
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.exit(261);
		}
	}
	
	class InputReader {
		BufferedReader reader;
		StringTokenizer tokenizer;
		
		InputReader() {
			reader = new BufferedReader(new InputStreamReader(System.in));
		}
		
		InputReader(String fileName) throws FileNotFoundException {
			reader = new BufferedReader(new FileReader(new File(fileName)));
		}
		
		String readLine() throws IOException {
			return reader.readLine();
		}
		
		String nextToken() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens())
				tokenizer = new StringTokenizer(readLine());
			return tokenizer.nextToken();
		}
		
		boolean hasMoreTokens() throws IOException {
			while (tokenizer == null || !tokenizer.hasMoreTokens()) {
				String s = readLine();
				if (s == null)
					return false;
				tokenizer = new StringTokenizer(s);
			}
			return true;
		}
		
		int nextInt() throws NumberFormatException, IOException {
			return Integer.parseInt(nextToken());
		}
		
		long nextLong() throws NumberFormatException, IOException {
			return Long.parseLong(nextToken());
		}
		
		double nextDouble() throws NumberFormatException, IOException {
			return Double.parseDouble(nextToken());
		}
	}
}