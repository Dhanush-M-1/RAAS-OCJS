import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class ProbA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String str = br.readLine();
            String nums[]= str.split(" ");
            if (Integer.parseInt(nums[0])+Integer.parseInt(nums[1]) > Integer.parseInt(nums[N-1])) {
                System.out.println("-1");
            } else {
                System.out.println("1 2 " + N);
            }
        }
    }
}
