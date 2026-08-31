import java.util.*;
import java.io.*;
import java.lang.*;
 
public class MyClass  {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s[] = br.readLine().trim().split(" ");
        
        float a = Integer.parseInt(s[0]);
        int b = Integer.parseInt(s[1]);
        int c = Integer.parseInt(s[2]);
        
        int T = (int)Math.ceil(a * c / b);
        
        System.out.println(T - c);
    }
}