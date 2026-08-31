import java.io.*;
import java.util.*;
import java.math.*;

public class Main {


    public static void main(String[] Args) throws Exception {

         BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
         String st[] = bf.readLine().split(" ");
         int n = Integer.parseInt(st[0]);
         int a = Integer.parseInt(st[1]);
         int b = Integer.parseInt(st[2]);
         int c = Integer.parseInt(st[3]);
         int ct = 0;
         for(int i=0;i<=b;++i)
            for(int j=0;j<=c;++j){
                int r = n-i-2*j; r*=2;
                if(r>=0 && r<=a) ++ct;
            }
        System.out.println(ct);
    }
    
}

