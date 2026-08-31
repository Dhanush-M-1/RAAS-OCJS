import java.util.Scanner;

public class B519 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] A = new int [n];
        int [] B = new int [n - 1];
        int [] C = new int [n - 2];

        int AA = 0,BB = 0,CC = 0;

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            AA = AA + A[i];
        }

        for (int i = 0; i < n - 1; i++) {
            B[i] = sc.nextInt();
            BB = BB + B[i];
        }

        for (int i = 0; i < n - 2; i++) {
            C[i] = sc.nextInt();
            CC = CC + C[i];
        }

        int LostOne = AA - BB;

        int LostTwo = BB - CC;



        System.out.println(LostOne + "\n" + LostTwo);

    }
}
