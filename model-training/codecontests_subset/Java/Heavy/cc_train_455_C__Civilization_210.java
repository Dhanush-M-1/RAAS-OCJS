import java.io.*;
import java.util.*;

public class Main {
    //static long mod=1000000007;
	static int[] par;
	static int[] rad;
	static int[] guk;// number of centers
	public static void main(String[] args){
		int n=ni(),m=ni(),q=ni();
		par=new int[n+1];
		rad=new int[n+1];
		guk=new int[n+1];
		for(int i=0;i<par.length;i++) par[i]=i;
		for(int i=0;i<rad.length;i++) rad[i]=0;
		for(int i=0;i<guk.length;i++) guk[i]=1;
		
		int[] a=new int[m],b=new int[m];
		for(int i=0;i<m;i++){
			a[i]=ni();
			b[i]=ni();
		}
		int[][] ad=get(n,a,b);
		int[][] centers=center(ad);
		//for(int i=0;i<centers.length;i++) pl(Arrays.toString(centers[i]));
		
		for(int i=0;i<=n;i++){
			par[i]=centers[i][1];
			rad[i]=(centers[i][0]+1)/2;
			guk[i]=(1+centers[i][0])%2;
		}
		
		for(int i=0;i<q;i++){
			int aa=ni();
			if(aa==1){
				int x=ni();
				pl(diameter(x));
			}else{
				int f=ni(),t=ni();
				union(f,t);
			}
		}
		flush();
	}
	static void union(int a,int b){
		while(par[a]!=a) a=par[a];
		while(par[b]!=b) b=par[b];
		if(a==b) return;
		if(rad[a]>rad[b]){
			union(b,a);
			return;
		}
		if(rad[a]==rad[b]){
			rad[b]++;
			guk[b]=0;
		}else if(rad[a]==(rad[b]-1)){
			guk[b]=1;
		}
		par[a]=b;
	}
	static int diameter(int x){
		while(par[x]!=x) x=par[x];
		if(guk[x]==0) return rad[x]*2-1;
		else return rad[x]*2;
	}
	public static int[][] get(int n,int[] a,int[] b){
     int[][] res=new int[n+1][];
     int[] c=new int[n+1];
     for(int i=0;i<a.length;i++){
         c[a[i]]++;
         c[b[i]]++;
     }
     for(int i=0;i<n+1;i++)
         res[i]=new int[c[i]];
     for(int i=0;i<a.length;i++){
         int from=a[i],to=b[i];
         res[from][--c[from]]=to;
         res[to][--c[to]]=from;
     }
     return res;
 }
	static int[] stack=new int[1010101];
	/*static int[] center(int[][] ad,int from){//res[0]: diameter res[1]: (one of) center
		int[] md=mostDistant(ad,from);
		int v=md[1];
		int[] md2=mostDistant(ad,v);
		int w=md2[1];
		int diameter=md2[2];
		
		int vd=diameter/2;
		int wd=diameter-vd;
		
		int[] vdist=dists(ad,v),wdist=dists(ad,w);
		int target=0;
		for(int i=0;i<ad.length;i++){
			if(vdist[i]==vd && wdist[i]==wd){
				target=i;
				break;
			}
		}
		
		return new int[]{diameter,target};
	}*/
	static int[][] center(int[][] ad){// res[i][0]: diameter of tree containing i res[i][1] is center of tree containing i
		int n=ad.length;
		boolean[] ju1=new boolean[n];
		boolean[] ju2=new boolean[n];
		boolean[] ju3=new boolean[n];
		boolean[] ju4=new boolean[n];
		int[] arr1=new int[n];
		int[] arr2=new int[n];
		int[] arr3=new int[n];
		int prev=-1;
		int[][] res=new int[n][2];
		while(true){
			int root=-1;
			for(int i=prev+1;i<n;i++){
				if(ju4[i]) continue;
				root=i;
				prev=i;
				break;
			}
			if(root==-1) break;
			int[] cd1=cmostDistant(ad,root,ju1,arr1);
			int v=cd1[1];
			int[] cd2=cmostDistant(ad,v,ju2,arr2);
			int w=cd2[1];
			int diameter=cd2[0];
			
			int vd=diameter/2,wd=diameter-vd;
			int size=0;
			stack[size++]=w;
			ju3[w]=true;
			int center=root;
			while(size>0){
				int cur=stack[--size];
				for(int ch:ad[cur]){
					if(ju3[ch]) continue;
					stack[size++]=ch;
					ju3[ch]=true;
					arr3[ch]=arr3[cur]+1;
					if(arr3[ch]==wd && arr2[ch]==vd){
						center=ch;
						size=0;
						break;
					}
				}
			}
			
			size=0;
			stack[size++]=root;
			ju4[root]=true;
			while(size>0){
				int cur=stack[--size];
				for(int ch:ad[cur]){
					if(ju4[ch]) continue;
					stack[size++]=ch;
					ju4[ch]=true;
				}
				res[cur]=new int[]{diameter,center};
			}
		}
		return res;
	}
	
	private static void cdists(int[][] ad,int from,boolean[] ju,int[] arr){
		int n=ad.length;
		int[] res=arr;
		int size=0;
		stack[size++]=from;
		ju[from]=true;
		res[from]=0;
		while(size>0){
			int cur=stack[--size];
			for(int ch:ad[cur]){
				if(ju[ch]) continue;
				stack[size++]=ch;
				res[ch]=res[cur]+1;
				ju[ch]=true;
			}
		}
	}
	private static int[] cmostDistant(int[][] ad,int from,boolean[] ju,int[] arr){//res[0]: distance res[1]: node
		int n=ad.length;
		int size=0;
		stack[size++]=from;
		int[] dist=arr;
		dist[from]=0;
		ju[from]=true;
		int node=from;
		int max=0;
		while(size>0){
			int cur=stack[--size];
			for(int ch:ad[cur]){
				if(ju[ch])continue;
				ju[ch]=true;
				stack[size++]=ch;
				dist[ch]=dist[cur]+1;
				if(dist[node]<dist[ch]) node=ch;
				max=Math.max(max,dist[ch]);
			}
		}
		return new int[]{max,node};
	}
	/*static int[] dists(int[][] ad,int from){
		int n=ad.length;
		int[] res=new int[n];
		int size=0;
		boolean[] ju=new boolean[n];
		stack[size++]=from;
		ju[from]=true;
		while(size>0){
			int cur=stack[--size];
			for(int ch:ad[cur]){
				if(ju[ch]) continue;
				stack[size++]=ch;
				res[ch]=res[cur]+1;
				ju[ch]=true;
			}
		}
		return res;
	}
	static int[] mostDistant(int[][] ad,int from){//res[0]: distance res[1]: node
		int n=ad.length;
		int size=0;
		stack[size++]=from;
		int[] dist=new int[n];
		boolean[] ju=new boolean[n];
		ju[from]=true;
		while(size>0){
			int cur=stack[--size];
			for(int ch:ad[cur]){
				if(ju[ch])continue;
				dist[ch]=dist[cur]+1;
			}
		}
		
		int node=from;
		int max=0;
		for(int i=0;i<n;i++){
			if(dist[node]<dist[i]) node=i;
			max=Math.max(max,dist[i]);
		}
		return new int[]{max,node};
	}*/
    
    
    
    
    
	private static final byte[] buffer = new byte[1024];
	private static int ptr = 0;
	private static int buflen = 0;
	private static boolean hasNextByte() {
		if (ptr < buflen)  return true;
		else{
			ptr = 0;
			try {
				buflen = System.in.read(buffer);
			} catch (IOException e) {e.printStackTrace();}
			if (buflen <= 0)  return false;
		}
		return true;
	}
	private static int readByte() { return hasNextByte() ? buffer[ptr++] : -1;}
	private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
	private static void skipUnprintable() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++;}
	public static boolean hasNext() { skipUnprintable(); return hasNextByte();}
	public static String next() {
		if (!hasNext()) throw new NoSuchElementException();
		StringBuilder sb = new StringBuilder();
		for(int b = readByte();isPrintableChar(b);b = readByte()) {
			sb.appendCodePoint(b);
		}
		return sb.toString();
	}
	public static int nextInt() {return (int)nextLong();}
	public static long nextLong() {
		if (!hasNext()) throw new NoSuchElementException();
		long n = 0;
		boolean minus = false;
		int b = readByte();
		if (b == '-') {
			minus = true;
			b = readByte();
		}
		if (b < '0' || '9' < b)  throw new NumberFormatException();
		while(true){
			if ('0' <= b && b <= '9') n = n * 10 + b-'0';
			else if(b == -1 || !isPrintableChar(b)) return minus ? -n : n;
			else throw new NumberFormatException();
			b = readByte();
		}
	}
	public static long[] nextLongArray(int i){
		long[] result=new long[i];
		for(int j=0;j<i;j++)  result[j]=nextLong();
		return result;
	}
	public static void nextLongArray(long[]... arrays){
		for(int j=0;j<arrays[0].length;j++)
			for(long[] array:arrays) array[j]=nextLong();
	}
	public static int[] nextIntArray(int i){
		int[] result=new int[i];
		for(int j=0;j<i;j++)  result[j]=nextInt();
		return result;
	}
	public static void nextIntArray(int[]... arrays){
		for(int j=0;j<arrays[0].length;j++)
			for(int[] array:arrays)  array[j]=nextInt();
	}
	public static int ni(){return nextInt();}
	public static long nl(){return nextLong();}
	public static int[] nia(int n){return nextIntArray(n);}
	public static long[] nla(int n){return nextLongArray(n);}
	public static String ne(){return next();}
	
	static StringBuilder sb=new StringBuilder();
	public static void flush(){
		System.out.print(sb);
		sb=new StringBuilder();
	}
	public static void pr(Object o){sb.append(o);}
	public static void pl(Object o){sb.append(o).append("\n");}
	public static void pl(){sb.append("\n");}
	public static int lastLowerIndex(long[] array,long lo){return lastLowerOrEqualIndex(array,lo-1);}
	public static int lastLowerOrEqualIndex(long[] array,long lo){
		int res=Arrays.binarySearch(array,lo);
		return res<0?-res-2:res;
	}
	public static long gcd(long a,long b){
		if(a>b)a%=b;
		while(a>0){
			b%=a;
			if(b==0)return a;
			a%=b;
		}
		return b;
	}
	public static long modPow(long a,long b,long mod){
		long c=1;
		while(b>0){
			if(b%2==1)  c=(c*a)%mod;
			a=(a*a)%mod;
			b/=2;
		}
		return c;
	}
	public static long inv(long a,long mod){
		long b=mod;
		long p = 1, q = 0;
		while (b > 0) {
			long c = a / b;
			long d=a;
			a = b;
			b = d % b;
			d = p;
			p = q;
			q = d - c * q;
		}
		return p < 0 ? p + mod : p;
	}
	static long time=0;
	public static void time(){
		if(time==0) time=System.nanoTime();
		else{
			long t=System.nanoTime();
			pl((t-time)/1000000000.0+"sec");
			time=t;
		}
	}
	public static Integer[] sortedIndex(long[] a){
            Integer[] res=new Integer[a.length];
            for(int i=0;i<a.length;i++)	res[i]=i;
            mergesortIndex(res,a,0,a.length);
            return res;
        }
        private static Integer[] stem=new Integer[200005];
        private static void mergesortIndex(Integer[] index,long[] a, int s, int e){//uwi's
            if(e - s <= 1)return;
            int h = s+e>>1;
            mergesortIndex(index,a, s, h);
            mergesortIndex(index,a, h, e);
            int p = 0;
            int i= s, j = h;
            for(;i < h && j < e;)stem[p++] = a[(int)index[i]] < a[(int)index[j]] ? index[i++] : index[j++];
            while(i < h)stem[p++] = index[i++];
            while(j < e)stem[p++] = index[j++];
            System.arraycopy(stem, 0, index, s, e-s);
        }
        private static long[] stmp=new long[200005];
        private static void mergesort(long[] a, int s, int e){//uwi's
            if(e - s <= 1)return;
            int h = s+e>>1;
            mergesort(a, s, h);
            mergesort(a, h, e);
            int p = 0;
            int i= s, j = h;
            for(;i < h && j < e;)stmp[p++] = a[i] < a[j] ? a[i++] : a[j++];
            while(i < h)stmp[p++] = a[i++];
            while(j < e)stmp[p++] = a[j++];
            System.arraycopy(stmp, 0, a, s, e-s);
        }
}