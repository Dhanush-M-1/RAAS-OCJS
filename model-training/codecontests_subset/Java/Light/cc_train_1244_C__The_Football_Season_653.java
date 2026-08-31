// package Quarantine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TheFootBallSeason {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        long n=Long.parseLong(st.nextToken());
        long p=Long.parseLong(st.nextToken());
        int w=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());
        for(int y=0;y<w;y++){
            long t=1l*y*d;
            long rem=p-t;
            if(rem>=0&&rem%w==0){
                long x=rem/w;
                long z=n-x-y;
                if(z>=0) {
                    System.out.println(x + " " + y + " " + z);
                    return;
                }
            }
        }
        System.out.println(-1);
    }
}
