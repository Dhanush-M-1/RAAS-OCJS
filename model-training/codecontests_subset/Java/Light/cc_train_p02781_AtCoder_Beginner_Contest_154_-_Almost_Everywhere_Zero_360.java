import java.io.*;
import java.util.*;
import static java.lang.System.out;

public class Main{
    static MyReader in = new MyReader();

    public static void main(String[] args){
        String N = in.s();
        int K = in.i();
        int ans = solve(N, K, N.length());
        out.println(ans);
    }

    static int solve(String s, int k, int d){
        if(d < k){
            return 0;
        } else {
            if(k == 0){
                return 1;
            } else {
                int i = s.charAt(0)-'0';
                int ret = 0;
                if(i == 0){
                    ret += solve(s.substring(1, d), k, d-1);
                } else {
                    ret += c(d-1, k)*pow(9, k);
                    ret += solve(s.substring(1, d), k-1, d-1);
                    if(i > 1){
                        ret += (i-1)*c(d-1, k-1)*pow(9, k-1);
                    }
                }
                return ret;
            }
        }
    }

    static int c(int n, int r){
        if(r == 0){
            return 1;
        } else if(r == 1){
            return n;
        } else if(r == 2){
            return n*(n-1)/2;
        } else {
            return n*(n-1)*(n-2)/6;
        }
    }

    static int pow(int n, int k){
        return k == 0 ? 1 : k == 1 ? n : k == 2 ? n*n : n*n*n;
    }

    static class MyReader extends BufferedReader{
        MyReader(){
            super(new InputStreamReader(System.in));
        }

        String s(){
            try{return readLine();}catch(IOException e){return "";}
        }

        String[] ss(){
            return s().split(" ");
        }

        int i(){
            return Integer.parseInt(s());
        }

        int[] ii(){
            String[] ss = ss();
            int[] ii = new int[ss.length];
            for(int j = 0; j < ss.length; j++) ii[j] = Integer.parseInt(ss[j]);
            return ii;
        }

        ArrayList<Integer> li(){
            String[] ss = ss();
            ArrayList<Integer> li = new ArrayList<>();
            for(int j = 0; j < ss.length; j++) li.add(Integer.parseInt(ss[j]));
            return li;
        }

        long l(){
            return Long.parseLong(s());
        }

        long[] ll(){
            String[] ss = ss();
            long[] ll = new long[ss.length];
            for(int j = 0; j < ss.length; j++) ll[j] = Long.parseLong(ss[j]);
            return ll;
        }
    }
}
