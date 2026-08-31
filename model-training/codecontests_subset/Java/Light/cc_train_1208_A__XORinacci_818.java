                               
 //I love green's theorem, but I hate divergence theorem
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
import java.awt.*;





public class HelloWorld{

    public static void main(String[] args) throws IOException 
    { 
  
        Scanner input = new Scanner(System.in);
        input.nextInt();
        while(input.hasNext()){
            int a=input.nextInt();
            int b=input.nextInt();
            int n=input.nextInt();
            if(n%3==0){
                System.out.println(a);
                continue;
            }
            if(n%3==1){
                System.out.println(b);
                continue;
            }
            if(n%3==2){
                System.out.println(a^b);
                continue;
            }
        }
        
    }

    
}