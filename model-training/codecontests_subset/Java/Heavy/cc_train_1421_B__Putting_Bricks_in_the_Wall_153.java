// package com.company;
import java.util.*;
import java.lang.*;
import java.io.*;
//****Use Integer Wrapper Class for Arrays.sort()****
public class FR2 {
    static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
    public static void main(String[] Args)throws Exception{
        FastReader scan=new FastReader(System.in);
        int t=1;
        t=scan.nextInt();
        while(t-->0){
            int n=scan.nextInt();
            StringBuilder[] grid=new StringBuilder[n];
            for(int i=0;i<n;i++){
                grid[i]=new StringBuilder(scan.next());
            }
            char o1=grid[0].charAt(1);
            char o2=grid[1].charAt(0);
            char o3=grid[n-2].charAt(n-1);
            char o4=grid[n-1].charAt(n-2);
            ArrayList<Pair> ans=new ArrayList<>();
            if(o1==o2){
                if(o3==o1){
                    ans.add(new Pair(n-1,n));
                }
                if(o4==o1){
                    ans.add(new Pair(n,n-1));
                }
            }
            else if(o3==o4){
                if(o3==o1){
                    ans.add(new Pair(1,2));
                }
                if(o3==o2){
                    ans.add(new Pair(2,1));
                }
            }
            else{
                if(o1=='1'){
                    ans.add(new Pair(1,2));
                }else{
                    ans.add(new Pair(2,1));
                }
                if(o3=='0'){
                    ans.add(new Pair(n-1,n));
                }else{
                    ans.add(new Pair(n,n-1));
                }
            }
            out.println(ans.size());
            for(Pair p:ans){
                out.println(p.x+" "+p.y);
            }
        }
        out.flush();
        out.close();
    }
    static ret pos(StringBuilder[] grid,int r,int c){
        int n=grid.length;
        Queue<Pair> q=new LinkedList<>();
        boolean[][] vis=new boolean[n][n];
        ((LinkedList<Pair>) q).add(new Pair(r,c));
        vis[r][c]=true;
        while(q.size()>0){
            Pair cur=q.remove();
            int x=cur.x;
            int y=cur.y;
            char ch=grid[x].charAt(y);
            if(x<n-1&&!vis[x+1][y]&&(grid[x+1].charAt(y)=='F'||grid[x+1].charAt(y)==ch||ch=='S')){
                vis[x+1][y]=true;
                ((LinkedList<Pair>) q).add(new Pair(x+1,y));
            }
            if(y<n-1&&!vis[x][y+1]&&(grid[x].charAt(y+1)=='F'||grid[x].charAt(y+1)==ch||ch=='S')){
                vis[x][y+1]=true;
                ((LinkedList<Pair>) q).add(new Pair(x,y+1));
            }
        }
        return new ret(vis[n-1][n-2],vis[n-2][n-1]);
    }
    static class Pair{
        int x;
        int y;
        Pair(int x,int y) {
            this.x = x;
            this.y = y;
        }
    }static class ret{
        boolean x;
        boolean y;
        ret(boolean x,boolean y) {
            this.x = x;
            this.y = y;
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
