import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0, time = 0, minij, b = 0;
        size = sc.nextInt();
        int[] a = new int[size];
        for (int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }
        for (int v = 0; v < size; v++) {
            minij = v;
            for (int w = v; w < size; w++) {
                if (a[w] < a[minij]) minij = w;
            }
            if (v != minij) {
                b = a[v];
                a[v] = a[minij];
                a[minij] = b;
                time++;
            }
        }

        for (int k = 0; k < size; k++) {
            System.out.print(a[k]);
            if (k != (size - 1)) System.out.print(" ");
        }
        System.out.print("\n");
        System.out.println(time);


    }
}

