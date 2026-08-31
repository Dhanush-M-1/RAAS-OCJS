import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class _P020B{
    Scanner sc=new Scanner(System.in);

    int INF=1<<28;
    double EPS=1e-9;

    int a, b, c;

    void run(){
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        solve();
    }

    void solve(){
        int n;
        LinkedList<Double> roots=new LinkedList<Double>();
        if(a==0){
            if(b==0){
                if(c==0){
                    n=-1;
                }else{
                    n=0;
                }
            }else{
                n=1;
                roots.add((double)-c/b);
            }
        }else{
            // (-b±√(b^2-4ac))/(2a)
            long D=(long)b*b-(long)4*a*c;
            if(D>0){
                n=2;
                double r1=(-b-sqrt(D))/(2*a);
                double r2=(-b+sqrt(D))/(2*a);
                roots.add(min(r1, r2));
                roots.add(max(r1, r2));
            }else if(D==0){
                n=1;
                roots.add((double)-b/(2*a));
            }else{
                n=0;
            }
        }
        println(""+n);
        for(double root : roots){
            println(String.format("%.10f", root));
        }
    }

    void println(String s){
        System.out.println(s);
    }

    void print(String s){
        System.out.print(s);
    }

    void debug(Object... os){
        System.err.println(Arrays.deepToString(os));
    }

    public static void main(String[] args){
        new _P020B().run();
    }
}
