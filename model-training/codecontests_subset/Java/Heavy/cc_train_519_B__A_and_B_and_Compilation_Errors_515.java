
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author VMCUONG
 */
public class Problem519B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int b[] = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            b[i] = sc.nextInt();
        }
        Arrays.sort(b);
        for (int i = 0; i < n; i++) {
            if(i==n-1){
                System.out.println(a[n-1]);
                break;
            }
            if(b[i] != a[i]){
                System.out.println(a[i]);
                break;
            }
        }
        
        int c[] = new int[n-2];
        for (int i = 0; i < n-2; i++) {
            c[i] = sc.nextInt();
        }
        Arrays.sort(c);
        for (int i = 0; i < n-1; i++) {
            if(i==n-2){
                System.out.println(b[n-2]);
                break;
            }
            if(c[i] != b[i]){
                System.out.println(b[i]);
                break;
            }
        }
        
    }
}
