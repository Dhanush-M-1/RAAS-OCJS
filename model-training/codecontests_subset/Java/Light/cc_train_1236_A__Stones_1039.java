import java.util.*;
import java.io.*;
 
public class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q=Integer.parseInt(br.readLine());
        while(q-->0){
            String line=br.readLine();
            String[] str=line.trim().split(" ");
            int a=Integer.parseInt(str[0]);
            int b=Integer.parseInt(str[1]);
            int c=Integer.parseInt(str[2]);
            int ans=0;
            while(b>=1&&c>=2){
                ans+=3;
                b=b-1;
                c=c-2;
            }
            while(a>=1&&b>=2){
                ans+=3;
                b=b-2;
                a=a-1;
            }
            if(b!=0){
                while(b>=1&&c>=2){
                ans+=3;
                b=b-1;
                c=c-2;
            }
            }
            System.out.println(ans);
        }
    }
}