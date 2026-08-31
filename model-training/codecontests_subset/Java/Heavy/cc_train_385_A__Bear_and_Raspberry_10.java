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
		int n=ut.ri();
		int k=ut.ri();
		int[] cost=ut.parse_int_line();

		int ans=-1;
		for(int i=0;i<n-1;i++){
			ans=Math.max(ans,cost[i]-cost[i+1]-k);
		}
		if(ans>=0) out.write(String.format("%d\n",ans));
		else out.write("0\n");
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
    public void print(Object o){
        System.out.println(o);
    }
}
