import java.util.Scanner;
import java.util.Arrays;
import java.util.*; 
import java.math.*;
import java.io.*;
public class Main {
 public static void main ( String args[] ) {
     Scanner s  = new Scanner(System.in);
     int r1 = s.nextInt();
     int r2 = s.nextInt();
     int c1 = s.nextInt();
     int c2 = s.nextInt();
     int d1 = s.nextInt();
     int d2 = s.nextInt();
     long result = 0 ;
     int[] x = new int[4];
     
     
     for(int i = 1 ; i<10 ; i++){
         if(i<r1 && i<c1 && i<d1){
             x[0] = i ;
             x[1] = r1 - i; 
             x[2] = c1 - i; 
             x[3]=  d1 - i;
             
             if((x[2]+x[3]== r2) && (x[1]+x[3]== c2) && (x[1]+x[2]== d2)){
                  if(x[0]!=x[1] && x[1]!=x[2] && x[2]!=x[3] && x[3]!=x[1] && x[0]!=x[2]&& x[0]!=x[3]){
                 if(x[3]<10 && x[2]<10  && x[1]<10 && x[0]<10 ){
                 System.out.println(x[0]+" "+x[1]);
                 System.out.println(x[2]+" "+x[3]);
                 break ;
                 }
                 else{
            System.out.print(-1);
            break ;
         }
                  }else{
            System.out.print(-1);
            break ;
         }
                 
             
         }
             
         
     

     
}else{
     System.out.print(-1); 
     break;
}
}
}
}
