import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException{
        new Main().run();
    }
    void run(){
        Scanner sc = new Scanner(System.in);
        
        long a = sc.nextLong(), b = sc.nextLong();
        long x1 = sc.nextLong(), y1 = sc.nextLong();
        long x2 = sc.nextLong(), y2 = sc.nextLong();
        
        final long BIGA = Math.abs( a * 2000000000L );
        final long BIGB = Math.abs( b * 2000000000L );
        
        long m = Math.abs( (x2 + y2 + BIGA) / (2 * a) - (x1 + y1 + BIGA) / (2 * a) );
        long n = Math.abs( (y1 - x1 + BIGB) / (2 * b) - (y2 - x2 + BIGB) / (2 * b) );
        
        System.out.println( Math.max(m, n) );
    }
}