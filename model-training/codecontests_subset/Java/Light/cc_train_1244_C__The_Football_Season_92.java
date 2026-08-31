import java.util.*;
import java.io.*;

	 
public class Main {
	
	public static void main(String args[]){
		InputReader obj = new InputReader(System.in);
		long n = obj.nextLong();
		long p = obj.nextLong();
		int w = obj.nextInt();
		int d = obj.nextInt();
		
		for(long j=0;j<w;j++){
			if((p-j*d)>=0){
				if((p-(long)j*d)%w==0){
					if((j+(p-(long)j*d)/w)<=n){
						System.out.println(((p-(long)j*d)/w)+" "+j+" "+(n-((p-(long)j*d)/w)-j));
						return;
					}
				}
			}
		}
		System.out.println(-1);
	}		
	
	public static class InputReader {
	    public BufferedReader reader;
	    public StringTokenizer tokenizer;
 
	    public InputReader(InputStream stream) {
	        reader = new BufferedReader(new InputStreamReader(stream), 32768);
	        tokenizer = null;
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
 
	    public int nextInt() {
	        return Integer.parseInt(next());
	    }
 
	    public long nextLong() {
	        return Long.parseLong(next());
	    }
	    
 
	}
}
    