import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        int h[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
            h[i] = scan.nextInt();
        }
        int s = 0;
        if(n!=0){
            s++;
        }
        for (int i = 1; i < h.length; i++) {
            if(i == h.length-1)
                s++;
            else if(a[i] - h[i] > a[i-1]){
                s++;
            }
            else if(a[i] + h[i] < a[i+1]){
                s++;
                a[i] = a[i] + h[i];
            }
        }
        System.out.println(s);
    }
}
