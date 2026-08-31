import java.io.*;
import java.util.*;
public class Ex {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s=br.readLine().split(" ");
        int k=Integer.parseInt(s[0]);
        int r=Integer.parseInt(s[1]);
        int sum=0;
        sum=sum+k;
        int c=1;
        while(c>0){
             c=k/r;
            k=c+(k%r);
            sum=sum+c;
        if(k<r){
            break;
        }
        }
        bw.write(sum+"\n");
    bw.flush();
    }
}

