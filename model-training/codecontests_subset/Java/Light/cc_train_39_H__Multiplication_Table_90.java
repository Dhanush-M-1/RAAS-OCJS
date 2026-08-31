import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    static FileReader fin;
    static FileWriter fout;
    static Scanner sc;

    public static void main(String[] args) throws IOException {
        sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(Integer.toString(i * j, n) + " ");
            }
            System.out.print("\n");
        }

        sc.close();
    }
}
