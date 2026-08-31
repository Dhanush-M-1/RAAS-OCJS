import java.util.Scanner;
import java.util.*;
//import java.util.InputMismatchException;

 public class fu {



     public static void main(String[] args) throws IndexOutOfBoundsException {
         Scanner sc = new Scanner(System.in);
         int r1=sc.nextInt();
         int r2=sc.nextInt();
         int c1=sc.nextInt();
         int c2=sc.nextInt();
         int d1=sc.nextInt();
         int d2=sc.nextInt();
         int total=d1+d2;
         for (int i = 1; i <10 ; i++) {
             for (int j = 1; j < 10; j++) {
                 for (int k = 1; k < 10; k++) {
                     for (int l = 1; l <10 ; l++) {
                         if(i+j+k+l==total)
                         {
                             if(i!=j && i!=k && i!=l && j!=k && j!=l && k!=l &&i+j==r1 && k+l==r2 &&i+l==d1 &&j+k==d2 && i+k==c1 && j+l==c2  )
                             {
                                 System.out.println(i+" "+j);
                                 System.out.println(k+" "+l);
                                 return ;
                             }
                         }
                     }
                 }
             }
         }
         System.out.println(-1);


     }
 }




