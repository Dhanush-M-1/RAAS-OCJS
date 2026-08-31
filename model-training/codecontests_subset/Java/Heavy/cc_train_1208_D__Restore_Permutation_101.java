import java.io.*;
import java.io.IOException;
import java.util.*;
//import javafx.util.Pair; 
//import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.Icon;

//import sun.net.www.content.audio.wav;
 
import java.text.DecimalFormat;
 
public class Codeforces {
    
    public static long mod = (long)Math.pow(10, 9)+7 ;
    public static double epsilon=0.00000000008854;//value of epsilon
    public static InputReader sc = new InputReader(System.in);
    public static PrintWriter pw = new PrintWriter(System.out);
    
   
    public static int countSet(int a){
        int c=0;
        while(a>0){
            a&=(a-1);
            c++;
        }
        return c;
    }
    public static void Zfunction(String s){
        int n=s.length();
        int a[]=new int[n];
        int r1=0,r2=1;
        for(int i=1;i<n;){
            int f=0;
            while(r2<n&&s.charAt(r1)==s.charAt(r2)){
                r1++;
                r2++;
            }
            a[i]=r1;
            i++;
            int l2=1;
            for(;i<r2;i++){
                if(i+a[l2]<r2)
                a[i]=a[l2++];
                else{
                    f=1;
                    r1=r2-i;
                    break;
                }
            }
            if(f==0){
                r2=i;
                r1=0;
            }
 
        }
        pw.println(Arrays.toString(a));
    }
    
    
    
    public static ArrayList<ArrayList <Integer>> GetGraph(int n,int m){
        ArrayList<ArrayList <Integer>> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            a.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;
            a.get(u).add(v);
            a.get(v).add(u);
        } 
        return a;
    }

    public static int firstNode(int a,int p[]){
		if(a!=p[a]){
			p[a]=firstNode(p[a], p);
		}
		return p[a];
	}
	public static void Union(int a,int b,int p[]){
		//int a=firstNode(a1, p);
		//int b=firstNode(b1, p);
		/*if(a!=b){
			if(r[a]<r[b]){
				p[a]=b;
			}
			else if(r[a]>r[b]){
				p[b]=a;
			}
			else{
				r[b]++;
				p[a]=b;
			}
		}*/
		if(a!=b)
		p[firstNode(a,p)]=firstNode(b,p);//if no rank than 
	}
    
   
    
    public static void main(String[] args) {
        // code starts..
        int n=sc.nextInt();
        long a[]=scanLongArray(n);
        Bit h=new Bit(n);
        for(int i=1;i<=n;i++){
            h.update(i, i);
        }
        int ans[]=new int[n];
        for(int i=n;i>0;i--){
            int in=h.searchNumber(a[i-1]);
            ans[i-1]=in+1;
            h.update(in+1, -(in+1));
            //pw.println(h.query(1));
        }
        for(int i=0;i<n;i++)
        pw.print(ans[i]+" ");

        
            
        // Code ends...
        pw.flush();
        pw.close();
    }
    public static Comparator<Integer> C(){
        return 
        new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);//for descending
            }
        };
    }
    
    static class tripletL implements Comparable<tripletL> {
        Long x, y, z;
 
        tripletL(long x, long y, long z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
 
        public int compareTo(tripletL o) {
            int result = x.compareTo(o.x);
            if (result == 0)
                result = y.compareTo(o.y);
            if (result == 0)
                result = z.compareTo(o.z);
 
            return result;
        }
 
        public boolean equlas(Object o) {
            if (o instanceof tripletL) {
                tripletL p = (tripletL) o;
                return (x - p.x == 0) && (y - p.y ==0 ) && (z - p.z == 0);
            }
            return false;
        }
 
        public String toString() {
            return x + " " + y + " " + z;
        }
 
        public int hashCode() {
            return new Long(x).hashCode() * 31 + new Long(y).hashCode() + new Long(z).hashCode();
        }
    }
    public static String Doubleformate(double a,int n){
        String s="";
        while(n-->0){
            s+='0';
        }
        DecimalFormat f =new DecimalFormat("#0."+s);
        return f.format(a);
    }
 
    public static Comparator<Integer[]> column(int i){
        return 
        new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[i].compareTo(o2[i]);//for ascending
                //return o2[i].compareTo(o1[i]);//for descending
            }
        };
    }
    public static Comparator<Long[]> column1(int i){
        return 
        new Comparator<Long[]>() {
            @Override
            public int compare(Long[] o1, Long[] o2) {
                return o1[i].compareTo(o2[i]);//for ascending
                //return o2[i].compareTo(o1[i]);//for descending
            }
        };
    }
    public static Comparator<Integer[]> pair(){
        return 
        new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                int result=o1[0].compareTo(o2[0]);
                if(result==0)
                result=o1[1].compareTo(o2[1]);
                return result;
            }
        };
    }
    public static Comparator<Integer[]> Triplet(){
        return 
        new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
            
                    for(int i=0;i<3;i++){
                        for(int j=i+1;j<3;j++){
                            for(int k=0;k<3;k++){
                                for(int p=k+1;p<3;p++){
                                    if((o1[i]==o2[k]&&o1[j]==o2[p])||(o1[j]==o2[k]&&o1[i]==o2[p])){
 
                                    }
                                }
                            }
                        }
                    }
                    int result=o1[0].compareTo(o2[0]);
                    if(result==0)
                    result=o1[1].compareTo(o2[1]);
                    if(result==0)
                    result=o1[2].compareTo(o2[2]);
                    return result;
            }
        };
    }
    
    
    public static String reverseString(String s){
        StringBuilder input1 = new StringBuilder(); 
        input1.append(s);  
        input1 = input1.reverse();
        return input1.toString();
    }
    public static int[] scanArray(int n){
        int a[]=new int [n];
        for(int i=0;i<n;i++)
        a[i]=sc.nextInt();
 
        return a;
    }
    public static long[] scanLongArray(int n){
        long a[]=new long [n];
        for(int i=0;i<n;i++)
        a[i]=sc.nextLong();
 
        return a;
    }
    public static String [] scanStrings(int n){
        String a[]=new String [n];
        for(int i=0;i<n;i++)
        a[i]=sc.nextLine();
 
        return a;
    }
     
}
class InputReader {
 
        private final InputStream stream;
        private final byte[] buf = new byte[8192];
        private int curChar, snumChars;
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
            while (isSpaceChar(c)) {
                c = snext();
            }
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
            while (isSpaceChar(c)) {
                c = snext();
            }
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
 
        public int[] nextIntArray(int n) {
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }
 
        public String readString() {
            int c = snext();
            while (isSpaceChar(c)) {
                c = snext();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isSpaceChar(c));
            return res.toString();
        }
 
        public String nextLine() {
            int c = snext();
            while (isSpaceChar(c))
                c = snext();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = snext();
            } while (!isEndOfLine(c));
            return res.toString();
        }
 
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
 
        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
 
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }

    class Bit{//1...n
        long a[];int n;
        Bit(int n){
            this.n=n;
            a=new long[n+1];
        }
        void update(int i,int delta){
            while(i<a.length){
                a[i]+=delta;
                i+=i&(-i);
            }
        }
        long query(int i){
            long sum=0;
            while(i>0){
                sum+=a[i];
                i-=i&(-i);
            }
            return sum;
        }
        int searchNumber(long sum){
            int l=1,r=n,ans=0;
            while(l<=r){
                int m=(l+r)/2;
                long v=query(m);
                if(v>sum){
                    r=m-1;
                }
                else if(v<sum){
                    l=m+1;
                }
                else{
                    ans=m;
                    l=m+1;
                }
            }
            return ans;
        }
        
    }