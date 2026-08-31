
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class competetive  {
    static class pair implements Comparable<pair>{
        long f;
        int s;
        pair(long a,int b){
            this.f=a;
            this.s=b;
        }
        long getF(){
            return f;
        }
        int getS(){
            return s;
        }
        public int compareTo(pair p){
            if(this.f==p.f){
                return p.s-this.s;
            }
            return (int)(this.f-p.f);
        }
    }
    static class pair2 implements Comparable<pair2>{
        long f;
        int s;
        pair2(long a,int b){
            this.f=a;
            this.s=b;
        }
        long getF2(){
            return f;
        }
        int getS2(){
            return s;
        }
        public int compareTo(pair2 p){
            return this.s-p.s;
        }
    }
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(java.io.FileDescriptor.out), "ASCII"), 512);
        int n=Integer.parseInt(br.readLine());
        String line=br.readLine();
        String []s=line.trim().split(" ");

        ArrayList<pair>pl=new ArrayList<>();
        for(int i=0;i<n;i++){
            pl.add(new pair(Long.parseLong(s[i]),i));
        }
        int m=Integer.parseInt(br.readLine());
        Collections.sort(pl);
        ArrayList<ArrayList<pair2>>l=new ArrayList<>();
        for(int i=0;i<101;i++){
            l.add(i,new ArrayList<>());
        }
        for(int i=1;i<101;i++){
            if(n-i==-1)break;
            for(int j=n-i;j<n;j++){
                l.get(i).add(new pair2(pl.get(j).getF(),pl.get(j).getS()));
            }
            Collections.sort(l.get(i));
        }
        for(int i=0;i<m;i++){
            String query=br.readLine();
            String[]q=query.trim().split(" ");
            int k=Integer.parseInt(q[0]);
            int pos=Integer.parseInt(q[1]);
            out.write(String.valueOf(l.get(k).get(pos-1).getF2()));
            out.newLine();
        }
        out.flush();
    }
}
