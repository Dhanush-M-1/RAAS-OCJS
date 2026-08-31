import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {
    
    private static boolean check(String s, int n) {
        for(int i=1;i<n;i++) {
            for(int j=0;j+4*i<n;j++) {
                if(s.charAt(j) == '.') continue;
                int k;
                for(k=1;k<=4;k++) {
                    if(s.charAt(j) != s.charAt(j+k*i)) break;
                }
                if(k > 4) {
                    //System.out.println(i + " " + j + " " + k);
                    return true; 
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        if(check(s, n) == true) System.out.println("yes");
        else System.out.println("no");
    }
}
