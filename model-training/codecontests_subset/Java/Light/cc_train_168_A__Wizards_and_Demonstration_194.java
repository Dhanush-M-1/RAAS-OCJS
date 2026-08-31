import java.io.*;
import java.util.*;

public class p168a
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        double n = sc.nextDouble();
        double x = sc.nextDouble();
        double y = sc.nextDouble();
        y /= 100;
        int x1 = (int)Math.ceil(n*y);
        int X = (int)x;
        if(x1>=X) System.out.println(x1-X);
        else System.out.println("0");
    }
}