import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Test {

    public static void main(String args[]) throws IOException {
        int ans = 0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int su=0;
        while(( s = reader.readLine())!=null){
            if(s.charAt(0)=='+')
                su++;
            else if(s.charAt(0)=='-')
                su--;
            else{
                String msg[] = s.split(":",2);
                if(msg.length==2)
                ans=ans+su*msg[1].length();
            }
        }
        System.out.println(ans);
    }
}
