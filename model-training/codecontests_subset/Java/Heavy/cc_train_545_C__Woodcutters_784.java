import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.lang.StringBuilder;
import java.lang.Math;
import java.util.HashMap;
import java.util.Arrays;
public class Main{
public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine()); int sum = 1;
    StringTokenizer st = new StringTokenizer(br.readLine());
    int x0 = Integer.parseInt(st.nextToken());
    int h0 = Integer.parseInt(st.nextToken());
    for(int i=1; i<n; i++){
        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int h1 = Integer.parseInt(st.nextToken());
        if(x0>=x1){sum--;x0=x0-h0;}
        if(x1-h1>x0)sum++;
        else {x1=x1+h1;sum++;}
        x0=x1;
        h0=h1;
    }
    System.out.print(sum);
    }
}