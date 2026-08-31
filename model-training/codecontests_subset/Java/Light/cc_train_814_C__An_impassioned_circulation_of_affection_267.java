import java.util.*;
import java.io.*;
public class CF814C {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader file = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(file.readLine());
        String s = file.readLine();
        int[][] prefix = new int[26][s.length()+1];
        for (int i=0; i<n; i++){
            int curr = s.charAt(i)-'a';
            prefix[curr][i+1]++;
        }
        for (int i=0; i<26; i++){
            for (int j=1; j<=n; j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }
        int[][] best = new int[26][n+1];
        for (int c=0; c<26; c++){
            for (int j=0; j<n; j++){
                for (int k=n-1; k>=j; k--){
                    int size = k-j+1;
                    int already = prefix[c][k+1]-prefix[c][j];
                    best[c][size-already] = Math.max(best[c][size-already], size);
                }
            }
        }
        int q = Integer.parseInt(file.readLine());
        for (int i=0; i<26; i++){
            for (int j=1; j<=n; j++){
                best[i][j] = Math.max(best[i][j], best[i][j-1]);
            }
        }
        for (int i=0; i<q; i++){
            StringTokenizer st = new StringTokenizer(file.readLine());
            int m = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            System.out.println(best[c-'a'][m]);
        }
    }
}