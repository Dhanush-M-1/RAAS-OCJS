import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Practice1 {
   public static void main(String[] args) throws Exception {
        FastInput in = new FastInput();
            int t = in.nextInt();
            StringBuilder str = new StringBuilder();

            while(t-->0){
                int m = in.nextInt();
                int n = in.nextInt();
                int a[] = new int[m];
                int b[] = new int[n];
                for(int i = 0;i<m;i++) {
                	a[i] = in.nextInt();
                }
                for(int i = 0;i<n;i++) {
                	b[i] = in.nextInt();
                }
                Arrays.sort(a);
                Arrays.sort(b);
                int i = 0,j=0;
                boolean bol = true;
                while(i<m&&j<n) {
                	if(a[i]==b[j]) {
                		str.append("YES\n1 "+a[i]+"\n");
                		bol = false;
                		break;
                	}else if(a[i]>b[j]) {
                		j++;
                	}else {
                		i++;
                	}
                }
                if(bol) {
                	str.append("NO\n");
                }
            }
            System.out.println(str);
    }

}


class FastInput {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    String next() throws IOException {
        if (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine());
        return st.nextToken();
    }

    Integer nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    Long nextLong() throws IOException {
        return Long.parseLong(next());
    }
}