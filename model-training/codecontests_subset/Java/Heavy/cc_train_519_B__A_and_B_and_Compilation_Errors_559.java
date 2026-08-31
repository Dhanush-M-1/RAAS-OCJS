import java.util.*;

public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        int[] b = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            b[i] = scanner.nextInt();
        }
        Arrays.sort(b);
        int[] c = new int[n-2];
        for (int i = 0; i < n-2; i++) {
            c[i] = scanner.nextInt();
        }
        Arrays.sort(c);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i]+" ");
//        }
//        System.out.println();
//        for (int i = 0; i < b.length; i++) {
//            System.out.print(b[i]+" ");
//        }
//        System.out.println();
//        for (int i = 0; i < c.length; i++) {
//            System.out.print(c[i]+" ");
//        }
        System.out.println();
        result(a,b,c);

    }

    private static void result(int[] a, int[] b, int[] c) {
        for (int i = 0; i < b.length; i++) {
            if (a[i]!=b[i]){
                System.out.println(a[i]);
                break;
            }
            if (i==b.length-1){
                System.out.println(a[i+1]);
            }
        }
        for (int i = 0; i < c.length; i++) {
            if (b[i]!=c[i]){
                System.out.println(b[i]);
                break;
            }
            if (i==c.length-1){
                System.out.println(b[i+1]);
            }
        }
    }

}
