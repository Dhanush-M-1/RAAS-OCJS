import java.util.Scanner;
import java.lang.Math;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int minj,z,cnt=0;
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < n-1; i++){
            minj = i;
            int x = a[i];
            for(int j=i+1;j<n;j++){
                if(a[j] < a[minj]){
                    minj = j;
                }
            }
            if(a[minj]!=x) cnt++;
            z = a[i];
            a[i] = a[minj];
            a[minj] = z;
        }
        for(int i = 0; i<n-1;i++){
            System.out.printf("%d ",a[i]);
        }
        System.out.printf("%d%n%d%n",a[n-1],cnt);
        sc.close();
    }
}

