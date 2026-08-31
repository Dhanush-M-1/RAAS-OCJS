import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

static final InputStream in=System.in;
static final PrintWriter out=new PrintWriter(System.out);
static int[][] dp=new int[100000][3];

public static class Range{
private static int[] lrange=new int[100000];
private static int[] rrange=new int[100000];
public static void change(int n,int x,int y){
if(y<x) return;
lrange[n]=x; rrange[n]=y;
}
public static boolean isInRange(int t,int lx,int rx){
if(lx>rx) return false;
if((lrange[t-1]>rx||rrange[t-1]<lx)&&(lrange[t+1]>rx||rrange[t+1]<lx)) return false;
return true;
}
}

public static void main(String[] args) throws IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(in));
String line="";
StringTokenizer st;
while((line=br.readLine())!=null&&!line.isEmpty()){
int n=Integer.parseInt(line);
int[] x=new int[n];
int[] h=new int[n];
Range r=new Range();
for(int i=0;i<n;i++){
Arrays.fill(dp[i],-1);
st=new StringTokenizer(br.readLine());
x[i]=Integer.parseInt(st.nextToken());
h[i]=Integer.parseInt(st.nextToken());
r.change(i,x[i],x[i]);
}
if(n<=1) out.println(n);
else out.println(dfs(1,0,x,h,r)+2);
}
out.flush();
}

public static int dfs(int now,int cond,final int[] x,final int[] h,Range r){
if(now==x.length-1) return 0;
if(dp[now][cond]>=0) return dp[now][cond];
int cr,cl,cn;
cr=cl=Integer.MIN_VALUE;
int nx=x[now];
int nh=h[now];
if(!r.isInRange(now,nx-nh,nx)){
r.change(now,nx-nh,nx);
cl=dfs(now+1,1,x,h,r)+1;
r.change(now,nx,nx);
}
if(!r.isInRange(now,nx,nx+nh)){
r.change(now,nx,nx+nh);
cr=dfs(now+1,2,x,h,r)+1;
r.change(now,nx,nx);
}
cn=dfs(now+1,0,x,h,r);
return dp[now][cond]=Math.max(Math.max(cr,cl),cn);
}
}