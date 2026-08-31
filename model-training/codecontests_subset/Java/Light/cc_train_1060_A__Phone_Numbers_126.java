import java.io.*;
import java.util.*;

public class solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = br.readLine();
        int count8 = 0;
        int v = n/11;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '8')count8++;
        }
        int ans = Math.min(count8,v);
        System.out.println(ans);
    }
}