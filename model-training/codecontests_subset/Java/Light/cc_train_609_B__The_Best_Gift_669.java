import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try {
            String []line = br.readLine().split("\\s+");
            int n = Integer.parseInt(line[0]);
            int m = Integer.parseInt(line[1]);
            line = br.readLine().split("\\s+");
            int []a = new int[m + 1];

            for (int i = 0 ; i < n ; i ++) {
                a[Integer.parseInt(line[i])] ++ ;
            }
            int output = 0;

            for (int i = 1 ; i < m ; i ++) {
                for (int j = i + 1 ; j <= m ; j ++) {
                    output = output + a[i] * a[j];
                }
            }

            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
