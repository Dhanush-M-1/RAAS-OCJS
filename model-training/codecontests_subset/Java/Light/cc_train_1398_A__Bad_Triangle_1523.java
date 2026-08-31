

import java.util.Scanner;


public class E93A {

 
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int tc = input.nextInt();
        
        while(tc-->0)
        {
            int n = input.nextInt();
            long a[] = new long[n];
            for (int i = 0; i <n; i++) a[i]=input.nextLong();
            if(a[0]+a[1]<=a[n-1])
                System.out.println("1 2 "+n);
            else System.out.println("-1");
            
            
        }
        
        
    }
    
}
