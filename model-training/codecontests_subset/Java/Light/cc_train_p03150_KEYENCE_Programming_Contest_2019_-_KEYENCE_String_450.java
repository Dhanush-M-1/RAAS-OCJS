import java.util.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        
        if(str.equals("keyence")){
            System.out.println("YES");
        }else if(str.matches(".*"+"keyence") || str.matches("k"+".*"+"eyence")
        || str.matches("ke"+".*"+"yence") || str.matches("key"+".*"+"ence")
        || str.matches("keye"+".*"+"nce") || str.matches("keyen"+".*"+"ce")
        || str.matches("keyenc"+".*"+"e") || str.matches("keyence"+".*")){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
