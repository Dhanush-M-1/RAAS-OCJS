
import java.util.Scanner;

/**
 *
 * @author ali
 */
public class NewClass1 {
     public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
         int n = in.nextInt();
         int k = in.nextInt();
         int tst=k;
         int min=0;
         int newmin=200;
         int[] buckets = new int[n];
         int i=0;
         for(i=0;i<n;i++){
             buckets[i]=in.nextInt();
         }
         for(i=0;i<n;i++){
             while(tst>0){
                tst=tst-buckets[i];
                min++;
             }
             if(min>newmin||tst!=0){
             }
             else{
                   newmin=min;
             }
             min=0;
             tst=k;
         }
         System.out.println(newmin);
       
   
}
}
