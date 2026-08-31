import java.io.*;
import java.util.*;

public class Main {
    
    static int n=0;
    static int[] a=new int[100010];
    
    static boolean check(boolean inc) {
        for (int i=1;i<n;i++) {
            if ( inc && a[i]>a[i+1]) return false;
            if (!inc && a[i]<a[i+1]) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        Scanner cin=new Scanner(new BufferedInputStream(System.in));
        
        n=cin.nextInt();
        for (int i=1;i<=n;i++) {
            a[i]=cin.nextInt();
        }
        for (int i=1;i<n;i++) {
            if (a[i]!=a[i+1]) {
                int tmp=a[i]; a[i]=a[i+1]; a[i+1]=tmp;
                if (!check(true) && !check(false)) {
                    System.out.println(i+" "+(i+1));
                    return;
                }
                tmp=a[i]; a[i]=a[i+1]; a[i+1]=tmp;
            }
        }
        System.out.println(-1);
        
        cin.close();
    }
}