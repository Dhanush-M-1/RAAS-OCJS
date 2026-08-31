import java.util.Scanner;

/**
 * Created by teacher on 27.11.2017.
 */
public class TaskA {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), waiter = 3;
        int [] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            if(a[i] == waiter){
                System.out.println("NO"); return;
            }
            if(a[i] == 1 && waiter == 3) {
                waiter = 2; continue;
            }
            if(a[i] == 2 && waiter == 3) {
                waiter = 1; continue;
            }
            if(a[i] == 1 && waiter == 2){
                waiter = 3; continue;
            }
            if(a[i] == 2 && waiter == 1){
                waiter = 3; continue;
            }
            if(a[i]==3 && waiter == 2) {
                waiter = 1; continue;
            }
            if(a[i]==3 && waiter ==1) {
                waiter = 2;
            }
        }
        System.out.println("YES");
    }
}