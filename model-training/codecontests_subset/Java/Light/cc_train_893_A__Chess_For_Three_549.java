

import java.util.*;

public class JavaApplication168<T> {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
     
        int n = sc.nextInt();
        int c = 3;
        
        while(n!=0){
            n--;
            int p = sc.nextInt();
            if(p == c){
                System.out.println("NO");
                return;
            }
            c = 6 - p - c;

        }
        System.out.println("YES");

    }
    
}


