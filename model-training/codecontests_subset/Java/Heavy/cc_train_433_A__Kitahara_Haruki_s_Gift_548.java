import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {public static void main(String[] args) throws Exception {new Solve();}}

class Solve { public Solve() throws Exception {solve();}
    void solve() throws Exception {
         int n = NI();
        int[] a = new int[n];
        int sum = 0;
        for (int i =0 ; i < n; i++) {
            a[i] = NI();
            sum += a[i];
        }
        if (sum % 2 != 0) {
            System.out.println("NO");
            return;
        }
        int need = sum / 2, ind = n - 1, t = 0;
        Arrays.sort(a);
        while (t < need) {
            t += a[ind];
            ind--;
        }
        if (t > need) t -= a[++ind];
        System.out.println((t + a[0] == need || t == need) ? "YES" : "NO");
    }

    class Pair {
        int i, j, wrong;
    }

    static BufferedReader stdin=new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st=new StringTokenizer("");
    static Scanner sc = new Scanner(System.in);
    int min(int i1,int i2){return i1<i2?i1:i2;}
    long min(long i1,long i2){return i1<i2?i1:i2;}
    int max(int i1,int i2){return i1>i2?i1:i2;}
    long max(long i1,long i2){return i1>i2?i1:i2;}
    String NS()throws Exception{while(!st.hasMoreTokens())st=new StringTokenizer(stdin.readLine());return st.nextToken();}
    String NLn() throws Exception {return stdin.readLine();}
    int NI()throws Exception{return Integer.parseInt(NS());}
    long NL()throws Exception{return Long.parseLong(NS());}
    double ND()throws Exception{return Double.parseDouble(NS());}
    int abs(int x){return x<0?-x:x;}
}