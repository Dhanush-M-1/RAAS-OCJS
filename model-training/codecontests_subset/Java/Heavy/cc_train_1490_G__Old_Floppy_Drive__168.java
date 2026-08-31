// package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;
//****Use Integer Wrapper Class for Arrays.sort()****
public class HL5 {
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] Args)throws Exception{
        FastReader scan=new FastReader(System.in);
        int t=1;
        t=scan.nextInt();
        while(t-->0){
            int n=scan.nextInt();
            int m=scan.nextInt();
            int[] arr=new int[n];
            long sum=0;
            long max=Integer.MIN_VALUE;
            long[] ans=new long[m];
            for(int i=0;i<n;i++){
                arr[i]=scan.nextInt();
                sum+=arr[i];
                max=Math.max(sum,max);
            }
            pair[] qs=new pair[m];
            for(int i=0;i<m;i++){
                qs[i]=new pair(i,scan.nextInt());
            }
            Arrays.sort(qs);
            long val=0;
            int s=0;
            for(int i=0;i<n;i++){
                val+=arr[i];
                int l=s;
                int r=m-1;
                int in=-1;
                while(l<=r){
                    int mid=(l+r)/2;
                    if(qs[mid].x<=val){
                        in=mid;
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
                if(in!=-1){
                    for(int j=s;j<=in;j++){
                        ans[qs[j].in]=i;
                    }
                    s=in+1;
                }
            }
            ArrayList<pair> ar=new ArrayList<>();
            for(int i=s;i<m;i++){
                if(sum<=0){
                    ans[qs[i].in]=-1;
                }else{
                    long req=(qs[i].x-max)/sum;
                    if((qs[i].x-max)%sum!=0){
                        req++;
                    }
                    qs[i].x-=sum*req;
                    ans[qs[i].in]=req*n-1;
                    ar.add(new pair(qs[i].in,qs[i].x));
                }
            }
            Collections.sort(ar);
            val=0;
            s=0;
            for(int i=0;i<n;i++){
                val+=arr[i];
                int l=s;
                int r=ar.size()-1;
                int in=-1;
                while(l<=r){
                    int mid=(l+r)/2;
                    if(ar.get(mid).x<=val){
                        in=mid;
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
                if(in!=-1){
                    for(int j=s;j<=in;j++){
                        ans[ar.get(j).in]+=(i+1);
                    }
                    s=in+1;
                }
            }
            for(int i=0;i<m;i++){
                out.print(ans[i]+" ");
            }
            out.println();
        }
        out.flush();
        out.close();
    }
    static class pair implements Comparable<pair>{
        int in;
        int x;
        pair(int in,int x){
            this.in=in;
            this.x=x;
        }

        @Override
        public int compareTo(pair o) {
            return this.x-o.x;
        }
    }
    static class FastReader {

        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) {
            in = is;
        }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }
    }
}
