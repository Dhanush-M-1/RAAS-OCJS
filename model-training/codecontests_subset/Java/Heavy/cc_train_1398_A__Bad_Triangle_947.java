import java.util.Scanner;


public class Ex53 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t>0){
            int n = s.nextInt();
            int [] a = new int[n];
            for(int i=0; i<n; i++){
                a[i] = s.nextInt();
            }
            int min1= a[0];
            int min2= a[1];
            int max = a[n-1];
            if(min1+min2 <= max) {
                for (int i = 0; i < n; i++) {
                    if (a[i] == min1) {
                        a[i] = -1;
                        System.out.print(i + 1 + " ");
                        break;
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (a[i] == min2) {
                        System.out.print(i + 1 + " ");
                        break;
                    }
                }
                for (int i = 0; i < n; i++) {
                    if (a[i] == max) {
                        System.out.print(i + 1 + " ");
                        break;
                    }
                }
                System.out.println();
            }
            else {
                System.out.println(-1);
            }
            t -= 1;
        }
    }
}
