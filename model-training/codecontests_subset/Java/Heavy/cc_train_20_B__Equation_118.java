import java.util.Scanner;
public class Quad{
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       long a = sc.nextInt();
       long b = sc.nextInt();
       long c = sc.nextInt();
       if(a==0 && b==0 && c==0) {
       System.out.println(-1);
       } 
       if(a==0 && b==0 && c!=0) {
       System.out.println(0);
       } 
       if (a==0 && b!=0 && c!=0) {
               double x = -1.0*c/b;
               System.out.println(1);
               System.out.printf("%05.10f",x);
       }
       if (a==0 && b!=0 && c==0) {
               System.out.println(1);
               double x=0;
               System.out.printf("%05.10f",x);
       }
       if(a!=0 && b==0 && c==0) {
               System.out.println(1);
               double x =0;
               System.out.printf("%05.10f",x);
           
       }
       if(a!=0 && b==0 && c!=0) {
           if((a>0 && c<0)||(a<0 && c>0)){
               double x = Math.sqrt(-1.0*c/a);
               System.out.println(1);
               System.out.printf("%05.10f",x);
           }
           if((a<0 && c<0)||(a>0 && c>0)){
           System.out.println(0);
           }
       }
       if(a!=0 && b!=0 && c==0) {
           System.out.println(2);
           double x1=0;
           double x2= (-1.0*b/a);
           System.out.printf("%05.10f",Math.min(x1,x2));
           System.out.println();
           System.out.printf("%05.10f",Math.max(x1,x2));
       }
       if(a!=0 && b!=0 && c!=0) {
           long dis = b*b - 4*a*c;
           if (dis<0) {
               System.out.println(0);
           }
           if (dis==0) {
               double x = -0.5*b/a;
               System.out.println(1);
               System.out.printf("%05.10f",x);
           }
           if(dis>0) {
               double x1 = (-1.0*b+Math.sqrt(dis))/(2*a);
               double x2 = (-1.0*b-Math.sqrt(dis))/(2*a);
               System.out.println(2);
               System.out.printf("%05.10f",Math.min(x1,x2));
               System.out.println();
               System.out.printf("%05.10f",Math.max(x1,x2));
           }
       }
   }
}