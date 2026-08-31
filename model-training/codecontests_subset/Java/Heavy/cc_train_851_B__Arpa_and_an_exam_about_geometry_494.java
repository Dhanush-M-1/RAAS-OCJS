import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class codeforces {
    static class pair{
        int x;
        int y;

        public pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }

    public static long sqrt(long x){
        long s=0,e=x,root=0;
        while(s<=e){
            long mid=(s+e)/2;
            if(mid*mid==x)
            return mid;
            if(mid*mid<x)
            {
                root=mid;
                s=mid+1;
            }
            else
                e=mid-1;
        }
        return root;
    }

    public static long power(int a,int b){
        if(a==0 || b==0)
        return 1;
        long ans=power(a,b/2);
        ans*=ans;
        if(b%2==1)
        ans*=a;
        return ans;
    }

    public static boolean isprime(int x){
        if(x==1)return false;
        if(x<4)return true;
        int root=(int) Math.sqrt(x);
        for(int i=2;i<=root;i++){
            if(x%i==0)
            return false;
        }
        return true;
    }

    public static long dist(long x1,long y1,long x2,long y2){
		return Math.abs(sq(x1-x2))+Math.abs(sq(y1-y2));
	}
	public static long  sq(long x){
		return x*x;
	}


    public static int max(int a,int b){
        return Math.max(a,b);
    }

    public static int min(int a,int b){
        return Math.min(a,b);
    }

    public static void main(String args[] ) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str=new StringBuilder();
        PrintWriter out=new PrintWriter(System.out);  
        String[] l=br.readLine().split(" ");
        long ax=Long.parseLong(l[0]),ay=Long.parseLong(l[1]);
        long bx=Long.parseLong(l[2]),by=Long.parseLong(l[3]);
        long cx=Long.parseLong(l[4]),cy=Long.parseLong(l[5]);
        if(dist(ax,ay,bx,by)==dist(bx,by,cx,cy)){
			if(((by-ay)*(cx-bx))==((cy-by)*(bx-ax)))
				out.println("No");
			else
				out.println("Yes");
		}
		else
            out.println("No");
            out.close();
   }
}

