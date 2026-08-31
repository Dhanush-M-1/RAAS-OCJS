
import java.util.*;
import java.math.*;
import static java.lang.Character.isDigit;
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import static java.lang.Character.isDigit;

public class Main{
    static void debug(Object...os){
        System.err.println(deepToString(os));
    }
    
    void run(){
        P A=new P(nextInt(),nextInt());
        P B=new P(nextInt(),nextInt());
        P C=new P(nextInt(),nextInt());
        boolean ok=false;
        for(int i=0;i<4;i++) {
            B = B.rot90();
            if(calc(A,B,C))ok=true;
        }
        System.out.println(ok?"YES":"NO");
    }
    private boolean calc(P A,P B,P C){
        if(C.dot(C)==0) {
            return A.equals(B);
        }
        long num = B.dot(C)-A.dot(C);
        long den = C.dot(C);
        if(num%den!=0)return false;
        C=C.rot90();
        num =B.dot(C)-A.dot(C);
        den = C.dot(C);
        if(num%den!=0)return false;
        return true;
    }
    class P{
        long x,y;

        public P(long x,long y){
            super();
            this.x=x;
            this.y=y;
        }

        public long dot(P p){
            return x*p.x + y*p.y;
        }

        public P rot90(){
            return new P(-y,x);
        }
        
        public boolean equals(Object obj){
            P p=(P)obj;
            return x==p.x && y==p.y;
        }
    }
    
    int nextInt(){
        try{
            int c=System.in.read();
            if(c==-1) return c;
            while(c!='-'&&(c<'0'||'9'<c)){
                c=System.in.read();
                if(c==-1) return c;
            }
            if(c=='-') return -nextInt();
            int res=0;
            do{
                res*=10;
                res+=c-'0';
                c=System.in.read();
            }while('0'<=c&&c<='9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }
    
    long nextLong(){
        try{
            int c=System.in.read();
            if(c==-1) return -1;
            while(c!='-'&&(c<'0'||'9'<c)){
                c=System.in.read();
                if(c==-1) return -1;
            }
            if(c=='-') return -nextLong();
            long res=0;
            do{
                res*=10;
                res+=c-'0';
                c=System.in.read();
            }while('0'<=c&&c<='9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }
    
    double nextDouble(){
        return Double.parseDouble(next());
    }
    
    String next(){
        try{
            StringBuilder res=new StringBuilder("");
            int c=System.in.read();
            while(Character.isWhitespace(c))
                c=System.in.read();
            do{
                res.append((char)c);
            }while(!Character.isWhitespace(c=System.in.read()));
            return res.toString();
        }catch(Exception e){
            return null;
        }
    }
    
    String nextLine(){
        try{
            StringBuilder res=new StringBuilder("");
            int c=System.in.read();
            while(c=='\r'||c=='\n')
                c=System.in.read();
            do{
                res.append((char)c);
                c=System.in.read();
            }while(c!='\r'&&c!='\n');
            return res.toString();
        }catch(Exception e){
            return null;
        }
    }
    public static void main(String[] args){
        new Main().run();
    }
}
