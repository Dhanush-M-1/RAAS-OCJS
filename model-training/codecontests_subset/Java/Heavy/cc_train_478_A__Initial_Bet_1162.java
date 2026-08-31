
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum=0;
            StringTokenizer st=new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
            sum+=Integer.parseInt(st.nextToken());
            }
            if(sum==0){
                System.out.println("-1");
            }
            else if(sum%5 ==0){
                System.out.println(sum/5);
            }
            else{
                System.out.println("-1");
            }
    }
}