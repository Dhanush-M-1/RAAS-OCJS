// package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;
//****Use Integer Wrapper Class for Arrays.sort()****
public class DR5 {
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] Args)throws Exception{
        FastReader scan=new FastReader(System.in);
        int t=1;
//        t=scan.nextInt();
        while(t-->0){
            int n=scan.nextInt();
            int k=scan.nextInt();
            book[] arr=new book[n];
            int al=0;
            int bl=0;
            for(int i=0;i<n;i++){
                int ti=scan.nextInt();
                int a=scan.nextInt();
                int b=scan.nextInt();
                if(a==1){
                    al+=1;
                }if(b==1){
                    bl+=1;
                }
                arr[i]=new book(ti,a,b);
            }
            if(al<k||bl<k){
                out.println(-1);
            }else{
                Arrays.sort(arr);
                ArrayList<Integer> oal=new ArrayList<>();
                ArrayList<Integer> obl=new ArrayList<>();
                ArrayList<Integer> abl=new ArrayList<>();
                for(int i=0;i<n;i++){
                    book cur=arr[i];
                    if(cur.a==1&&cur.b==1){
                        abl.add(i);
                    }else{
                        if(cur.a==1){
                            oal.add(i);
                        }if(cur.b==1){
                            obl.add(i);
                        }
                    }
                }
                int ap=0;
                int bp=0;
                int cp=0;
                int an=k-Math.min(k,oal.size());
                int bn=k-Math.min(k,obl.size());
                cp=Math.max(an,bn);
                long ans=0;
                for(int i=0;i<cp;i++){
                    ans+=arr[abl.get(i)].t;
                    k--;
                }
                while(k>0){
                    long at=arr[oal.get(ap)].t;
                    long bt=arr[obl.get(bp)].t;
                    long ct=Integer.MAX_VALUE;
                    if(cp<abl.size()){
                        ct=arr[abl.get(cp)].t;
                    }
                    if(at+bt<=ct){
                        ans+=at+bt;
                        ap++;
                        bp++;
                    }else{
                        ans+=ct;
                        cp++;
                    }
                    k--;
                }
                out.println(ans);
            }
        }
        out.flush();
        out.close();
    }
    static class book implements Comparable<book>{
        int t;
        int a;
        int b;
        book(int t,int a,int b){
            this.t=t;
            this.a=a;
            this.b=b;
        }

        @Override
        public int compareTo(book o) {
            return this.t-o.t;
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
