
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1024 * 1024 * 2);

        int n = Integer.valueOf(br.readLine());
        char[] line = br.readLine().toCharArray();

        int minLeft[] = new int[n];
        minLeft[n-1] = n -1;
        for (int i = n -2 ; i >= 0 ;  i--) {
            if (line[i] <= line[minLeft[ i + 1]]) {
                minLeft[i] = i;
            } else {
                System.out.println("YES");
                System.out.println((i + 1) +" " + (minLeft[i + 1] + 1));
                System.exit(0);
            }
        }
        System.out.println("NO");
    }

    public static int[] readArrayLine(String line, int n) {
        return readArrayLine(line, n, null, 0);
    }

    private static int[] readArrayLine(String line, int n, int array[], int pos) {
        int[] ret = array == null ? new int[n] : array;
        int start = 0;
        int end = line.indexOf(' ', start);
        for (int i = pos; i < pos + n; i++) {
            if (end > 0)
                ret[i] = Integer.parseInt(line.substring(start, end));
            else
                ret[i] = Integer.parseInt(line.substring(start));
            start = end + 1;
            end = line.indexOf(' ', start);
        }
        return ret;
    }
}
