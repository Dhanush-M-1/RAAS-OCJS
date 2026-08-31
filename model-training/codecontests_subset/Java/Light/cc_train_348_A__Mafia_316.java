import java.util.*;

public class Main{
    boolean debug=false;
    int INF=1<<28;

    long n,max;
    long[] a;

    void solve(){
	Scanner sc=new Scanner(System.in);
	n=sc.nextLong();
	a=new long[(int)n];
	max=-1L;
	for(int i=0;i<n;i++){
	    a[i]=sc.nextLong();
	    if(a[i]>max)max=a[i];
	}

	long left=1L; 
	long right=10000000000L;
	long ans=-1L;


	while(left<right){
	    long m=(left+right)/2L;
	    boolean f1=ok(m);
	    boolean f2=ok(m-1L);

	    if(f1 && !f2){
		ans=m;break;
	    }
	    if(f1 && f2){
		right=m;
	    }else if(!f1 && !f2){
		left=m+1;
	    }else{
		int k=1/0;
	    }
	}

	System.out.println(ans);
    }

    boolean ok(long m){
	if(m<max)return false;
	long count=0;
	for(int i=0;i<n;i++){
	    count+=m-a[i];
	}
	if(count>=m)return true;
	return false;
    }

    public static void main(String[] args){
	new Main().solve();
    }
}