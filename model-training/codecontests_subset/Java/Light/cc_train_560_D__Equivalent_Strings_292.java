
import java.io.*;
import java.util.*;
import java.math.*;
import static java.lang.Math.*;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;
import static java.lang.String.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        StringTokenizer tk;
        
        String s = in.readLine(),t = in.readLine();
        
        s = calc(s);
        t = calc(t);
        
        System.out.println(s.equals(t) ? "YES" : "NO");
    }
    
    static String calc(String str) {
        if(str.length()%2==1)
            return str;
        
        String a = calc(str.substring(0,str.length()/2));
        String b = calc(str.substring(str.length()/2));
        
        if(a.compareTo(b)<0) return a + b;
        return b + a;
    }
}