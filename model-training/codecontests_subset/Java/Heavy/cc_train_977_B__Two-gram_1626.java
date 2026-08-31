import java.util.*;
import java.io.*;

public class C915 {
	@SuppressWarnings("unused")
	
	public static void main(String args[])  throws Exception{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
	    //InputReader sc = new InputReader(System.in);
	    //OutputStream out = new BufferedOutputStream ( System.out );
	    HashMap<String,Integer> map1 = new HashMap<String,Integer>();
	    //HashMap<Integer,Integer> map2 = new HashMap<Integer,Integer>();
	    
	    int n = sc.nextInt();
	    //int m = sc.nextInt();
	    sc.nextLine();
	    String s = sc.nextLine();
	    
	    int l = s.length();
	    
	    for(int i=0;i<l-1;i++){
	        String str = s.substring(i,i+2);
	        if(map1.containsKey(str))
	            map1.put(str , map1.get(str) + 1);
	        else
	            map1.put(str , 1);
	    }
	    
	    String pri = "";
	    int ans = 0;
	    
	    for(Map.Entry<String , Integer> en : map1.entrySet()){
	        String key = en.getKey();
	        int max = en.getValue();
	        
	        if(max > ans){
	            ans = max;
	            pri = key;
	        }
	    }
	    
	    //if(flag == 0)
	        System.out.println(pri);
	    //else
	        //System.out.println("Yes");
	    
	}
	
	public static boolean isPali(String s){
	    int len = s.length();
	    for(int i=0;i<=len/2;i++){
	        if(s.charAt(i) != s.charAt(len - 1 - i) )
	            return true;
	    }
	    return false;
	}
}

class node{
    int s,c;
    
    public node(int a,int b){
        s = a;
        c = b;
    }
}
 class InputReader {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
    private SpaceCharFilter filter;
 
    public InputReader(InputStream stream) {
        this.stream = stream;
    }
 
    public static boolean isWhitespace(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    public int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    public int nextInt() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        int sgn = 1;
        if (c == '-') {
            sgn = -1;
            c = read();
        }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res *= 10;
            res += c - '0';
            c = read();
        } while (!isSpaceChar(c));
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
        } while (!isSpaceChar(c));
        return res * sgn;
    }
 
    public String nextToken() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    public boolean isSpaceChar(int c) {
        if (filter != null)
            return filter.isSpaceChar(c);
        return isWhitespace(c);
    }
 
    public interface SpaceCharFilter {
        public boolean isSpaceChar(int ch);
    }
}

/*
4
82 94 6
56 67 4
28 59 9
39 74 4

2 4
*.*.
1211
*/