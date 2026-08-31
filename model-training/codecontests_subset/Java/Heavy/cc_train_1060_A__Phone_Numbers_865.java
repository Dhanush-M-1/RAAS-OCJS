import java.io.*;
import java.util.*;
import java.math.*;

public class Solution {
    /*
      InputReader class taken from https://gist.github.com/o-panda-o/32ce63499c05192827294eb529cc4fd0
      Which is publically available
    */
	static class InputReader {
    private boolean finished = false;

    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;

    public InputReader(InputStream stream) {
        this.stream = stream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar++];
    }

    public int peek() {
        if (numChars == -1) {
            return -1;
        }
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                return -1;
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buf[curChar];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        long res = 0;
        do {
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
        return res * sgn;
    }

    public String nextString() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder res = new StringBuilder();
        do {
            if (Character.isValidCodePoint(c)) {
                res.appendCodePoint(c);
            }
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }

    public boolean isSpaceChar(int c) {
        if (filter != null) {
            return filter.isSpaceChar(c);
        }
        return isWhitespace(c);
    }

    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private String readLine0() {
        StringBuilder buf = new StringBuilder();
        int c = read();
        while (c != '\n' && c != -1) {
            if (c != '\r') {
                buf.appendCodePoint(c);
            }
            c = read();
        }
        return buf.toString();
    }

    public String readLine() {
        String s = readLine0();
        while (s.trim().length() == 0) {
            s = readLine0();
        }
        return s;
    }

    public String readLine(boolean ignoreEmptyLines) {
        if (ignoreEmptyLines) {
            return readLine();
        } else {
            return readLine0();
        }
    }

    public BigInteger readBigInteger() {
        try {
            return new BigInteger(nextString());
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public char nextCharacter() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        return (char) c;
    }

    public double nextDouble() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        double res = 0;
        while (!isSpaceChar(c) && c != '.') {
            if (c == 'e' || c == 'E') {
                return res * Math.pow(10, nextInt());
            }
            if (c < '0' || c > '9') {
                throw new InputMismatchException();
            }
            res *= 10;
            res += c - '0';
            c = read();
        }
        if (c == '.') {
            c = read();
            double m = 1;
            while (!isSpaceChar(c)) {
                if (c == 'e' || c == 'E') {
                    return res * Math.pow(10, nextInt());
                }
                if (c < '0' || c > '9') {
                    throw new InputMismatchException();
                }
                m /= 10;
                res += (c - '0') * m;
                c = read();
            }
        }
        return res * sgn;
    }

    public boolean isExhausted() {
        int value;
        while (isSpaceChar(value = peek()) && value != -1) {
            read();
        }
        return value == -1;
    }

    public String next() {
        return nextString();
    }

    public SpaceCharFilter getFilter() {
        return filter;
    }

    public void setFilter(SpaceCharFilter filter) {
        this.filter = filter;
    }

    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
    public int[] nextIntArray(int n){
        int[] array=new int[n];
        for(int i=0;i<n;++i)array[i]=nextInt();
        return array;
    }
    public int[] nextSortedIntArray(int n){
        int array[]=nextIntArray(n);
        Arrays.sort(array);
        return array;
    }
    public int[] nextSumIntArray(int n){
        int[] array=new int[n];
        array[0]=nextInt();
        for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
        return array;
    }
    public long[] nextLongArray(int n){
        long[] array=new long[n];
        for(int i=0;i<n;++i)array[i]=nextLong();
        return array;
    }
    public long[] nextSumLongArray(int n){
        long[] array=new long[n];
        array[0]=nextInt();
        for(int i=1;i<n;++i)array[i]=array[i-1]+nextInt();
        return array;
    }
    public long[] nextSortedLongArray(int n){
        long array[]=nextLongArray(n);
        Arrays.sort(array);
        return array;
    }
}
     static boolean[] prime;
    static void sieve(int n) 
    { 
        prime= new boolean[n+2]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 
        prime[0]=prime[1]=false;
        for(int p = 2; p*p <=n; p++) 
        { 
            if(prime[p] == true) 
            { 
                for(int i = p*2; i <= n; i += p) 
                    prime[i] = false; 
            } 
        }
    }
    static int[] find(List<pair> l, long p){
        int s=0,e=l.size()-1;
        int mid=0;
        int ans=-1;
        while(s<=e){
            mid=s+(e-s)/2;
            if(l.get(mid).a==p){
                return new int[]{mid,1};
            }
            if(l.get(mid).a<p){
                s=mid+1;
            }
            else 
                e= mid-1;
        }
        return new int[]{e,0};
    }
    public static void main(String[] args){
    	InputReader sc=new InputReader(System.in);
    	PrintWriter out=new PrintWriter(new BufferedOutputStream(System.out), true);
    	int n=sc.nextInt();
    	String s=sc.readLine();
    	if(!s.contains("8") || s.length()<11){
    	    out.println("0");
    	    return;
    	}
    	List<Character> c=new ArrayList<>();
    	for(int i=0;i<n;i++) c.add(s.charAt(i));
    	Collections.sort(c);
    	int start=c.indexOf('8');
    	int end=c.lastIndexOf('8');
    	int m=end-start+1;
    	out.println(Math.min(n/11,m));
    }
    static boolean KpartitionsPossible(int arr[], int n, int K){
    int prefix_sum[]=new int[n];
    prefix_sum[0] = arr[0];
    for (int i = 1; i < n; i++)
        prefix_sum[i] =  prefix_sum[i - 1] + arr[i];
    int total_sum = prefix_sum[n-1];
    if (total_sum % K != 0)
        return false;
    int temp = 0;
    int pos = -1;
    for (int i = 0; i < n; i++) 
    {   
        if (prefix_sum[i] - (pos == -1 ? 0 :prefix_sum[pos]) == total_sum / K) 
        {
            pos = i;
            temp++;
        }
        else if (prefix_sum[i] - (pos == -1 ? 0 :prefix_sum[pos]) > total_sum / K )
            break;
    }
    return (temp == K);
}
    /**  a*x+b*y=gcd(a,b) **/
    static long[] extendedEuclid(long a, long b){
        if(a%b==1) return new long[]{1,-a/b};
        long[] vals = extendedEuclid(b, a % b);
        long a1 = vals[1];
        long b1 = vals[0] - (a / b) * vals[1];
        return new long[]{a1,b1};
    }
    static long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b,a%b);
    }
    static class UnionFind {
	private static int[] parent;
    private static int[] size;
    public UnionFind(int n){
    	parent=new int[n];
    	size=new int[n];
    	for (int i=0;i<n ;i++ ) {
    		parent[i]=i;
    		size[i]=1;
    	}
    }
    public static int Root(int p){
        int i=p;
        while (i!=parent[i]) {
        	i=parent[i];
            parent[i]=parent[parent[i]];
        	
        }
        while (p!=i) {
            int l=parent[p];
            parent[p]=i;
            p=l;
        }
        return i;
    }
    public static void Union(int p,int q){
    	int i=Root(p);
    	int j=Root(q);
    	if(i==j) return ;
    	if (size[i]>size[j]) {
    		size[i]+=size[j];
    		parent[j]=i;
    	}
    	else {
    		size[j]+=size[i];
    		parent[i]=j;
    	}
    }
    public static boolean isConnected(int p,int q){
    	return Root(p)==Root(q);
    }
    }
    static class pair implements Comparable<pair>{
        int a;int b;
        public pair(int i,int j){
            a=i;
            b=j;
        }
        public int compareTo(pair p){
            return (int)(a-p.a);
        }
    }
}