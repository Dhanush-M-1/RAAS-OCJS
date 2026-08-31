import java.util.*;
public class Sol{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
            }
            int[] d = new int[n];
            func(0, n-1, 0, arr, d);
            
            for(int i=0;i<n;i++){
                System.out.print(d[i]+" ");
            }
            System.out.println();
        }
    }   
    public static void func(int l, int r, int c, int[] arr, int[] d){
        if(l<=r){
            int index=l;
            int max = arr[l];
            int psn = l;
            for(int i=l+1;i<=r;i++){
                if(arr[i]>max){max = arr[i]; psn=i;}
            }
            
            d[psn] = c;
            func(l, psn-1, c+1, arr, d);
            func(psn+1, r, c+1, arr, d);
        }
    }
}










