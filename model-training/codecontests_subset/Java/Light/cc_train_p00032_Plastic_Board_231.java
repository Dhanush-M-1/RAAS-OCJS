import java.util.*;
import java.util.regex.*;

import static java.lang.Math.*;
import static java.lang.System.out;

// AOJ
public class Main {
	private static final Scanner sc=new Scanner(System.in);
	public static void main(String[] args) {
		new Main().AOJ0032();
	}
	
	void AOJ0032(){
		int c1=0, c2=0;
		while(sc.hasNext()){
			Scanner sc2=new Scanner(sc.next()).useDelimiter(",");
			int a=sc2.nextInt(), b=sc2.nextInt(), c=sc2.nextInt();
			if(pow(a,2)+pow(b,2)==pow(c,2))	c1++;
			if(a==b)	c2++;
		}
		out.println(c1+"\n"+c2);
	}
	
	void AOJ0021(){
		int N=sc.nextInt();
		for(int I=1; I<=N; I++){
			double[] x=new double[4], y=new double[4];
			for(int i=0; i<4; i++){
				x[i]=sc.nextDouble();
				y[i]=sc.nextDouble();
			}
			if((y[0]-y[1])/(x[0]-x[1]) == (y[2]-y[3])/(x[2]-x[3]))	out.println("YES");
			else	out.println("NO");
		}
	}
	
	void AOJ0145(){
		int n=sc.nextInt();
		
	}
	
	void AOJ0141(){
		int N=sc.nextInt();
		for(int I=1; I<=N; I++){
			int n=sc.nextInt();
			char[][] c=new char[n+4][n+4];
			int[] vx={0, 1, 0, -1};
			int[] vy={-1, 0, 1, 0};
			c=solve141(2, n+1, n, c, vx, vy);
			for(int j=2; j<=n+1; j++){
				for(int i=2; i<=n+1; i++)	out.print(c[i][j]);
				out.println();
			}
			out.println();
		}
	}
	char[][] solve141(int x, int y, int n, char[][] c, int[] vx, int[] vy){
		//範囲を超えていないか
		if(x<2&&x>n+1 && y<2&&y>n+1)	return c;
		//周りが#
		//return c;
		
		c[x][y]='#';
		
		// 1周目
		if(x==2){
			if(y!=2)	solve141(x, y-1, n, c, vx, vy);
			else	solve141(x+1, y, n, c, vx, vy);
		}
		if(y==2){
			if(x!=n+1)	solve141(x+1, y, n, c, vx, vy);
			else	solve141(x, y+1, n, c, vx, vy);
		}
		if(x==n+1){
			if(y!=2)	solve141(x, y+1,n,c,vx,vy);
			else	solve141(x-1, y,n,c,vx,vy);
		}
		if(y==n+1){
			if(x!=3)	solve141(x-1,y,n,c,vx,vy);
			else	solve141(x,y-1,n,c,vx,vy);
		}
		
		// それ以降
		for(int i=0; i<4; i++){
			if(c[x+vx[i]][y+vy[i]]!='#'){
				solve141(x+vx[i], y+vy[i],n,c,vx,vy);
			}
		}

		return c;
	}
	
	
	void AOJ0139(){
		int N=sc.nextInt();
		final Pattern ap=Pattern.compile("^>'(=+)#(=+)~$");
		for(int i=1; i<=N; i++){
			String s=sc.next();
			Matcher m=ap.matcher(s);
			if(m.matches()){
				if(m.group(1).length()==m.group(2).length()){
					out.println("A");
					continue;
				}
			}else if(Pattern.compile("^>\\^(Q=)+~~$").matcher(s).matches()){
				out.println("B");
				continue;
			}
			out.println("NA");
		}
	}
	
	void AOJ0137(){
		int N=sc.nextInt();
		for(int i=1; i<=N; i++){
			long s=sc.nextLong();
			out.println("Case "+i+":");
			for(int j=0; j<10; j++){
				s*=s;	s/=100;	s%=10000;
				out.println(s);
			}
		}
	}
	
	ArrayList<Integer> Sieve2(int N){
	    ArrayList<Integer> prime = new ArrayList<Integer>();
	    boolean[] list = new boolean[N+1];
	    Arrays.fill(list, true);
	    list[1]=false;
	    for (int i=2; i<=N; i++) {
	        if(list[i]) {
	            prime.add(i);
	            for (int j=i+i; j<=N; j+=i)    list[j] = false;
	        }
	    }
	    return prime;
	}

	boolean[] Sieve(int N){
	    boolean[] list = new boolean[N+1];
	    Arrays.fill(list, true);
	    list[1]=false;
	    for(int i=2; i<=N; i++) {
	        if(list[i]) {
	            for (int j=i+i; j<=N; j+=i)     list[j] = false;
	        }
	    }
	    return list;
	}
	
	boolean isPrime(int n){
	    for(int i=2; i*i<=n; i++){
	        if(n%i==0)     return false;
	    }
	    return true;
	}
	
	int gcd(int x, int y){
		if(y==0)	return x;
		else	return gcd(y, x%y);
	}
}