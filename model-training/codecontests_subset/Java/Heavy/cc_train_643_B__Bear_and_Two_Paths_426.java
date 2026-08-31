/**
 *
 * @author sarthak
 */

import java.util.*;
import java.math.*;
import java.io.*;



public class rnd351_D {

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(InputStream is) {
            br = new BufferedReader(new InputStreamReader(is));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public String nextLine() {
            st = null;
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
static class P implements Comparable{

        private int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int hashCode() {
            return (x * 31) ^ y;
        }

        public boolean equals(Object o) {
            if (o instanceof P) {
                P other = (P) o;
                return (x == other.x && y == other.y);
            }
            return false;
        }
        public int compareTo(Object obj) {
		P l = (P) obj;
		if (this.x == l.x){
			if (this.y == l.y) return 0;
			return (this.y < l.y)? -1: 1;
		}
		return (this.x < l.x)? -1: 1;
	}
    }

    public static void main(String[] args){
         
    FastScanner s = new FastScanner(System.in);
    StringBuilder op1=new StringBuilder();
    StringBuilder op2=new StringBuilder();
    
    int n=s.nextInt();
    int k=s.nextInt();
    int er=6+n-4-1;
    if(n<=4 || k<er){
        System.out.println(-1);
        return;
    }
    int a=s.nextInt();
    int b=s.nextInt();
    int c=s.nextInt();
    int d=s.nextInt();
    op1.append(a+" "+ d+" ");
    ArrayList<Integer> al=new ArrayList<>();
    for(int i=1;i<=n;i++){
        if(i!=a&&i!=b&&i!=c&&i!=d)
            al.add(i);
                   
    }
    for(int i:al)
        op1.append(i+" ");
    op1.append(c+" " + b);
    
    op2.append(c+" "+ b+" ");
    for(int i=al.size()-1;i>=0;i--)
        op2.append(al.get(i)+" ");
    op2.append(a+" " + d);
    System.out.println(op1);
    System.out.println(op2);
    
    
    
    
    
    
    
    
    
    
    
    }


}
