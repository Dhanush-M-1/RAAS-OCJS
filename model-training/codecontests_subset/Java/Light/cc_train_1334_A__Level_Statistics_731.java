// package EducationalRound85;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ProblemA {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        StringBuilder print=new StringBuilder();
        while(test--!=0){
            int prevp=0,prevc=0;
            int n=Integer.parseInt(br.readLine());
            boolean flag=true;
            for(int i=1;i<=n;i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int p=Integer.parseInt(st.nextToken());
                int c=Integer.parseInt(st.nextToken());
                int incp=p-prevp;
                int incc=c-prevc;
                if(incc>incp||incc<0||incp<0){
                    flag=false;
                }
                prevp=p;
                prevc=c;
            }
            if(flag){
                print.append("yes\n");
            }
            else{
                print.append("no\n");
            }
        }
        System.out.print(print.toString());
    }
}
