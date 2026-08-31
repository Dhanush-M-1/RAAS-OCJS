import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class TaskA {
    
    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
    PrintWriter out = new PrintWriter(System.out);;
    StringTokenizer st = new StringTokenizer("");
    
    public static void main(String[] args) throws Exception {
        new TaskA().run();
    }
    
    private void run() throws Exception {

        // Here To Code
        int n = readInt();
        int s2 = 0;
        int s1 = 0;
        int sum = 0;
        for (int i=0; i<n; i++) {
            int x = readInt();
            sum += x/100;
            if (x == 100) s1++;
            else s2++;
        }
        
        if (sum%2 != 0) {
            print("NO");
            return;
        }
        if (s2%2==0 && s1%2==0) print("YES");
        else if (s2%2!=0 && s1>1) print("YES");
        else print("NO");
        
    }

    private void print(double d) {
        out.print(d);
        out.flush();
    }
    
    private void print(String string) {
        out.print(string);
        out.flush();
    }
    
    private void print(boolean b) {
        out.print(b);
        out.flush();
    }
    
    private void print(int i) {
        out.print(i);
        out.flush();
    } 
    
    private String readString() throws Exception {
        while(!st.hasMoreTokens())
            st = new StringTokenizer(stdin.readLine());
        return st.nextToken();
    }
    private String readStringChar() throws Exception {
        while(!st.hasMoreTokens())
            st = new StringTokenizer(stdin.readLine());
        return st.nextToken();
    }
    
    private int readInt() throws Exception {
        return Integer.parseInt(readString());
    }
    
    private double readDouble() throws Exception {
        return Double.parseDouble(readString());
    }
    
    private void close() {
        out.close();
    }

}