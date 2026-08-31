/*
* @Author Silviase(@silviasetitech)
* For ProCon
*/

import java.util.*;
import java.lang.*;
import java.math.*;

class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        if (s.endsWith("keyence") || (s.endsWith("eyence")&&s.startsWith("k"))
            || (s.endsWith("yence")&&s.startsWith("ke"))
            || (s.endsWith("ence")&&s.startsWith("key"))
            || (s.endsWith("nce")&&s.startsWith("keye"))
            || (s.endsWith("ce")&&s.startsWith("keyen"))
            || (s.endsWith("e")&&s.startsWith("keyenc")) ){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        sc.close();
    }

}