import java.io.*;
import java.util.*;
public class MinimumInteger {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        PrintWriter pr=new PrintWriter(System.out);
        int q=scan.nextInt();
        while(q--!=0){
            long l=scan.nextLong();
            long r=scan.nextLong();
            long d=scan.nextLong();
            long x=d;
            if(d>r || d<l)
                System.out.println(d);
            else{
               
                long quo=r/d;
                
                System.out.println((d*(quo+1)));
            }
        }



    }
}