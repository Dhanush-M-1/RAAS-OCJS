import java.io.*;
import java.util.*;
public class Problem1Watermelon {
 
    
    public static void main(String[] args) {
        Scanner in=new Scanner (new BufferedReader(new InputStreamReader(System.in)));
        int n=in.nextInt(),c1=0,c2=0,c3=0;
        
        for (int i = 0; i < n; i++) {
            c1+=in.nextInt();
        }
        for (int i = 0; i < n-1; i++) {
            c2+=in.nextInt();
        }
        for (int i = 0; i < n-2; i++) {
            c3+=in.nextInt();
        }
        System.out.println(c1-c2);
        System.out.println(c2-c3);
    }
}