import java.util.*;
import java.io.*;

/**
 *
 * @author Artemon
 */
public class A {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        
        String str = in.next();
        
        char[] s = str.toCharArray();
        int l, r;
        for(int i = 0; i < n - 1; i++){
            
            if(s[i+1] < s[i]){
                l = i + 1;
                r = i + 2;
                System.out.println("YES");
                    String res = l + " " + r;
                    System.out.println(res);
                    return;
            }
            
        }
        System.out.println("NO");
        
    }
    
}