// package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;
//****Use Integer Wrapper Class for Arrays.sort()****
public class CH4 {
    public static void main(String[] Args){
        FastReader scan=new FastReader();
        int t=scan.nextInt();
        StringBuilder fp=new StringBuilder();
        while(t-->0){
            long n=scan.nextInt();
            long l=scan.nextLong();
            long r=scan.nextLong();
            StringBuilder print=new StringBuilder();
            long cur=0;
            boolean lf=false;
            long ib=-1;
            for(long i=1;i<n;i++){
                long tba=(n-i)*2;
                if(cur+tba<l){
                    cur+=tba;
                }else{
//                    System.out.println(i);
                    long fa=l-cur;
                    if(fa%2!=0&&l<=r){
                        print.append(i+" ");
                        fa++;
                        l++;
                    }
                    if(fa%2==0&&l<=r){
                        print.append((i+fa/2)+" ");
                        l++;
                    }
                    long rem=(tba-fa)/2;
                    for(long j=n-rem+1;j<=n&&l<=r;j++){
                        print.append(i+" ");
                        l++;
                        if(l<=r){
                            print.append(j+" ");
                            l++;
                        }
                    }
                    ib=i+1;
                    break;
                }
            }
            if(l<=r){
                for(long i=ib;ib!=-1&&i<n&&l<=r;i++){
                    long j=i+1;
                    while(j<=n){
                        if(l<=r){
                            print.append(i+" ");
                            l++;
                        }
                        if(l<=r){
                            print.append(j+" ");
                            l++;
                        }
                        j++;
                    }
                }
                if(l<=r){
                    print.append(1);
                }
            }
            fp.append(print+"\n");
        }
        System.out.println(fp);
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException  e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }
// 
        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }

}
