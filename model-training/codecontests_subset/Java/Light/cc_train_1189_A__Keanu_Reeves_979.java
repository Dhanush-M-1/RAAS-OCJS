

import java.util.*;

public class Main {

    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        int n = in.nextInt(), zeros = 0, ones = 0;
        String str = in.next();
        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '1') ones++;
            else zeros++;
            
        }
        
        if(ones != zeros) System.out.print("1\n" + str);
        else {
            System.out.print("2\n" + str.charAt(0) + " " + str.substring(1));
        }
    }
    
}


