
import java.util.Scanner;

/**
 * Created by sd on 2016/11/22.
 */
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];
        for(int I=0;I<N;I++){
            a[I] = sc.nextInt();
        }

        int count = 0;
        for(int i=0; i<N; i++){
            int minj = i;
            for(int j=i; j<N; j++){
                if(a[j] < a[minj]){
                    minj = j;
                }
            }
            if(i != minj){
                count ++;
            }
            int t = a[i];
            a[i] = a[minj];
            a[minj] = t;
        }
        for(int ii=0; ii<N-1; ii++){
            System.out.print(a[ii]+" ");
        }
        System.out.println(a[N-1]);
        System.out.println(count);
    }
}