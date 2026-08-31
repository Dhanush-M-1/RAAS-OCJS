import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(reader.readLine());
        while((t--) != 0) {
            int n = Integer.valueOf(reader.readLine());
            String[] info = new String[n];
            for(int i=0; i<n; i++) {
                info[i] = reader.readLine();
            }
            
            int a1 = info[0].charAt(1) - '0';
            int a2 = info[1].charAt(0) - '0';
            
            int b1 = info[n-2].charAt(n-1) - '0';
            int b2 = info[n-1].charAt(n-2) - '0';
            
            
            if(a1==a2 && b1==b2 && a1!= b1) {
                System.out.println(0);
            }else if(a1==a2 && b1==b2 && a1==b1) {
                System.out.println(2);
                System.out.println("1 2");
                System.out.println("2 1");
            }else if(a1==a2 && b1!=b2) {
                System.out.println(1);
                if(b1 != a1) {
                    System.out.println(n + " " + (n-1));                    
                }else {
                    System.out.println(n-1 + " " + n);
                }
            }else if(b1==b2 && a1!=a2) {
                System.out.println(1);
                if(a1 != b1) {
                    System.out.println("2 1");
                }else {
                    System.out.println("1 2");
                }
            }else {
                System.out.println(2);
                System.out.println("2 1");
                if(b1 != a2) {
                    System.out.println(n-1 + " " + n);
                }else {
                    System.out.println(n + " " + (n-1));
                }
            }
        }
    }
}