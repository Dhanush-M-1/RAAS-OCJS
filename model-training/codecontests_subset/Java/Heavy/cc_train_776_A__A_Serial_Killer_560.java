
import java.util.Scanner;

/**
 *
 * @author ali
 */
public class NewClass1 {
     public static void main(String[] args) {
     Scanner in = new Scanner(System.in);
         String n1 =in.next();
         String n2 =in.next();
         int n = in.nextInt();
         int i=0;
         for(i=0;i<n+1;i++){
             System.out.println(n1+" "+n2);
             if(i==n){
                 break;
             }
             String vic =in.next();
             String subs =in.next();
             if(vic.equalsIgnoreCase(n1)){
                 n1=subs;  
             }
             else if (vic.equalsIgnoreCase(n2)){
                 n2=subs;
             }
             
         }
   
}
}
