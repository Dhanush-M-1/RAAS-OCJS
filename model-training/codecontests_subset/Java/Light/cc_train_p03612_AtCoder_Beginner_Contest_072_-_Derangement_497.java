import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        long mod = (long)Math.pow(10,9)+7;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int ans = 0;
        int chain = 0;
        for(int i = 0; i < n; i++){
            if(a[i] == i+1){
                chain++;
            }else{
                ans += (int)Math.ceil((double)chain/2d);
                chain = 0;
            }
        }
        System.out.println(ans + (int)Math.ceil((double)chain/2d));
    }
}