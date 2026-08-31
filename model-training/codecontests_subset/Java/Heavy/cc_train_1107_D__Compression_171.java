import java.io.*;
import java.util.*;
import java.math.*;
import java.lang.*;
 
import static java.lang.Math.*;
 
public class fast implements Runnable {
    static class InputReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        public InputReader(InputStream stream) {
            this.stream = stream;
        }
        
        public int read() {
            if (numChars==-1) 
                throw new InputMismatchException();
            
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
                
                if(numChars <= 0)               
                    return -1;
            }
            return buf[curChar++];
        }
     
        public String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();
            
            while(isSpaceChar(c)) 
                c = read();
            
            int sgn = 1;
            
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            
            int res = 0;
            do {
                if(c<'0'||c>'9') 
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c)); 
            
            return res * sgn;
        }
        
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
                return res * sgn;
        }
        
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c)) {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
        
        public String readString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } 
            while (!isSpaceChar(c));
            
            return res.toString();
        }
     
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
     
        public String next() {
            return readString();
        }
        
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    
    class pair implements Comparable<pair>{
        int x;
        char y;
        pair(int xi, char yi){
            x=xi;
            y=yi;
        }
        @Override
        public int compareTo(pair other){
            if(this.x>other.x){return 1;}
            if(this.x<other.x){return -1;}
            return 0;
        }    
    }
 
    class dist{
        int x;
        int y;
        int z;
        dist(int xi, int yi, int zi){
            x=xi;
            y=yi;
            z=zi;
        }
    } 
    
    public static void main(String args[]) throws Exception {
        new Thread(null, new fast(),"fast",1<<26).start();
    }
    
    public void sortbyColumn(int arr[][], final int col){ 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else if(entry1[col] < entry2[col])
                return -1;
            return 0;
          } 
        });  // End of function call sort(). 
    }
    
    public void sortbyColumn(long arr[][], final int col){ 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<long[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final long[] entry1,  
                             final long[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else if(entry1[col] < entry2[col])
                return -1;
            return 0;
          } 
        });  // End of function call sort(). 
    }
    
    long power(long x, long y, long p){  
        long res = 1;      
        x = x % p;  
        while (y > 0) 
        { 
            if((y & 1)==1) 
                res = (res * x) % p; 
            y = y >> 1;  
            x = (x * x) % p;  
        } 
        return res; 
    }
    
    public void run(){
        InputReader s = new InputReader(System.in);
        PrintWriter w = new PrintWriter(System.out);
        
		int n=s.nextInt(),a[][]=new int[n][n];
		for(int i=0;i<n;i++){
			char c[]=s.next().toCharArray();
			for(int j=0;j<n/4;j++){
				int x=Integer.parseInt(Character.toString(c[j]),16);
				for(int m=j*4+3;m>=j*4;m--){
					a[i][m]=x&1;
					x>>=1;
				}
			}
		}
		for(int x=n;x>=1;x--){
			int f=0;
			if(n%x==0){
				for(int i=0;i<n;i+=x){
					for(int j=0;j<n;j+=x){
						for(int m=i;m<i+x;m++){
							for(int z=j;z<j+x;z++){
								if(a[m][z]!=a[i][j]){
									f=1;
									break;
								}
							}
							if(f==1){break;}
						}
						if(f==1){break;}
					}
					if(f==1){break;}
				}
				if(f==0){w.println(x);break;}
			}
		}
        
        w.close();
    }
}