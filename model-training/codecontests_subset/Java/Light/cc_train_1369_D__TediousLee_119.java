// package Quarantine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TediousLee {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int test=Integer.parseInt(br.readLine());
        StringBuilder print=new StringBuilder();
        int mod=1000000007;
        long ans[]=new long[2000001];
        for(int i=3;i<=2000000;i++){
            ans[i]=(ans[i-1]+2*ans[i-2])%mod;
            if(i%3==0){
                ans[i]=(ans[i]+4)%mod;
            }
        }
        while(test--!=0){
            int n=Integer.parseInt(br.readLine());
            print.append(ans[n]+"\n");
        }
        System.out.println(print.toString());
    }
}
