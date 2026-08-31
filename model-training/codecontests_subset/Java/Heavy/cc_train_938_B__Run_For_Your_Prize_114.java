
import java.io.*;
import java.util.*;
import java.lang.*;
import static java.lang.Math.*;


// Sachin_2961 submission //
public class CodeforcesA {
    public void solve() {
        int n = fs.nInt();
        int a = 1, b = (int)1e6,ans = 0;
        for(int i=0;i<n;i++){
            int pos = fs.nInt();
            int min = min(pos-a,b-pos);
            ans = max(ans,min);
        }
        out.println(ans);
    }
    static boolean multipleTestCase = false; static FastScanner fs; static PrintWriter out;
    public void run(){
        fs = new FastScanner();
        out = new PrintWriter(System.out);
        int tc = (multipleTestCase)?fs.nInt():1;
        while (tc-->0)solve();
        out.flush();
        out.close();
    }
    public static void main(String[]args){
        try{
            new CodeforcesA().run();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String n() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
        String Line()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
        int nInt() {return Integer.parseInt(n()); }
        long nLong() {return Long.parseLong(n());}
        int[]aI(int n){
            int[]ar = new int[n];
            for(int i=0;i<n;i++)
                ar[i] = nInt();
            return ar;
        }
    }
    public static void sort(int[] arr){
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for(int x: arr)
            ls.add(x);
        Collections.sort(ls);
        for(int i=0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }
}