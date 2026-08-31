import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
public class First{
	public static void main(String[] args) throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    int t = Integer.parseInt(br.readLine());
		    StringBuilder sb = new StringBuilder();
		    while(t-->0){
		        int ans = 0;
		        int[]a = Pattern.compile(" ").splitAsStream(br.readLine()).mapToInt(Integer::parseInt).toArray();
		        if(a[1]>a[2]/2){
		            ans+=3*(a[2]/2);
		            a[1]-=a[2]/2;
		        } else {
		            ans+=a[1]*3;
		            a[1]=0;
		        }
		        ans+= a[0] > a[1]/2 ? 3*(a[1]/2) : a[0]*3;
		        sb.append(ans).append("\n");
		    }
		    System.out.println(sb.toString());
	}
   
}