import java.io.*;
import java.util.*;
import java.math.*;

public class utkarsh {

    InputStream is;
    PrintWriter out;
    
    long a[], d[];
    int n, k;
    long pp, maxl = (long)4e18;
    
    boolean play(long x){
        int i, j;
        long s;
        j = 0;
        for(i = 0; i < n; ){
            if(j == k)  return false;
            s = Math.abs(a[i] - d[j]) + Math.abs(d[j] - pp);
            if(s <= x)  i++;
            j++;
        }
        return true;
    }
    
    void solve(){
        //Enter code here utkarsh
        int i;
        n = ni();
        k = ni();
        pp = nl();
        a = new long[n];
        for(i = 0; i < n; i++) a[i] = nl();
        d = new long[k];
        for(i = 0; i < k; i++) d[i] = nl();
        Arrays.sort(a);
        Arrays.sort(d);
        long l, r, m;
        l = 0;  r = maxl;
        while(l <= r){
            m = (l + r) / 2;
            if(!play(m)){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        out.println(l);
    }
    
    long modpow(long base, long exp, long modulus) { base %= modulus; long result = 1L; while (exp > 0) { if ((exp & 1)==1) result = (result * base) % modulus; base = (base * base) % modulus; exp >>= 1; } return result;
    }
    
    public static void main(String[] args) { new utkarsh().run();
    }
    void run(){ is = System.in; out = new PrintWriter(System.out); solve(); out.flush();
    }
    
    byte input[] = new byte[1024];
    int len = 0, ptr = 0;
    
    int readByte(){ if(ptr >= len){ ptr = 0; try{ len = is.read(input); }catch(IOException e){ throw new InputMismatchException(); } if(len <= 0){ return -1; } } return input[ptr++];
    }
    boolean isSpaceChar(int c){ return !( c >= 33 && c <= 126 ); 
    }
    int skip(){ int b = readByte(); while(b != -1 && isSpaceChar(b)){ b = readByte(); } return b;
    }
    
    char nc(){ return (char)skip();
    }
    String ns(){ int b = skip(); StringBuilder sb = new StringBuilder(); while(!isSpaceChar(b)){ sb.appendCodePoint(b); b=readByte(); } return sb.toString();
    }
    int ni(){ int n = 0,b = readByte(); boolean minus = false; while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')){ b = readByte(); } if(b == '-'){ minus = true; b = readByte(); } if(b == -1){ return -1; } while(b >= '0' && b <= '9'){ n = n * 10 + (b - '0'); b = readByte(); } return minus ? -n : n;
    }
    long nl(){ long n = 0L; int b = readByte(); boolean minus = false; while(b != -1 && !( (b >= '0' && b <= '9') || b == '-')){ b = readByte(); } if(b == '-'){ minus = true; b = readByte(); } while(b >= '0' && b <= '9'){ n = n * 10 + (b - '0'); b = readByte(); } return minus ? -n : n;
    }
    double nd(){ return Double.parseDouble(ns());
    }
    float nf(){ return Float.parseFloat(ns());
    }
    int[] na(int n){ int a[] = new int[n]; for(int i = 0; i < n; i++){ a[i] = ni(); } return a;
    }
    char[] ns(int n){ char c[] = new char[n]; int i,b = skip(); for(i = 0; i < n; i++){ if(isSpaceChar(b)){ break; } c[i] = (char)b; b = readByte(); } return i == n ? c : Arrays.copyOf(c,i);
    }
}