import java.io.*;
import java.util.*;
import java.lang.*;
public class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        double a=sc.nextDouble();
        double b=sc.nextDouble();
        double c=sc.nextDouble();
        if(a==0 && b!=0){
            double ans=-(c/b);
            System.out.format("1\n%.5f",ans);
        }
        else if(a==0 && b==0 && c==0){
            System.out.println("-1");
        }
        else if(a==0 && b==0 && c!=0){
            System.out.println("0");
        }
        else{
        double r1,r2;
        double det=b*b-4*a*c;
        if(det>0){
            System.out.println("2");
            r1=(-b+Math.sqrt(det))/(2*a);
            r2=(-b-Math.sqrt(det))/(2*a);
            double x=(r1<r2)?r1:r2;
            double y=(r1>r2)?r1:r2;
            System.out.format("%.5f\n%.5f\n",x,y);
        }
        else if(det==0){
            r1=(-b+Math.sqrt(det))/(2*a);
        System.out.format("1\n%.5f",r1);
        }
        else
        System.out.println("0");
        }
    }
}