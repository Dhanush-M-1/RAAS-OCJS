import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        Solution sol=new Solution(in,out);
        out.flush();
        //in.close();
        //out.close();
    }
}

class Solution {
    public Solution(BufferedReader in, BufferedWriter out) throws Exception {
        Utils ut=new Utils(in);

        final int inf=1000000000;
        int n=ut.ri();
        int m=ut.ri();
        int[] upper=new int[n];
        int[] ans=new int[n];
        int[] disp=new int[n];
        int[][] mem=new int[m][4];

        for(int i=0;i<n;i++) upper[i]=inf;

        for(int ii=0;ii<m;ii++){
            int[] line=ut.parse_int_line();
            for(int i=0;i<4;i++){
                mem[ii][i]=line[i];
            }
            if(line[0]==1){
                int a=line[1]-1;
                int b=line[2]-1;
                int d=line[3];
                for(int i=a;i<=b;i++) disp[i]+=d;
            }
            else{
                int a=line[1]-1;
                int b=line[2]-1;
                int mx=line[3];

                for(int i=a;i<=b;i++){
                    upper[i]=Math.min(upper[i],mx-disp[i]);
                }
            }
        }

        for(int i=0;i<n;i++) ans[i]=upper[i];
        // now verify
        boolean ok=true;
        for(int ii=0;ii<m;ii++){
            if(mem[ii][0]==1){
                for(int i=mem[ii][1]-1;i<mem[ii][2];i++){
                    upper[i]+=mem[ii][3];
                }
            }
            else{
                int maxm=-2*inf;
                for(int i=mem[ii][1]-1;i<mem[ii][2];i++){
                    maxm=Math.max(maxm,upper[i]);
                }
                if(maxm!=mem[ii][3]) ok=false;
            }
        }
        if(!ok) out.write("NO\n");
        else{
            out.write("YES\n");
            for(int i=0;i<n;i++) out.write(String.format("%d ",ans[i]));
            out.write("\n");
        }
    }
}

class Utils {
    BufferedReader in;
    StringTokenizer st=null;

    public Utils(BufferedReader in1) {in=in1;}
    public void fill_array(char[] arr,String line){
        for(int i=0;i<line.length();i++) arr[i]=line.charAt(i);
    }
    public int[] parse_int_line() throws Exception {
        String line=in.readLine();
        int sz=1,ptr=0;
        for(int i=0;i<line.length();i++) if(line.charAt(i)==' ') sz++;
        int[] ret=new int[sz];
        StringTokenizer st=new StringTokenizer(line);
        while(st.hasMoreTokens()) ret[ptr++]=Integer.parseInt(st.nextToken());
        return ret;
    }
    public long[] parse_long_line() throws Exception {
        String line=in.readLine();
        int sz=1,ptr=0;
        for(int i=0;i<line.length();i++) if(line.charAt(i)==' ') sz++;
        long[] ret=new long[sz];
        StringTokenizer st=new StringTokenizer(line);
        while(st.hasMoreTokens()) ret[ptr++]=Long.parseLong(st.nextToken());
        return ret;
    }
    public String r() throws Exception {
        while(st==null || !(st.hasMoreTokens())){
            st=new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }
    public int ri() throws Exception {
        while(st==null || !(st.hasMoreTokens())){
            st=new StringTokenizer(in.readLine());
        }
        return Integer.parseInt(st.nextToken());
    }
    public long rl() throws Exception {
        while(st==null || !(st.hasMoreTokens())){
            st=new StringTokenizer(in.readLine());
        }
        return Long.parseLong(st.nextToken());
    }
    public double rd() throws Exception {
        while(st==null || !(st.hasMoreTokens())){
            st=new StringTokenizer(in.readLine());
        }
        return Double.parseDouble(st.nextToken());
    }
}
