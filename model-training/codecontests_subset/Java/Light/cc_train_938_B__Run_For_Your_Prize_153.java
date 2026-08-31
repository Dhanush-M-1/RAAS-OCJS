import java.io.*;
import java.util.StringTokenizer;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()), max=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1 ; i<=n ; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	num = num>500000 ? 1000000-num : num-1;
        	max = num>max? num : max;
        }
        System.out.print(max);
    }
}