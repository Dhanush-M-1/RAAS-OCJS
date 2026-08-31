import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public final class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        
        int N = in.nextInt();
        boolean[] first = new boolean[128];
        boolean[] second = new boolean[128];
        for(int i=0; i < N; i++){
            String s1 = in.next();
            if(s1.equals(s)){
                System.out.println("YES"); return;
            }
            char c1 = s1.charAt(0);
            char c2 = s1.charAt(1);
            
            first[c1] = true;
            second[c2] = true;
        }
        
        if(second[s.charAt(0)] && first[s.charAt(1)]){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
