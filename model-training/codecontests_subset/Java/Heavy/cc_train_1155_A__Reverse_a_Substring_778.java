import java.util.*;
import java.lang.*;
import java.io.*;

public class sample2{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String p = new String(arr);
        if(p.equals(s)){
            System.out.println("NO");
        }
        else{
            System.out.println("YES");
            for(int i = 0; i < n-1; i++){
                if((int) s.charAt(i+1) < (int) s.charAt(i)){
                    System.out.println((i+1) + " " + (i+2));
                    break;
                }
            }
        }
    }
}