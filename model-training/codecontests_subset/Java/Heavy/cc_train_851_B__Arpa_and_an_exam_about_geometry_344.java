import java.io.*;
import java.util.*;

public class B{

    public static double mod(double x[]){
        return Math.sqrt(x[0]*x[0]+x[1]*x[1]);
    } 
    public static double[] vec(int x[],int y[]){
        double v[] = new double[2];
        v[0] = y[0]-x[0];
        v[1] = y[1]-x[1];
        return v;
    }
    public static double dot(double x[],double y[]){
        return (x[0]*y[0] + x[1]*y[1]);
    }
    public static long dis(long x[],long y[]){
        return ((x[0]-y[0])*(x[0]-y[0])+(x[1]-y[1])*(x[1]-y[1]));
    }
    public static boolean colinear(long x[],long y[],long z[]){
        if((y[0]-x[0])*(z[1]-y[1]) == (y[1]-x[1])*(z[0]-y[0]))
            return true;
        return false;
    }
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        long x[][] = new long[3][2];
        for(int i=0;i<3;i++)
        {
            x[i][0] = in.nextLong();
            x[i][1] = in.nextLong();;
        }
        if(colinear(x[0],x[1],x[2])){
            System.out.println("No");
            return;
        }
        if(dis(x[0],x[1])==dis(x[1],x[2])){
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}