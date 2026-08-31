import java.util.*;
import java.io.*;
public class HelloWorld{

     public static void main(String []args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
         
        
        List<Integer> bulbs = new ArrayList<>();
        List<Integer> check = new ArrayList<>();
        
        for (int y = 0; y < n; y ++){
            int b = scan.nextInt();
            for (int i = 0; i < b; i ++){
                int a = scan.nextInt();
                bulbs.add(a);
            }
        }

        
        int count = 0;
        for (int i = 0; i < m; i ++){
            if (bulbs.contains(i + 1)){
                count++;
            }
        }

        
        if (count == m){
            System.out.println("YES");
        } else {
            System.out.println("NO");
        } 
     }
}