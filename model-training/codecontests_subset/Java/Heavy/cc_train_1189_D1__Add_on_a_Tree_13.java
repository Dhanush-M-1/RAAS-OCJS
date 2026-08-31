//https://codeforces.com/contest/1189/problem/D1

// package Codeforces;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

public class cf_572_2_d1 {

    public static void main(String[] args) throws Exception {
        FastScanner f = new FastScanner();
//        int T = f.nextInt();
//        while (T-- > 0) {
//            int n = f.nextInt();
//            int[] a = f.nextIntArray(n);
//
//        }
        int n = f.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n + 1; i++) {
            a[i]=0;
        }
        for (int i = 0; i < n - 1; i++) {
            a[f.nextInt()]++;
            a[f.nextInt()]++;
        }

        boolean flag = true;

        for (int i = 1; i < n+1; i++) {
            if (a[i]==2)
            {
                flag= false;
                break;
            }
        }

        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");


        /*
        ArrayList<Integer>[] a = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            a[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n-1; i++) {
            int u = f.nextInt();
            int v = f.nextInt();
            a[u].add(v);
            a[v].add(u);
        }
        boolean flag = true;

        if (n==2)
            System.out.println("YES");
        else if (n==3)
            System.out.println("NO");
        else
        {
            for (int i = 1; i < n+1; i++) {
                if (a[i].size()==1)
                {
                    int parent = a[i].get(0);
                    if (a[parent].size()==2)
                    {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag)
                System.out.println("YES");
            else
                System.out.println("NO");

        }*/


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
