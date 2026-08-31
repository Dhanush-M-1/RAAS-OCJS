


 


 
 
 
 
//I AM THE CREED
/* package codechef; // don't place package name! */
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
 
public class HelloWorld{
    public static void main(String[] args) throws IOException 
    { 
  
        Scanner input = new Scanner(System.in);
        input.nextInt();
        while(input.hasNext()){
            int n=input.nextInt();
            int two=0;
            int three=0;
            while(n%2==0){
                n=n/2;
                two++;
            }
            while(n%3==0){
                n=n/3;
                three++;
            }
            if(n==1 && two<=three){
                System.out.println(three+(three-two));
                continue;
            }
            System.out.println(-1);
            continue;
        }
    }
  
 
}