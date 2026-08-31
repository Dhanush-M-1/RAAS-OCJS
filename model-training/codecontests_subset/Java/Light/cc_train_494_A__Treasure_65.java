import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int[] A = new int[line.length()];
        if (line.charAt(0) != '(') {
            System.out.println(-1);
            return;
        }
        A[0] = 1;
        for (int i = 1; i < line.length(); i++) {
            int k = (line.charAt(i) == '(') ? 1 : -1;
            A[i] = A[i-1] + k;
            if (A[i] < 0) {
                System.out.println(-1);
                return;
            }
        }
        int last = line.length()-1;
        while (line.charAt(last) != '#') {
            last--;
        }
        
        if (A[line.length()-1] > A[last]) {
            System.out.print(-1);
            return;
        }
        int lastVal = 1 + A[line.length()-1];
        for (int i = last+1; i < line.length(); i++) {
            if (A[i] - lastVal + 1 < 0) {
                System.out.println(-1);
                return;
            }
        }
        for (int i = 0; i < last; i++) {
            if (line.charAt(i) == '#') {
                System.out.println(1);
            }
        }
        System.out.println(lastVal);
    }
}
