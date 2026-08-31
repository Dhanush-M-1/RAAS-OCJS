import java.util.*;
import java.io.*;
//import java.math.*;

public class Task{
        //  ..............code begins here..............

static long mod=(long)1e9+7,inf=(long)1e17;
static long[] dp;
static void pre(){
    dp=new long[200015];
    long[] d=new long[10];
    long[] d1=new long[10];
    d[0]=1;
    int m=200014;
    for(int i=1;i<=m;i++){
        for(int j=1;j<=9;j++){
            d1[j]=d[j-1];
        }
        d1[0]=d[9];d1[1]+=d[9];
        long res=0;
        for(int j=0;j<=9;j++){
            d[j]=d1[j]%mod;
            res+=d[j];
        }
        dp[i]=res%mod;
    }
}

static void solve() throws IOException {
            int[] x=int_arr();
            int n=x[0],m=x[1],tmp=n;
            int[] d=new int[10];
            while(tmp!=0){
                d[tmp%10]++;tmp/=10;
            }
            long res=0;
            for(int i=0;i<10;i++){
                res+=(long)(dp[m+i]*d[i]);
            }
            res%=mod;
            out.write(res+"\n");
}
//
public static void main(String[] args) throws  IOException{
                assign();
                int t=int_v(read()),cn=1;
                pre();
                while(t--!=0){
                    solve();cn++;
                }
                out.flush();
}

// taking inputs
static BufferedReader s1;
static BufferedWriter out;
static String read() throws IOException{String line="";while(line.length()==0){line=s1.readLine();continue;}return line;}
static int int_v (String s1){return Integer.parseInt(s1);}
static long long_v(String s1){return Long.parseLong(s1);}
static void sort(int[] a){List<Integer> l=new ArrayList<>();for(int x:a){l.add(x);}Collections.sort(l);for(int i=0;i<a.length;i++){a[i]=l.get(i);}}
static int[] int_arr() throws IOException{String[] a=read().split(" ");int[] b=new int[a.length];for(int i=0;i<a.length;i++){b[i]=int_v(a[i]);}return b;}
static long[] long_arr() throws IOException{String[] a=read().split(" ");long[] b=new long[a.length];for(int i=0;i<a.length;i++){b[i]=long_v(a[i]);}return b;}
static void assign(){s1=new BufferedReader(new InputStreamReader(System.in));out=new BufferedWriter(new OutputStreamWriter(System.out));}
//static String setpreciosion(double d,int k){BigDecimal d1 = new BigDecimal(Double.toString(d));return d1.setScale(k,RoundingMode.HALF_UP).toString();}//UP DOWN HALF_UP
static int add(int a,int b){int z=a+b;if(z>=mod)z-=mod;return z;}
static long gcd(long a,long b){if(b==0){return a;}return gcd(b,a%b);}
static long Modpow(long a,long p,long m){long res=1;while(p>0){if((p&1)!=0){res=(res*a)%m;}p >>=1;a=(a*a)%m;}return res%m;}
static long Modmul(long a,long b,long m){return ((a%m)*(b%m))%m;}
static long ModInv(long a,long m){return Modpow(a,m-2,m);}
//static long nck(int n,int r,long m){if(r>n){return 0l;}return Modmul(f[n],ModInv(Modmul(f[n-r],f[r],m),m),m);}
//static long[] f;
}