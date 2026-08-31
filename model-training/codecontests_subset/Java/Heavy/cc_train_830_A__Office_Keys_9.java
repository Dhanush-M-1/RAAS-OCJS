import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sToken = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(sToken.nextToken());
        int k = Integer.parseInt(sToken.nextToken());
        int p = Integer.parseInt(sToken.nextToken());
        int[] people = new int[n];
        sToken = new StringTokenizer(reader.readLine());
        for (int i=0; i<n; i++) people[i] = Integer.parseInt(sToken.nextToken());
        Arrays.sort(people);
        int[] keys = new int[k];
        sToken = new StringTokenizer(reader.readLine());
        for (int i=0; i<k; i++) keys[i] = Integer.parseInt(sToken.nextToken());
        Arrays.sort(keys);
        int[] res = new int[k];
        for (int j=0; j<k; j++) {
            res[j] = Math.abs(people[0] - keys[j]) + Math.abs(keys[j] - p);
            if (j>0) res[j] = Math.min(res[j], res[j-1]);
        }
        for (int i=1; i<n; i++) {
            int x = people[i];
            for (int j=k-1; j>=i; j--) {
                int y = Math.abs(x - keys[j]) + Math.abs(keys[j] - p);
                res[j] = Math.max(res[j-1], y);
            }
            for (int j=i+1; j<k; j++) res[j] = Math.min(res[j], res[j-1]);
        }
        System.out.println(res[k-1]);
    }
}