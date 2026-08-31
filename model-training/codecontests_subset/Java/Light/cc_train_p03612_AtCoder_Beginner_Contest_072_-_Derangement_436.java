import java.util.*;

public class Main{

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] p = new int[N];
        int[] a = new int[N+1];
        for(int i = 0; i < N; i++){
            p[i] = sc.nextInt();
            if(p[i] == i+1)
                a[i] = 1;
        }
        sc.close();
        int i = 0;
        int ans = 0;
        while(i < N){
            if(a[i] == 1){
                int count = 0;
                while(a[i] == 1){
                    count++;
                    i++;
                }
                ans += (count+1)/2;
            }
            i++;
        }
        System.out.println(ans);
    }
}