import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io. IOException;
public class Main {

    public static void main(String [] args) throws IOException {
        BufferedReader bf =new BufferedReader (new InputStreamReader (System.in));
        String [] s2=bf.readLine().split(" ");
        int n=Integer.parseInt(s2[0]);
        int x=Integer.parseInt(s2[1]);
        double p=Integer.parseInt(s2[2]);
        double need=n*(p/100);
        double need1=Math.ceil(need);
        int need2=(int)need1;
        if(need2<=x)
            System.out.println(0);
            else
                System.out.println(need2-x);
        
    }
    
    
}