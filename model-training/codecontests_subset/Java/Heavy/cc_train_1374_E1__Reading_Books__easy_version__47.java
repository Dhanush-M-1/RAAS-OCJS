import java.io.*;
import java.util.*;
import java.awt.*;
public class E1
{
    BufferedReader in;
    PrintWriter ob;
    StringTokenizer st;
  
    public static void main(String[] args) throws IOException {
        new E1().run();
    }
    void run() throws IOException {
        in=new BufferedReader(new InputStreamReader(System.in));
        ob=new PrintWriter(System.out);
        solve();
        ob.flush();
    }
    void solve() throws IOException {
        int n = ni() , k = ni();
        int a[][] = new int[n][3];
        
        ArrayList<Integer> both = new ArrayList<>();
        ArrayList<Integer> cntA = new ArrayList<>();
        ArrayList<Integer> cntB = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
            a[i][0] = ni();
            a[i][1] = ni();
            a[i][2] = ni();

            if( a[i][1] == 1 && a[i][2] == 1 )
                both.add(a[i][0]);
            else if( a[i][1] == 1 )
                cntA.add(a[i][0]);
            else if( a[i][2] == 1 )
                cntB.add(a[i][0]);
        }

        if( isNotValid( a , k ) ) {
            ob.println("-1");
            return;
        }

        Collections.sort(both);
        Collections.sort(cntA);
        Collections.sort(cntB);

        int[] cboth = new int[both.size()+1];
        for (int i = 0 ; i<both.size() ; i++ ) {
            cboth[i+1] = cboth[i] + both.get(i);
        }

        int preA[] = new int[cntA.size()+1];
        for (int i = 0 ; i < cntA.size() ; i++ ) {
            preA[i+1] = preA[i] + cntA.get(i);
        }

        int preB[] = new int[cntB.size()+1];
        for (int i = 0 ; i < cntB.size() ; i++ ) {
            preB[i+1] = preB[i] + cntB.get(i);
        }

        long ans = Long.MAX_VALUE;
        for(int i=0 ; i<cboth.length ; i++) {
            int need = Math.max( 0 , k - i );
            if( preA.length>need && preB.length>need )
                ans = Math.min( ans , cboth[i] + preA[need] + preB[need] );
        }
        
        ob.println(ans);
    }

    boolean isNotValid(int a[][] , int k) {
        int cntA = 0 , cntB = 0;
        for(int i=0 ; i<a.length ; i++) {
            if( a[i][1] == 1 )
                ++cntA;
            if( a[i][2] == 1 )
                ++cntB;
        }

        return !( cntA>=k && cntB>=k );
    }
 
    String ns() throws IOException {
        return nextToken();
    }
    long nl() throws IOException {
        return Long.parseLong(nextToken());
    }
    int ni() throws IOException {
        return Integer.parseInt(nextToken());
    }
    double nd() throws IOException {
        return Double.parseDouble(nextToken());
    } 
    String nextToken() throws IOException {
        if(st==null || !st.hasMoreTokens())
            st=new StringTokenizer(in.readLine());
        return st.nextToken();
    }
    int[] nia(int start,int b) throws IOException {
        int a[]=new int[b];
        for(int i=start;i<b;i++)
            a[i]=ni();
        return a;
    }
    long[] nla(int start,int n) throws IOException {
        long a[]=new long[n];
        for (int i=start; i<n ;i++ ) {
            a[i]=nl();
        }
        return a;
    }
    
    public void tr(Object... o) {
     System.out.println(Arrays.deepToString(o));
    }
}