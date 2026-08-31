import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class Main {
    
    public static Scanner cin = new Scanner(System.in);
    
    public static final int N = 150000;
    
    public static void main(String[] args) throws IOException  {
        
        //BufferedReader in = new BufferedReader(new FileReader(new File("D:/java.inp")));
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        
        //------------------------------------------------------------------------------//
        
        int n = Integer.parseInt(in.readLine());
        String[] s = in.readLine().split(" ");
        long sum = 0, Max = 0;
        for (int i=0;i<n;i++) {
            long tmp = Long.parseLong(s[i]);
            sum += tmp;
            Max = Math.max(Max, tmp);
        }
        long res;
        if (sum%(n-1) == 0) res = sum/(n-1); else res = sum/(n-1)+1;
        res = Math.max(res,  Max);
        System.out.println(res);
        
        
    }
    
} 