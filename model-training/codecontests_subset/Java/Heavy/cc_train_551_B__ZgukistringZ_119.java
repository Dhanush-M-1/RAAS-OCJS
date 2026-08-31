import java.io.*;
import java.util.*;

public class Main {
	  public static void main(String[] args) {
	        InputStream inputStream = System.in;
	        OutputStream outputStream = System.out;
	        InputReader in = new InputReader(inputStream);
	            try (PrintWriter out = new PrintWriter(outputStream)) {
	            	TaskB solver = new TaskB();
	                solver.solve(in, out);
	            }
	    }
}
class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokenizer;

    public InputReader(InputStream inputstream) {
      reader = new BufferedReader(new InputStreamReader(inputstream));
      tokenizer = null;
    }
    
    public String nextLine(){
    	String fullLine=null;
    	while (tokenizer == null || !tokenizer.hasMoreTokens()) {
            try {
              fullLine=reader.readLine();
            } catch (IOException e) {
              throw new RuntimeException(e);
            }
            return fullLine;
          }
          return fullLine;
    }
	public String next() {
      while (tokenizer == null || !tokenizer.hasMoreTokens()) {
        try {
          tokenizer = new StringTokenizer(reader.readLine());
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return tokenizer.nextToken();
    }
	public long nextLong() {
	      return Long.parseLong(next());
	    }
    public int nextInt() {
      return Integer.parseInt(next());
    }
  }
class TaskB {
	void solve(InputReader in,PrintWriter out){
		String a=in.nextLine();
		String b=in.nextLine();
		String c=in.nextLine();
		String abc="abcdefghijklmnopqrstuvwxyz";
		int arrA[]=new int[27];
		int newArr[]=new int[27];
		int arrB[]=new int[27];
		int arrC[]=new int[27];
		for(int i=0;i<a.length();i++){
			arrA[a.charAt(i)-96]++;
			newArr[a.charAt(i)-96]++;
		}
		for(int i=0;i<b.length();i++){
			arrB[b.charAt(i)-96]++;
		}
		for(int i=0;i<c.length();i++){
			arrC[c.charAt(i)-96]++;
		}
		
		long max=0;
		int maxB=0;
		int maxC=0;
		for(int i=0;i<100000;i++){
			boolean flagB=true;
			for(int j=1;j<=26;j++){
				if(arrA[j]<arrB[j]*i){
					flagB=false;
					break;
				}
			}
			if(!flagB)
				break;
			int ext[]=arrA.clone();
			for(int j=1;j<=26;j++){
				ext[j]-=i*arrB[j];
			}
			int countC=1000000;
			for(int j=1;j<=26;j++){
				if(arrC[j]>0)
					countC=Math.min(countC,ext[j]/arrC[j] );
			}
			long sum=i+countC;
			if(sum>max){
				max=sum;
				maxB=i;
				maxC=countC;
			}
		}
		int arr[]=arrA.clone();
		for(int j=1;j<27;j++){
			arr[j]-=arrB[j]*maxB;
		}
		for(int j=1;j<27;j++){
			arr[j]-=arrC[j]*maxC;
		}
		String ans="";
		for(int i=0;i<maxB;i++){
			ans=ans.concat(b);
		}
		for(int i=0;i<maxC;i++){
			ans=ans.concat(c);
		}
		for(int i=1;i<=26;i++){
			while(arr[i]>0){
				ans=ans.concat(abc.substring(i-1, i));
				arr[i]--;
			}
		}
		out.println(ans);
	}
}
