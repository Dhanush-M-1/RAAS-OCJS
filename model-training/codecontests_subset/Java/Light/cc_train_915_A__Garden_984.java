import java.util.*;
import java.io.*;

public class file{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int ans = 10000;
        int a[] = new int[m];
        for(int i=0;i<m;i++){
            a[i] = sc.nextInt();
            if(n % a[i] == 0)
                ans = Math.min(ans , n/a[i]);
        }
        if(ans != 10000)
            System.out.println(ans);
        else{
            
        }
        
    }
    
}