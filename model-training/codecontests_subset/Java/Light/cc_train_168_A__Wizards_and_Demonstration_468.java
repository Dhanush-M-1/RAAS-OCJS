import java.util.*;
import java.io.*;
import java.awt.Point;
import static java.lang.Math.*;

public class P168A { public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        long n = in.nextInt();
        long x = in.nextInt();
        long y = in.nextInt();
        long need = (n*y/100)+(n*y%100==0?0:1)-x;
        need = Math.max(need, 0);
        System.out.println(need);
    }
}
