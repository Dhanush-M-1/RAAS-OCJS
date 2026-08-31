import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CF_A_GoodBye2013 {

    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(bf.readLine());
        int a=Integer.parseInt(st.nextToken());
        int b=Integer.parseInt(st.nextToken());
        int result=a;
        while(a>=b){
            result+=a/b;
            int mod=a%b;
            a /=b;
            a+=mod;
        }
        System.out.println(result);
        
    }
}
