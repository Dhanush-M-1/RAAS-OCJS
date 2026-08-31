import java.util.*;
import java.io.*;
public class MyClass {
    public static void main(String args[]) {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s1[] = br.readLine().split(" ");
            String s2[] = br.readLine().split(" ");
            String s3[] = br.readLine().split(" ");
            int r1 = Integer.parseInt(s1[0]);
            int r2 = Integer.parseInt(s1[1]);
            int c1 = Integer.parseInt(s2[0]);
            int c2 = Integer.parseInt(s2[1]);
            int d1 = Integer.parseInt(s3[0]);
            int d2 = Integer.parseInt(s3[1]);
            int a = (int)Math.ceil((r1+c1-d2)/2);
            int b = (int)Math.ceil((r1-c1+d2)/2);
            int c = (int)Math.ceil((d2-r1+c1)/2);
            int d = (int)Math.ceil((2*d1+d2-r1-c1)/2);
            if(a==b || a==c || a==d || b == c || b == d ||c == d){
                System.out.println(-1);
            }else if(a>0 && b>0 && c>0 && d>0 && a<=9 && b<=9 && c<=9 && d<=9 && (a+b)==r1 && (c+d)==r2 && (a+c)==c1 && (b+d)==c2 && (a+d)==d1 && (b+c)==d2){
                System.out.println(a+" "+b);
                System.out.println(c+" "+d);
            }
            else{
               System.out.println(-1); 
            }
        }catch(Exception e){
            System.out.println(e);
        }
        //a>0 && b>0 && c>0 && d>0
    }
}