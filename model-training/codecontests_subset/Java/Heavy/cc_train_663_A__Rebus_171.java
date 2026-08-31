import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException{
		PrintWriter pw = new PrintWriter(System.out);
        InputReader in = new InputReader(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
//        int n = Integer.parseInt(s.substring(s.indexOf("=") + 2));
//        System.out.println(s);
        
        String[] str = s.split(" ");
        
//       System.out.prin for(int i=0;i<str.length;i++)
//        	tln(str[i]);
        int n = Integer.parseInt(str[str.length - 1]);
//        System.out.println(n);
//        int n = 0;
        int count=1;
        int count1=0;
        int min = 0;
        int max = 0;
        for(int i=0;i<str.length;i++){
        	if(str[i].charAt(0)=='+'){
        		count++;
        	}
        	
        	else if(str[i].charAt(0)=='-'){
        		count1++;
        	}
        	
//        	else if(str[i])
        }
        
        min = count - (n*count1);
        max = n*count - count1;
        
        if(n<min || n>max){
        	pw.println("Impossible");
        }
        
        else{
        	
        	pw.println("Possible");
        	long sum = 0;
        	
//        	System.out.println(count+" "+count1);
        	
//        	String old = "";
        	
        	String[] str1 = new String[str.length];
        	int k=0;
        	
        	for(int i=0;i<str.length;i++){
        		if(str[i].equals("-") || str[i].equals("+")){
        			str1[k] = str[i];
        			k++;
        		}
        	}
        	
        	for(int i=0;i<k;i++){
        		
//        		System.out.println(str1[i]);
        		if(str1[i].equals("="))
        			break;
//        		if(str1[i].equals("?"))
//        			continue;
        		
//        		else
//        			old = str[i];
        		
        		int sgn = 1;
                if (i > 0 && str1[i-1].equals("-")) 
                	sgn = -1;
                
//                System.out.println(sgn);
                if (sgn == 1) 
                	count--;
                if (sgn == -1) 
                	count1--;

                for (int x = 1; x <= n; x++){
                    if ((sum + x * sgn + count - n * count1 <= n) && (sum + x * sgn + n * count - count1 >= n)) {
                        pw.print(x+" "+str1[i].charAt(0)+" ");

                        sum += x * sgn;

                        break;
                    }
                }
        		
        	}
        	
        	pw.println(Math.abs(sum-n)+" = "+n);
        }
        
        

        pw.close();
	}

static class InputReader {
		 
		private InputStream stream;
		private byte[] buf = new byte[8192];
		private int curChar;
		private int snumChars;
		private SpaceCharFilter filter;
 
		public InputReader(InputStream stream) {
			this.stream = stream;
		}
 
		public int snext() {
			if (snumChars == -1)
				throw new InputMismatchException();
			if (curChar >= snumChars) {
				curChar = 0;
				try {
					snumChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (snumChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
 
		public int nextInt() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
 
			int res = 0;
 
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
 
			return res * sgn;
		}
		
		public long nextLong() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = snext();
			}
 
			long res = 0;
 
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = snext();
			} while (!isSpaceChar(c));
 
			return res * sgn;
		}
		
		public String readString() {
			int c = snext();
			while (isSpaceChar(c))
				c = snext();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = snext();
			} while (!isSpaceChar(c));
			return res.toString();
		}
 
		public boolean isSpaceChar(int c) {
			if (filter != null)
				return filter.isSpaceChar(c);
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}
 
		public interface SpaceCharFilter {
			public boolean isSpaceChar(int ch);
		}
	}
}
