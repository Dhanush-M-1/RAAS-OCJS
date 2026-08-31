import java.util.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class Sample {
    public static void main(String[] args) throws Exception {
        FastScanner f = new FastScanner();
        int T = f.nextInt();
        while (T-- > 0) {
            // int N = f.nextInt();
            // int[] a = f.nextIntArray(N);
            int a = f.nextInt();
            int b = f.nextInt();
            int x = f.nextInt();
            System.out.println(x*min(a,b,x));


        }
    }
    static int min(int a, int b, int x)
    {   
        int q = b/x;
        int r = a/x;
        if (r>1)
        {
            return 1;
        } else if (r==1)
        {
            if(a==x)
                 return q+1;
            else return 1;
        } else {
            if (q>1)
                return q+1;
            else if (q==1)
                {
                    return 2; 
                }
            else return 1;
        }
    }

}
class FastScanner {
    public int BS = 1<<16;
    public char NC = (char)0;
    byte[] buf = new byte[BS];
    int bId = 0, size = 0;
    char c = NC;
    double num = 1;
    BufferedInputStream in;

    public FastScanner() {
        in = new BufferedInputStream(System.in, BS);
    }

    public FastScanner(String s) {
        try {
            in = new BufferedInputStream(new FileInputStream(new File(s)), BS);
        }
        catch (Exception e) {
            in = new BufferedInputStream(System.in, BS);
        }
    }

    public char nextChar(){
        while(bId==size) {
            try {
                size = in.read(buf);
            }catch(Exception e) {
                return NC;
            }
            if(size==-1)return NC;
            bId=0;
        }
        return (char)buf[bId++];
    }

    public int nextInt() {
        return (int)nextLong();
    }

    public long nextLong() {
        num=1;
        boolean neg = false;
        if(c==NC)c=nextChar();
        for(;(c<'0' || c>'9'); c = nextChar()) {
            if(c=='-')neg=true;
        }
        long res = 0;
        for(; c>='0' && c <='9'; c=nextChar()) {
            res = (res<<3)+(res<<1)+c-'0';
            num*=10;
        }
        return neg?-res:res;
    }

    public double nextDouble() {
        double cur = nextLong();
        return c!='.' ? cur:cur+nextLong()/num;
    }

    public String next() {
        StringBuilder res = new StringBuilder();
        while(c<=32)c=nextChar();
        while(c>32) {
            res.append(c);
            c=nextChar();
        }
        return res.toString();
    }

    public String nextLine() {
        StringBuilder res = new StringBuilder();
        while(c<=32)c=nextChar();
        while(c!='\n') {
            res.append(c);
            c=nextChar();
        }
        return res.toString();
    }

    public boolean hasNext() {
        if(c>32)return true;
        while(true) {
            c=nextChar();
            if(c==NC)return false;
            else if(c>32)return true;
        }
    }

    public int[] nextIntArray(int n) {
        int[] res = new int[n];
        for(int i = 0; i < n; i++) res[i] = nextInt();
        return res;
    }

    public char[] nextCharArray(int n) {
        char[] res = new char[n];
        for (int i = 0; i < n; i++) {
            res[i] = nextChar();
        }
        return res;
    }

}