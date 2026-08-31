import java.io.*;
import java.util.*;
import java.lang.*;

public class Rextester{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int a=0,b=0,c=0,d=0;
            for(int i=0;i<n;i++){
                String s = br.readLine();
                if(i==0){
                    a = s.charAt(1)-'0';
                }
                if(i==1){
                    b = s.charAt(0)-'0';
                }
                if(i==n-2){
                    c = s.charAt(n-1)-'0';
                }
                if(i==n-1){
                    d = s.charAt(n-2)-'0';
                }
            }
            //System.out.println(a +" "+b+" "+c+" "+d);
            if((a^b)==0 && (c^d)==0){
                if((a==1 && c==0)||(a==0 && c==1)){
                    sb.append("0\n");
                    continue;
                }
                else{
                    sb.append("2\n");
                    sb.append("1 2\n");
                    sb.append("2 1\n");
                }
            }
            else if((a^b)==1 && (c^d)==1){
                if(a==c && b==d){
                    sb.append("2\n1 2\n"+(n)+" "+(n-1)+"\n");
                }
                else {
                    sb.append("2\n2 1\n"+(n)+" "+(n-1)+"\n");
                }
            }
            else if((a^b)==1 && (c^d)==0){
                if(a==c){
                    sb.append("1\n1 2\n");
                }
                else if(b==c){
                    sb.append("1\n2 1\n");
                }
            }
            else if((a^b)==0 && (c^d)==1){
                if(a==c){
                    sb.append("1\n"+(n-1)+" "+n+"\n");
                }
                else if(a==d){
                    sb.append("1\n"+(n)+" "+(n-1)+"\n");
                }
            }
        }
        br.close();
        System.out.println(sb);
    }
}