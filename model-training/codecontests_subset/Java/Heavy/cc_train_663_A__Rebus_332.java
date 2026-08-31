

import java.io.*;
import java.lang.*;
import java.util.*;

public class CodeforcesA {

    // Sachin_2961 submission //

    public  void solve() {
        FastScanner fs = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int[]ar = new int[101];
        int[]br = new int[101];
        String s = fs.nextLine().replace(" ","");
        String[]sep = s.split("=");
        char[]str = sep[0].toCharArray();
        int n = Integer.parseInt(sep[1]);
        int pos = 1,neg = 0,c=0,p=1;
        for(int i=0;i<str.length;i++){
            if( str[i] == '?' ){
                ar[++c] = 1;
                br[c] = p;
            }else if( str[i]=='+'){
                pos++;p=1;
            }else if( str[i] == '-'){
                neg++;p=-1;
            }
        }

        if( pos - n*neg > n || pos*n - neg < n  ){
            out.println("Impossible");
        }else{
            out.println("Possible");
            long extra = 0;
            if( pos > n+neg )extra = pos - n - neg;
            else extra = n + neg - pos;

            for(int i=1;i<=c;i++){
                if( (pos > n + neg && br[i] < 0) || (pos < n + neg && br[i] > 0 ) ){
                    while (extra > 0 && ar[i] < n ){
                        extra--;ar[i]++;
                    }
                }
            }
            c = 0;
            for(int i=0;i<str.length;i++){
                if( str[i] == '?' )
                    out.print(ar[++c]+" ");
                else
                    out.print(str[i]+" ");
            }
            out.print("= "+n);
        }

        out.flush();
    }

    public static void main(String[]args){
        try{
            new CodeforcesA().solve();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}