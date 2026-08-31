import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.lang.Math; 
import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Ritul
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in); 

   int n = sc.nextInt();
       int k = sc.nextInt();
       int arr[] = new int[n];
       int ans=0;
       long low=66666660;
       for(int i=0;i<n;i++){
           arr[i] = sc.nextInt();
           if(k % arr[i] == 0)
               low = min(low,k/arr[i]);
       }
       System.out.println(low);
       
    }
}