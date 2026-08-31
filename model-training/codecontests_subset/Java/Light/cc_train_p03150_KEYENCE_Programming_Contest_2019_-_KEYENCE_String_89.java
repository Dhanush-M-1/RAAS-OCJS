import java.util.*;
import java.io.*;

/*
   AtCoder contest code
   coder : yoichidon
 */
import java.util.*;
import java.io.*;

public class Main {
    public static boolean isKeyence(String S){
        final String keyence = "keyence";
        for(int i=0; i<keyence.length(); i++){
            if(S.startsWith(keyence.substring(0,i)) && S.endsWith(keyence.substring(i,keyence.length()))) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.next();
        if(isKeyence(S)) System.out.println("YES");
        else System.out.println("NO");

    }
}
