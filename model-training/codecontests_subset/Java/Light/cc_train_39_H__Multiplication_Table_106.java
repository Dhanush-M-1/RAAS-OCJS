import java.util.*;
//import java.io.*;


public class Test {
    
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int r = 1; r < n; r++){
            StringBuilder sb = new StringBuilder();
            for(int c = 1; c < n; c++){
                sb.append(Integer.toString(r*c, n)).append(" ");
            }
            System.out.println(sb);
        }
    }
    
        
}