import java.io.*;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        long a[] = Arrays.asList(br.readLine().split(" ")).stream().mapToLong(Long::parseLong).toArray();
//        int a[] = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
        int n = Integer.parseInt(br.readLine().trim());
        int a[] = new int[n], b[] = new int[n], i = 0, c[][] = new int[n][n];
        while (n-- > 0){
            String arr[] = br.readLine().trim().split(" ");
            a[i] = Integer.parseInt(arr[0]);
            b[i] = Integer.parseInt(arr[1]);
            i++;
        }
        int count = 0;
        for (int j = 0; j < a.length; j++) {
            for (int k = 0; k < b.length; k++) {
                if(k != j && c[j][k] == 0 && a[j] == b[k]){
                    c[j][k] = 1;
                    count++;
                }
            }
        }
        System.out.println(count);
    }

}
