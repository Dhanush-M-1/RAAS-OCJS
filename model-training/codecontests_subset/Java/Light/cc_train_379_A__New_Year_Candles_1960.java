import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class candles {
    public static void  main(String[]args)throws IOException{
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        String[] input=new String[2];
        input=in.readLine().split(" ");
        int a=Integer.parseInt(input[0]);
        int b=Integer.parseInt(input[1]);
        int sum=a;
        int total=a;
        while (sum>=b){
            int temp=sum/b;
            sum= temp+sum%b;
            total+=temp;
        }
        System.out.println(total);
    }
}
