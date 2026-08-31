import java.io.*;
import java.util.*;
import java.lang.*;

public class Rextester{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = new Integer(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = new Integer(st.nextToken());
            int b = new Integer(st.nextToken());
            int c = new Integer(st.nextToken());
            int x = c/2;
            int result=0;
            if(x<b){
                result = (c/2)*3;
                b-=c/2;
                if(b/2<a){
                    result+=3*(b/2);
                }
                else{
                    result+=3*a;
                }
            }
            else{
                result=3*b;
            }
            sb.append(result).append("\n");
        }
        br.close();
        System.out.println(sb);
    }
}