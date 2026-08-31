
import java.util.*;
import java.io.*;

public class Main{
    static final Reader sc = new Reader();
    static final PrintWriter out = new PrintWriter(System.out,false);

    public static void main(String[] args) throws Exception {
    	int n = sc.nextInt();
    	for(int i=0;i<n;i++){
    		String ord = sc.next();
    		String mes = sc.next();
    		for(int j=ord.length()-1;j>=0;j--){
    			if(ord.charAt(j)=='J'){
    				mes = mes.substring(mes.length()-1,mes.length()).concat(mes.substring(0,mes.length()-1));
    			}
    			else if(ord.charAt(j)=='C'){
					mes = mes.substring(1,mes.length()).concat(mes.substring(0,1));    				
    			}
    			else if(ord.charAt(j)=='E'){
    				int x = mes.length()/2;
    				if(mes.length()%2==0){
    					mes = mes.substring(x,mes.length()).concat(mes.substring(0,x));
    				}
    				else{
    					mes = mes.substring(x+1,mes.length()).concat(mes.substring(x,x+1)).concat(mes.substring(0,x));
    				}
    			}
    			else if(ord.charAt(j)=='A'){
    				mes = new StringBuffer().append(mes).reverse().toString();
    			}
    			else if(ord.charAt(j)=='P'){
    				for(int k=0;k<mes.length();k++){
    					if(mes.charAt(k)=='0'){
    						mes = mes.substring(0,k).concat("9").concat(mes.substring(k+1,mes.length()));
    					}
    					else if('1'<=mes.charAt(k) && mes.charAt(k)<='9'){
    						mes = mes.substring(0,k).concat(String.valueOf((int)mes.charAt(k)-(int)'1')).concat(mes.substring(k+1,mes.length()));
    					}
    				}
    			}
    			else if(ord.charAt(j)=='M'){
    				for(int k=0;k<mes.length();k++){
    					if(mes.charAt(k)=='9'){
    						mes = mes.substring(0,k).concat("0").concat(mes.substring(k+1,mes.length()));
    					}
    					else if('0'<=mes.charAt(k) && mes.charAt(k)<='8'){
    						mes = mes.substring(0,k).concat(String.valueOf((int)mes.charAt(k)-(int)'0'+1)).concat(mes.substring(k+1,mes.length()));
    					}
    					//out.println(mes);
    					out.flush();
    				}
       			}
    		}
    		out.println(mes);
    		out.flush();
    	}
        sc.close();
        out.close();
    }

    static void trace(Object... o) { System.out.println(Arrays.deepToString(o));}
}

class Reader {

    private final InputStream in;
    private final byte[] buf = new byte[1024];
    private int ptr = 0;
    private int buflen = 0;

    public Reader() { this(System.in);}
    public Reader(InputStream source) { this.in = source;}

    private boolean hasNextByte() {
        if (ptr < buflen) return true;
        ptr = 0;
        try{
            buflen = in.read(buf);
        }catch (IOException e) {e.printStackTrace();}
        if (buflen <= 0) return false;
        return true;
    }

    private int readByte() { if (hasNextByte()) return buf[ptr++]; else return -1;}

    private boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}

    private void skip() { while(hasNextByte() && !isPrintableChar(buf[ptr])) ptr++;}

    public boolean hasNext() {skip(); return hasNextByte();}

    public String next() {
        if (!hasNext()) throw new NoSuchElementException();
        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while (isPrintableChar(b)) {
            sb.appendCodePoint(b);
            b = readByte();
        }
        return sb.toString();
    }

    public long nextLong() {
        if (!hasNext()) throw new NoSuchElementException();
        boolean minus = false;
        long num = readByte();

        if(num == '-'){
            num = 0;
            minus = true;
        }else if (num < '0' || '9' < num){
            throw new NumberFormatException();
        }else{
            num -= '0';
        }

        while(true){
            int b = readByte();
            if('0' <= b && b <= '9')
                num = num * 10 + (b - '0');
            else if(b == -1 || !isPrintableChar(b))
                return minus ? -num : num;
            else
                throw new NoSuchElementException();
        }
    }

    public int nextInt() {
        long num = nextLong();
        if (num < Integer.MIN_VALUE || Integer.MAX_VALUE < num)
            throw new NumberFormatException();
        return (int)num;
    }

    public double nextDouble() {
        return Double.parseDouble(next());
    }

    public char nextChar() {
        if (!hasNext()) throw new NoSuchElementException();
        return (char)readByte();
    }

    public String nextLine() {
        while (hasNextByte() && (buf[ptr] == '\n' || buf[ptr] == '\r')) ptr++;
        if (!hasNextByte()) throw new NoSuchElementException();

        StringBuilder sb = new StringBuilder();
        int b = readByte();
        while (b != '\n' && b != '\r') {
            sb.appendCodePoint(b);
            b = readByte();
        }

        return sb.toString();
    }

    public int[] nextIntArray(int n) {
        int[] res = new int[n];
        for (int i=0; i<n; i++) res[i] = nextInt();
        return res;
    }

    public char[] nextCharArray(int n) {
        char[] res = new char[n];
        for (int i=0; i<n; i++) res[i] = nextChar();
        return res;
    }

    public void close() {try{ in.close();}catch(IOException e){ e.printStackTrace();}};
}