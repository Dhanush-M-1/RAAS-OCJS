import java.io.*;
import java.util.*;
import java.math.*;

 public class atharva {

    InputStream is;
    PrintWriter out;
    
    long mod = (long)(1e9 + 7), inf = (long)(1e18);
    
    class pair {
        long A, B;
        pair(long a, long b) {
            A = a;  B = b;
        }
    }
    
    void solve() {
     //CHAMPION CHAMPION CHAMPION CHAMPION DJ BRAVO DJ BRAVO DJ BRAVO DJ BRAVO CHAMPION CHAMPION CHAMPION CHAMPION DJ BRAVO DJ BRAVO
	 int n=ni();
	 char ch[]=ns().toCharArray();
	 int bk=0;int flg=0;int prev=0;
	 for(int i=1;i<n;i++)
	 {
		 if((int)ch[i]<(int)ch[i-1])
		 {
			 flg=1;
			 bk=i+1;
			 prev=i;
			 break;
		 }
	 }			
	 if(flg==0)
	 {out.println("NO");}
	 else
	 {
		 out.println("YES");
		 out.println(prev+" "+bk);
	 }		
	 
    }

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	static long lbound(LinkedList<Long> l,long ele)
	{
		int low=0;
		int high=l.size()-1;
		int ans=0;
		while(low<high)
		{
			int mid=(low+high)/2;
			if(l.get(mid)==ele)
			{ans=mid;break;}
			else if(l.get(mid)>ele)
			{high=mid-1;}
			else
			{ans=mid;low=mid;}	
		}
		return l.get(ans);
	}
	
    //---------- I/O Template ----------
    
    public static void main(String[] args) { new atharva().run(); }
    void run() { 
        is = System.in; 
        out = new PrintWriter(System.out);
        solve();
        out.flush();
    }
    
    byte input[] = new byte[1024];
    int len = 0, ptr = 0;
    
    int readByte() { 
        if(ptr >= len) { ptr = 0; 
            try { len = is.read(input); } 
            catch(IOException e) { throw new InputMismatchException(); } 
            if(len <= 0) { return -1; } 
        } return input[ptr++];
    }
    boolean isSpaceChar(int c) { return !( c >= 33 && c <= 126 ); }
    int skip() { 
        int b = readByte(); 
        while(b != -1 && isSpaceChar(b)) { b = readByte(); } 
        return b;
    }
    
    char nc() { return (char)skip(); }
    String ns() { 
        int b = skip(); 
        StringBuilder sb = new StringBuilder(); 
        while(!isSpaceChar(b)) { sb.appendCodePoint(b); b = readByte(); } 
        return sb.toString();
    }
    String nLine() { 
        int b = skip(); 
        StringBuilder sb = new StringBuilder(); 
        while( !(isSpaceChar(b) && b != ' ') ) { sb.appendCodePoint(b); b = readByte(); } 
        return sb.toString();
    }
    int ni() { 
        int n = 0, b = readByte(); 
        boolean minus = false; 
        while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')) { b = readByte(); } 
        if(b == '-') { minus = true; b = readByte(); } 
        if(b == -1) { return -1; }  //no input 
        while(b >= '0' && b <= '9') { n = n * 10 + (b - '0'); b = readByte(); } 
        return minus ? -n : n;
    }
    long nl() { 
        long n = 0L;    int b = readByte(); 
        boolean minus = false; 
        while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')) { b = readByte(); } 
        if(b == '-') { minus = true; b = readByte(); } 
        while(b >= '0' && b <= '9') { n = n * 10 + (b - '0'); b = readByte(); } 
        return minus ? -n : n;
    }

    double nd() { return Double.parseDouble(ns()); }
    float nf() { return Float.parseFloat(ns()); }
    int[] na(int n) { 
        int a[] = new int[n]; 
        for(int i = 0; i < n; i++) { a[i] = ni(); } 
        return a;
    }
    char[] ns(int n) { 
        char c[] = new char[n]; 
        int i, b = skip(); 
        for(i = 0; i < n; i++) { 
            if(isSpaceChar(b)) { break; } 
            c[i] = (char)b; b = readByte(); 
        } return i == n ? c : Arrays.copyOf(c,i);
    }
	
}