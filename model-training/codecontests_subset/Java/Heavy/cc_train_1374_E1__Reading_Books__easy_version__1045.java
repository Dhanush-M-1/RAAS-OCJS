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
static void sort(int[] a){List<Integer> l=new ArrayList<>();for(int z:a){l.add(z);}Collections.sort(l);for(int i=0;i<a.length;i++){a[i]=l.get(i);}}
static long gcd(long a,long b){if(b==0){return a;}return gcd(b,a%b);}
static long Modpow(long a,long p,long m){long res=1;while(p>0){if((p&1)!=0){res=(res*a)%m;}p >>=1;a=(a*a)%m;}return res;}
static long Modmul(long a,long b,long m){return ((a%m)*(b%m))%m;}
static long ModInv(long a,long m){return Modpow(a,m-2,m);}
static int mod=(int)1e9+7;

//......................................@uthor_Alx..............................................

public static void main(String[] args) throws  IOException{
				assign();
				int t=1;//int_v(read());
				while(t--!=0){
					int[] z=int_arr();
					int n=z[0],k=z[1];
					int[][] l=new int[n][3];
					for(int i=0;i<n;i++){l[i]=int_arr();}
					List<Integer> common=new ArrayList<>();
					List<Integer> a=new ArrayList<>();
					List<Integer> b=new ArrayList<>();
					for(int i=0;i<n;i++){
						if(l[i][1]==1&&l[i][2]==1){
							common.add(l[i][0]);
						}
						else if(l[i][1]==1&&l[i][2]==0){
							a.add(l[i][0]);
						}
						else if(l[i][1]==0&&l[i][2]==1){
							b.add(l[i][0]);
						}
						
					}
					Collections.sort(common);
					Collections.sort(a);
					Collections.sort(b);
					//Coolections.sort(not);
					int ac=0,bc=0;
					int ci=0,ai=0,bi=0,res=0;
					while(true){
						if(ai>=a.size()&&ci>=common.size()&&ac<k){
							break;
						}
						if(bi>=b.size()&&ci>=common.size()&&bc<k){
							break;
						}
						if(bi>=b.size()&&ci>=common.size()&&ai>=a.size()){
							break;
						}
						if(ac<k&&bc<k){
							if(ai<a.size()&&bi<b.size()){
							int xx=a.get(ai)+b.get(bi);
							if(ci<common.size()&& xx<common.get(ci)){
								ac++;bc++;
								ai++;bi++;
								res+=xx;
							}
							else if(ci<common.size()){
								ac++;bc++;
								res+=common.get(ci);
								ci++;
							}
							else{
								ac++;bc++;
								ai++;bi++;
								res+=xx;
							}
							}
							else if(ci<common.size()){
								ac++;bc++;
								res+=common.get(ci);
								ci++;
							}
							else {
								break;
							}

						}
						else if(ac>=k&&bc<k){
							if(ci<common.size()&& bi<b.size()){
								if(common.get(ci)>b.get(bi)){
									bc++;
									res+=b.get(bi);
									bi++;
								}
								else{
									bc++;
									res+=common.get(ci);
									ci++;
								}
							}
							else if(bi<b.size()){
									bc++;
									res+=b.get(bi);
									bi++;
								}
								else{
									bc++;
									res+=common.get(ci);
									ci++;
								}
						}
						else if(bc>=k&&ac<k){
							if(ci<common.size()&& ai<a.size()){
								if(common.get(ci)>a.get(ai)){
									ac++;
									res+=a.get(ai);
									ai++;
								}
								else{
									ac++;
									res+=common.get(ci);
									ci++;
								}
							}
							else if(ai<b.size()){
									ac++;
									res+=a.get(ai);
									ai++;
								}
								else{
									ac++;
									res+=common.get(ci);
									ci++;
								}
						}
						else{break;}
						
						
					}
					if(ac<k||bc<k){
						out.write("-1");
					}
					else{
						out.write(res+"");
					}
				}
			    
			    out.flush();

	}
}

