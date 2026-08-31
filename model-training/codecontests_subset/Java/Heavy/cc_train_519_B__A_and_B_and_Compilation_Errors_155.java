import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A_B_compilation_Errors {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[][] arrays = new String[3][n];
        for (int i = 0; i < 3; i++) {
            arrays[i] = br.readLine().split(" ");
            Arrays.sort(arrays[i]);

        }

        findMissing(arrays[0], arrays[1], n);
        findMissing(arrays[1], arrays[2], n - 1);
    }

    private static void findMissing(String[] a, String[] b, int n) {
        for (int i = 0; i < n - 1; i++) {
            if (a[i] == null ? b[i] != null : !a[i].equals(b[i])) {
                System.out.println(a[i]);
                break;
            }
            if (i == n - 2) {
                System.out.println(a[i + 1]);
            }
        }
    }
}