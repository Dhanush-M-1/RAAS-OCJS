import java.util.*;
import java.io.*;

/**
 * Created by HREN_VAM.
 */

public class B implements Runnable{

    BufferedReader in;
    PrintWriter out;
    StringTokenizer st;
    public static final String filename = "b";

    int t;
    int m;
    int[] a;
    int[] b;

    boolean alloc(int n, int num){
        for(int i = 0;i < m - n + 1;i ++){
            boolean flag = true;
            for(int j = 0;j < n;j ++){
                if(a[i + j] != 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                for(int j = 0;j < n;j ++){
                    a[i + j] = num;
                }
                return true;
            }
        }
        return false;
    }

    boolean erase(int num){
        boolean res = false;
        for(int i = 0;i < m;i ++){
            if(a[i] == num){
                res = true;
                a[i] = 0;
            }
        }
        return res;
    }

    void def(){
        for(int i = 0;i < m;i ++){
            b[i] = a[i];
            a[i] = 0;
        }
        int top = 0;
        for(int i = 0;i < m;i ++){
            if(b[i] != 0){
                a[top] = b[i];
                top ++;
            }
        }
    }

    public void solve() throws IOException{
        t = nextInt();
        m = nextInt();
        a = new int[m];
        b = new int[m];

        int top = 1;
        for(int i = 0;i < t;i ++){
            String s = nextToken();
            if(s.equals("defragment")){
                def();
                continue;
            }
            if(s.equals("alloc")){
                int z = nextInt();
                if(alloc(z, top)){
                    out.println(top);
                    top ++;
                }else{
                    out.println("NULL");
                }
                continue;
            }
            if(s.equals("erase")){
                int z = nextInt();
                if((z == 0) || !erase(z))out.println("ILLEGAL_ERASE_ARGUMENT");
            }
        }
    }

    public void run(){
        try{
            Locale.setDefault(Locale.US);
            in = new BufferedReader(new InputStreamReader(System.in));
            //in = new BufferedReader(new FileReader(filename + ".in"));
            out = new PrintWriter(System.out);
            //out = new PrintWriter(new FileWriter(filename + ".out"));
            st = new StringTokenizer("");
            solve();
            out.close();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args){
        new Thread(new B()).start();
    }

    public String nextToken() throws IOException{
        while(!st.hasMoreTokens()){
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public int nextInt() throws IOException{
        return Integer.parseInt(nextToken());
    }

    public double nextDouble() throws IOException{
        return Double.parseDouble(nextToken());
    }
}