import java.util.*;

public class Main {
    
    public static int get2(int[] n){
        int c = 0;
        while(n[0]%2 == 0){
            c++;
            n[0] /= 2;
        }
        
        return c;
    }
    
    public static int get3(int[] n){
        int c = 0;
        while(n[0]%3 == 0){
            c++;
            n[0] /= 3;
        }
        
        return c;    
    }
    
    public static int get5(int[] n){
        
        int c = 0;
        while(n[0]%5 == 0){
            c++;
            n[0] /= 5;
        }
        
        return c;
    }
    
    
    
    public static void solve(int[] a, int[] b){
        int count = 0;
        if(a[0]==b[0]){
             System.out.println(0);
             return;
        }
        count += Math.abs(get2(a)-get2(b));
        count += Math.abs(get3(a)-get3(b));
        count += Math.abs(get5(a)-get5(b));
        //System.out.println(a[0]  + " "+b[0]);        
        
        if(a[0] != b[0]){
            System.out.println(-1);
            return;
        }
        
        System.out.println(count);        
    }
    
    
    
    public static void main(String args[]) {
     Scanner sc = new Scanner(System.in);
     int[] a = new int[1];
     int[] b = new int[1];
     a[0] = sc.nextInt();
     b[0] = sc.nextInt();
     
     solve(a,b);
    }
}