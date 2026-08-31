import java.util.*;
import java.io.*;

 public class Task{
// taking inputs
static BufferedReader s1;
static BufferedWriter out;
static String read() throws IOException{String line="";while(line.length()==0){line=s1.readLine();continue;}return line;}
static int int_v (String s1){return Integer.parseInt(s1);}
static long long_v(String s1){return Long.parseLong(s1);}
static int[] int_arr() throws IOException{String[] a=read().split(" ");int[] b=new int[a.length];for(int i=0;i<a.length;i++){b[i]=int_v(a[i]);}return b;}
static long[] long_arr() throws IOException{String[] a=read().split(" ");long[] b=new long[a.length];for(int i=0;i<a.length;i++){b[i]=long_v(a[i]);}return b;}
static void assign(){s1=new BufferedReader(new InputStreamReader(System.in));out=new BufferedWriter(new OutputStreamWriter(System.out));}
static long gcd(long a,long b){if(b==0){return a;}return gcd(b,a%b);}
static long Modpow(long a,long p,long m){long res=1;while(p>0){if((p&1)!=0){res=(res*a)%m;}p >>=1;a=(a*a)%m;}return res;}
static long Modmul(long a,long b,long m){return ((a%m)*(b%m))%m;}
static long ModInv(long a,long m){return Modpow(a,m-2,m);}
static long nck(int n,int r,long m){if(r>n){return 0l;}return Modmul(f[n],ModInv(Modmul(f[n-r],f[r],m),m),m);}

//sort map w.r.t value use-> TreeSet of array? write comparator which depends on all the entries of array otherwise weired behavior you can prove it.
//......................................@uthor_Alx..............................................
// vikassingh@maths.iitd.ac.in
//Hod.Career.Services@admin.iitd.ac.in
//careerservices.iitd@gmail.com
//placement@admin.iitd.ac.in
static long[] f;

   public static void main(String[] args) throws  IOException{
                assign();
                int t=int_v(read()),cn=1;
                while(t--!=0){
                    int n=int_v(read());
                    int[] a=int_arr();
                    int res=-1;boolean b=false;
                        if((a[0]+a[1])<=a[n-1]){
                            out.write((1)+" "+(2)+" "+(n)+"\n");
                        }
                        else{
                            out.write("-1\n");
                        }
                }
                
                out.flush();

    }
}
             