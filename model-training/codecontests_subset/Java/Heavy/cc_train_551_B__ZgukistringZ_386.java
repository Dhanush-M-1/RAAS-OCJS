
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



public class B307 {
	public int countS(int[] aArray,int[] temp,String S,int[] sArray){
		int min=Integer.MAX_VALUE;
		for(int g=0;g<S.length();g++){
			int i=S.charAt(g)-'a';
			min=Math.min(min, ((aArray[i]-temp[i])/sArray[i]));
		}
		return min;
	}
	
	public void solve(FastScanner in, PrintWriter out){
		String A=in.next();
		String B=in.next();
		String C=in.next();
		StringBuilder K= new StringBuilder();
		
		if(C.length()<B.length()){
			String T=C;
			C=B;
			B=T;
		}
		
		int[] aArray=new int[28];
		int[] bArray=new int[28];
		int[] cArray=new int[28];
		
		int[] temp=new int[28];
		for(int g=0;g<A.length();g++){
			aArray[A.charAt(g)-'a']++;
		}
		for(int g=0;g<B.length();g++){
			bArray[B.charAt(g)-'a']++;
		}
		for(int g=0;g<C.length();g++){
			cArray[C.charAt(g)-'a']++;
		}
		
		int countB=countS(aArray,temp, B,bArray);
		
		
		int bestB=0;
		int bestC=countS(aArray,temp, C,cArray);
	
		int best=Integer.MIN_VALUE;
		for(int g=1;g<=countB;g++){
			for(int i=0;i<B.length();i++){
				temp[B.charAt(i)-'a']++;
			}
			int countC=countS(aArray,temp, C,cArray);
			
		
			if(g+countC>best){
				best=g+countC;
				bestB=g;
				bestC=countC;
			}
		}

		for(int i=0;i<B.length();i++){
			aArray[B.charAt(i)-'a']-=bestB;
		}
		for(int i=0;i<C.length();i++){
			aArray[C.charAt(i)-'a']-=bestC;
		}
		
		for(int g=0;g<bestB;g++){
			K.append(B);
		}
		for(int g=0;g<bestC;g++){
			K.append(C);
		}
			
		for(int i=0;i<aArray.length;i++){
			for(int g=0;g<aArray[i];g++)
				K.append((char)('a'+i));
		}
		
		System.out.println(K.toString());
		
	}
	
	
	
	
	
	
	
	public static void main(String[] args) throws IOException {
		try (FastScanner scanner = new FastScanner(System.in);
	            PrintWriter writer = new PrintWriter(System.out)) {
	            new B307().solve(scanner, writer);
	        }
	}
	
	private static class FastScanner implements Closeable {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        public FastScanner(String filename) throws FileNotFoundException {
            reader = new BufferedReader(new FileReader(filename));
        }

        public FastScanner(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String readLine() {
            try {
                return reader.readLine();
            } catch (IOException e) {
                return null;
            }
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                String line = readLine();
                if (line == null) return null;
                tokenizer = new StringTokenizer(line);
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public BigInteger nextBigInteger() {
            return new BigInteger(next());
        }

        public float nextFloat() {
            return Float.parseFloat(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public BigDecimal nextBigDecimal() {
            return new BigDecimal(next());
        }

        @Override
        public void close() throws IOException {
            reader.close();
        }
    }
	

}
