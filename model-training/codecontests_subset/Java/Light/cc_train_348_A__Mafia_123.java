import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            String str[] = br.readLine().split(" ");
            // int a[]=new int [n];
            double sum = 0;
            int max = -1;
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(str[i]);
                if (max < Integer.parseInt(str[i]))
                    max = Integer.parseInt(str[i]);
            }
            if ((int) Math.ceil(sum / (n - 1)) < max)
                System.out.println(max);
            else
                System.out.println((int) Math.ceil(sum / (n - 1)));
            br.close();
        } catch (NumberFormatException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
