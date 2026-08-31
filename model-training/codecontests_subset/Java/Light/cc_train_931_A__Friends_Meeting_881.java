
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.awt.OSInfo;

/**
 *
 * @author farah
 */
public class sec {
    
    public static String sol(int arr1[] , int arr2[] , int ARR1[] , int ARR2[]){
        for(int i=0 ; i<26 ; i++){
            //System.out.println(i+ " arr2 " +arr2[i]+" arr1 "+arr1[i] +" ARR2 "+ARR2[i]+" ARR1 "+ARR1[i]);
            if(arr2[i]>arr1[i] || ARR2[i]>ARR1[i])
                return "NO";}
       
        
        return "YES";
    }

    public static boolean is(int arr[],long E){
        for(int i=0 ; i<arr.length ; i++){
            E=2*E-arr[i];System.out.println(E);
            if(E<0){System.out.println(E);
                return false;}
        }
        return true;
    }
    public static void main(String[] args) throws FileNotFoundException {
       Scanner sc = new Scanner(System.in);
       int n1=sc.nextInt();
       int n2=sc.nextInt();
       int absDiff=Math.abs(n2-n1);
       // System.out.println((absDiff/2)*(absDiff/2+1)/2);
       if(absDiff%2==1)
            System.out.println(2*(absDiff/2)*(absDiff/2+1)/2+absDiff/2+1);
       else 
           System.out.println(2*(absDiff/2)*(absDiff/2+1)/2);       

    }

}
