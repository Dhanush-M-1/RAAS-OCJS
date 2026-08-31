
import java.util.Arrays;
import java.util.Scanner;
/**
 * @author Abd El-Sattar
 * 26-1-2015
 * 04:36 pm
 */
public class Helpful_Math {
    public static void main(String args []){
        Scanner input = new Scanner(System.in);
        String line= input.next(),newLine="";
        int sz=(line.length()/2)+1, num;
        int [] arr = new int[sz];
        for(int i = 0,m=0 ; i< line.length(); i+=2,m++){
            num = (int)line.charAt(i)-48;
            arr[m]=num;
          }
        Arrays.sort(arr);
        newLine= (""+arr[0]); 
        for(int i=1 ;i <sz ; i++){
           newLine+= ("+"+arr[i]); 
        }
        System.out.println(newLine);
    }
}
