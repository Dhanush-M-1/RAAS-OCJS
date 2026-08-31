import java.util.Scanner;

/**
 * Created by xf on 2017/9/4.
 */
public class Main {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];
        int[] a = new int[n];
        int num = 0;
        for (int i=0;i<n;i++){
            h[i] = scanner.nextInt();
            a[i] = scanner.nextInt();
        }
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if (i != j){
                    if (h[i] == a[j]){
                        num++;
                    }
                }
            }
        }
        System.out.print(num);
    }
}
