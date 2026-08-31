import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: piyushd
 * Date: 3/26/11
 * Time: 10:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaskA {

    void run() {
        int a = nextInt(), b = nextInt(), c = nextInt();

        if (a <= b) {
            System.out.println("0");
            return;
        }

        boolean got = false;
        int ans = -1;
        for (int t = 0; t <= 1234567 && !got; t++) {
            if (b * (c + t) >= a * c) {
                got = true;
                ans = t;
            }
        }

        System.out.println(ans);
    }

    int nextInt(){
        try{
            int c = System.in.read();
            if(c == -1) return c;
            while(c != '-' && (c < '0' || '9' < c)){
                c = System.in.read();
                if(c == -1) return c;
            }
            if(c == '-') return -nextInt();
            int res = 0;
            do{
                res *= 10;
                res += c - '0';
                c = System.in.read();
            }while('0' <= c && c <= '9');
            return res;
        }catch(Exception e){
            return -1;
        }
    }

    long nextLong(){
        try{
            int c = System.in.read();
            if(c == -1) return -1;
            while(c != '-' && (c < '0' || '9' < c)){
                c = System.in.read();
                if(c == -1) return -1;
            }
            if(c == '-') return -nextLong();
            long res = 0;
            do{
                res *= 10;
                res += c-'0';
                c = System.in.read();
            }while('0' <= c && c <= '9');
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
            StringBuilder res = new StringBuilder("");
            int c = System.in.read();
            while(Character.isWhitespace(c))
                c = System.in.read();
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
            StringBuilder res = new StringBuilder("");
            int c = System.in.read();
            while(c == '\r' || c == '\n')
                c = System.in.read();
            do{
                res.append((char)c);
                c = System.in.read();
            }while(c != '\r' && c != '\n');
            return res.toString();
        }catch(Exception e){
            return null;
        }
    }

    public static void main(String[] args){
        new TaskA().run();
    }
}
