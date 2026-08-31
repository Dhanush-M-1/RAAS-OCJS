import java.util.*;
 
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        int[] c = new int[M];
        int[] d = new int[M];
        int min = 0;
        int[] num = new int[N];
        
        for(int i=0; i<N; i++){
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for(int i=0; i<M; i++){
            c[i] = sc.nextInt();
            d[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                int l = (int)Math.abs(a[i]-c[j])+(int)Math.abs(b[i]-d[j]);
                if(j==0){
                    min = l;
                    num[i] = j+1;
                }
                if(min > l){
                    min = l;
                    num[i] = j+1;
                }
            }
        }
        for(int i=0; i<N; i++){
            System.out.println(num[i]);
        }
    }
}