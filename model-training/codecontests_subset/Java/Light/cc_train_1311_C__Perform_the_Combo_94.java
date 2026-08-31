import java.io.*;

public class Solution {
    public static void main(String []args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int not = Integer.parseInt(br.readLine());
        while (not--!=0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            char str[] = br.readLine().toCharArray();
            input = br.readLine().split(" ");
            int arr[][] = new int[n][26];
            int c[] = new int[26];
            for(int i = 0; i < n; i++) {
                c[str[i] - 'a']++;
                for(int j = 0; j < 26; j++) {
                    arr[i][j] = c[j];
                }
            }
            c = new int[26];
            for(String s : input) {
                int x = Integer.parseInt(s) - 1;
                for(int i = 0; i < 26; i++) {
                    c[i] += arr[x][i];
                }
            }
            for(int i = 0; i < 26; i++) {
                c[i] += arr[n - 1][i];
            }
            StringBuilder sb = new StringBuilder();
            for (int i : c) sb.append(i+" ");
            System.out.println(sb);
        }
    }
}