import java.util.*;
import java.io.*;
import java.lang.*;

public class z{
    public static void main(String[] args) throws IOException {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       int abc = n;
       int ans = 0;
       HashMap<Integer,Integer> map = new HashMap<>();
       for(int i=1;i<=100;i++){
           map.put(i,0);
       }
       int[] arr = new int[n];
       
       while(n-->0){
           arr[n] = s.nextInt();
           int b = s.nextInt();
           map.put(b,map.get(b)+1);
       }
        
        for(int i=0;i<abc;i++){
            ans = ans + map.get(arr[i]);
        }
       
       System.out.println(ans);
       
       
    }
   
}