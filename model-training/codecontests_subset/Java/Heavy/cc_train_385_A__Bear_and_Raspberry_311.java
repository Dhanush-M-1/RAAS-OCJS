import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BearAndRaspberry {

    public static void main(String [] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
    
        st = new StringTokenizer(br.readLine());
        
        int x = Integer.parseInt(st.nextToken());
        int ans = 0;
        
        for(int i = 1; i<n; i++)
        {
            int tmp = Integer.parseInt(st.nextToken());
            ans = Math.max(ans, x-tmp-c);
            x = tmp;
        }
        
        bw.write(Integer.toString(ans));
        bw.flush();
    }
    
}
