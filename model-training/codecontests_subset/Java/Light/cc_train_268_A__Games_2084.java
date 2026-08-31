import java.util.Scanner;

public class A {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] h = new int[n];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
            a[i] = in.nextInt();
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (h[i] == a[j]) {
                    count++;
                }
            }
        }
            System.out.println(count);
    }//main Method
}//A Class