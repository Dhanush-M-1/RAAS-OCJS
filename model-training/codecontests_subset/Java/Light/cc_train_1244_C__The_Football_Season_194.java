import java.util.*;
import java.util.Scanner;
public class BasicJava {
    public static void main(String arg[])
    {
        Scanner read = new Scanner(System.in);
        long n,p,w,d;
        n = read.nextLong();
        p = read.nextLong();
        w = read.nextLong();
        d = read.nextLong();
        long x=-1,y=-1,z=-1;
        for(y=0;y<=w;y++)
        {
            long baki = p-(y*d);
            if(baki % w == 0 && (y+(baki/w))<=n)
            {
                x=baki/w;
                break;
            }
        }
        z=n-x-y;
        if(x<=-1 || y<=-1) System.out.print("-1");
        else System.out.print(x+" "+y+" "+z+"\n");
    }
}