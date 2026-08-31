import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/**
 *
 * @author msagimbekov
 */
public class Codeforces938B {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] a = new int[n];
        String[] inp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(inp[i]);
        }
        
        Arrays.sort(a);
        int left = 1;
        int right = 1000000;
        int x = 0;
        int y = n - 1;
        
        int cnt = 0;
        int res = 0;
        for (int i = 0; i < 1000000; i++) {
            left++;
            right--;
            if (left == a[x]) {
                cnt++;
                x++;
            }
            if (right == a[y]) {
                cnt++;
                y--;
            }
            if (cnt == n) {
                res = i + 1;
                break;
            }
        }
        
        bw.write(res + "\n");
        
        bw.flush();
        bw.close();
        br.close();
    }

}

