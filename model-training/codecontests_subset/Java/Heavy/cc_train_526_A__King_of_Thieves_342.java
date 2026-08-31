import java.io.*;
import java.util.Scanner;
public class Solution{
   public static void main(String[] args) throws FileNotFoundException{
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       String map = scanner.next();
       char c[] = map.toCharArray();
       boolean b = false;
       for(int i=1;i<=n/4;i++){
            int s = 0;
            for(int k=0;k<i;k++){
	            for(int j=0;j<=n/i;j++){
	                if(k+(i*j) < n  && c[k+i*j] == '*'){
	                    s ++;
	                    if(s >= 5){
	                        b = true;
	                        break;
	                        
	                    }
	                }else{
	                   s = 0;
	                }
	            }
            }
           if(b){
               break;
           }
       }
      if(b){
         System.out.println("yes");
       }else{
    	   System.out.println("no");
       }
   }
}