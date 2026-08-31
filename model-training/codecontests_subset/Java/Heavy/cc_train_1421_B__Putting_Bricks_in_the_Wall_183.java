
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
public class HelloWorld {
	static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
       
  
        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreTokens()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken();
            
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        }

		public Character charAt(int i) {
			// TODO Auto-generated method stub
			return null;
		}

		public BigInteger nextBigInteger() {
			// TODO Auto-generated method stub
			return null;
		} 
    } 
	public static void main(String[] args) {
		FastReader s=new FastReader();
		int t = s.nextInt();
		while(t-->0) {
			int n = s.nextInt();
			int a=0,b=0,c=0,d=0;
			List<Integer> l = new ArrayList<>();
			for(int i=0;i<n;i++) {
				String se = s.next();
				if(i==0) a = se.charAt(1)-'0';
				if(i==1) b = se.charAt(0)-'0';
				if(i==n-2)d = se.charAt(n-1)-'0';
				if(i==n-1)c = se.charAt(n-2)-'0';
			}
			if(a==b) {
				if(c==a) {
					l.add(n);
					l.add(n-1);
				}
				if(d==a) {
					l.add(n-1);
					l.add(n);
				}
			}
			else if(c==d) {
				if(a==c) {
					l.add(1);
					l.add(2);
				}
				if(b==c) {
					l.add(2);
					l.add(1);
				}
			}
			else {
				l.add(2);
				l.add(1);
				if(a==c) {
					l.add(n);
					l.add(n-1);
				}
				if(d==a) {
					l.add(n-1);
					l.add(n);
				}
			}
			System.out.println(l.size()/2);
			for(int i=0;i<l.size();i+=2) {
				System.out.println(l.get(i)+" "+l.get(i+1));
			}

		}
			
	}

}
