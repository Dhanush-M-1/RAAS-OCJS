import java.util.*;
import java.lang.*;

public class Inverse_Num {
    
    public static void main(String[] args) throws java.lang.Exception{
        java.io.BufferedReader entrada = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
        String a = entrada.readLine();
        String b = entrada.readLine();
        boolean res = com_strings(a,b);
        if(res){System.out.println("YES");}else{System.out.println("NO");}      
    }
    public static boolean com_strings(String a, String b){
        
        if(a.length()%2 != 0 && !a.equals(b)){
            return false;
        }else if(a.equals(b)){
            return true;
        }else{
            String a1 = a.substring(0,a.length()/2);
            String a2 = a.substring(a.length()/2);
            String b1 = b.substring(0,b.length()/2);
            String b2 = b.substring(b.length()/2);
            return (com_strings(a1,b2) && com_strings(a2,b1)) || (com_strings(a1,b1) && com_strings(a2,b2)) ;
        }
    }

}