
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Submit {
    static int ans=0;
    public static void main(String args[]) throws IOException{
        process();
    }
    public static void process() throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(in.readLine());
        for(int t=0;t<T;t++){
            ans=0;
            int n=Integer.parseInt(in.readLine());
            boolean flag=true;
            while(true){
                n=six(n);
                if(n==1)
                    break;
                if(n%3!=0){
                    flag=false;
                    break;
                }
                n*=2;
                ans++;
                n=six(n);
            }
            if(flag)
                System.out.println(ans);
            else
                System.out.println("-1");
        }
    }
    public static int six(int n){
        while(n%6==0 && n>1) {
            n /= 6;
            ans++;
        }
        return n;
    }
}
