

import java.util.*;

public class JavaApplication168<T> {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.next();
        int n = sc.nextInt();
        if(n == 1){
            String xx = sc.next();
            if((xx.charAt(0) == x.charAt(0) && xx.charAt(1) == x.charAt(1)) || (xx.charAt(0) == x.charAt(1) && xx.charAt(1) == x.charAt(0))){
                System.out.println("YES"); return;
            }else{
                System.out.println("NO"); return;
            }
        }
        boolean x1 = true , x2 = true;
        while(n != 0){
            n--;
            String xx = sc.next();
            
            if(x.charAt(0) == xx.charAt(1)){
                x1 = false;
            }
            if(x.charAt(1) == xx.charAt(0)){
                x2 = false;
            }
            if(x.equals(xx)){
                System.out.println("YES"); return;
            }
            if(!x1 && !x2){
                System.out.println("YES"); return;
            }
        }
        System.out.println("NO");
       
 
        
 
 
    }
    
}


