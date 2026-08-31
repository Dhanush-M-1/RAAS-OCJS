import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int r1 = scn.nextInt();
        int r2= scn.nextInt();
        int c1 = scn.nextInt();
        int c2 = scn.nextInt();
        int d1 = scn.nextInt();
        int d2 = scn.nextInt();
        
        int d=(c2-r1+d1)/2;
        int a=d1-d;
        int b=c2-d;
        int c=r2-d;
        
        if(a+c!=c1 || b+c!=d2)
        {
         System.out.println("-1");
            return;
        }
        
        if(a<1 || b<1 || c<1 || d<1 || a>9 ||b>9 || c>9 || d>9)
        {
         System.out.println("-1");
            return;
        }
        
        if(a==b ||a==c|| a==d||b==c||b==d ||c==d)
        {
         System.out.println("-1");
            return;
        }
        
        System.out.println(a+" "+b);
        System.out.println(c+" "+d);
    }
}