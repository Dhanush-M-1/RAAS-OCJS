import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
//import java.util.StringTokenizer;
import java.lang.StringBuilder;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.ArrayList;

public class MultiplicationTable {
    
    static int b;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        b = Integer.parseInt(in.readLine());
        int n = b-1;
        String[][] str = new String[n][n];
        if(b == 10)
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    str[i][j] = "" + ((i+1) * (j+1));
                }
            }
        else
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    str[i][j] = convertir((i+1) * (j+1));
                }
            }
        int l = str[n-1][n-1].length() + 1;
        for(int i = 0; i < n; i++) {
            sb.append(str[i][0]);
            for(int j = 1; j < n; j++) {
                ajouter(l - str[i][j].length());
                sb.append(str[i][j]);
            }
            sb.append("\n");
        }
        out.print(sb);
        out.close();
    }
    
    public static void ajouter(int n) {
        for(int i = 0; i < n; i++) {
            sb.append(" ");
        }
    }
    
    public static String convertir(int n) {
        StringBuilder s = new StringBuilder();
        while(n != 0) {
            s.append((n % b));
            n = (n / b);
        }
        return s.reverse().toString();
    }
}