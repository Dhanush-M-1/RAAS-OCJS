import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Meeting_with_friends {
    public static void main(String[] args) throws IOException{
        int x1, x2;
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        x1 = Integer.parseInt(buf.readLine());
        x2 = Integer.parseInt(buf.readLine());
        int len;
        if(x1 < x2){
        len = x2 - x1;}
        else{
            len = x1 - x2;
        }
        int tiredness = 0;
        x1 = len / 2;
        for(int i = 1; i <= x1; i++){
            tiredness += i;
        }
        if(len % 2 == 0){
            x2 = 0;
        }else {
            x2 = len / 2 + 1;
        }
        tiredness = tiredness * 2 + x2;

        System.out.println(tiredness);
    }
}