import java.util.*;

public class Test{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        BIT bit=new BIT(n);
        long[] s=new long[n+1],ori=new long[n+1];
        for(int i=1;i<=n;++i){
            s[i]=sc.nextLong();
        }
        for(int i=n;i>0;i--){
            int l=0,r=n;
            while(l+1<r){
                int mid=(l+r)>>1;
                if(bit.sum(mid)>s[i]){
                    r=mid;
                }else{
                    l=mid;
                }
            }
            ori[i]=r;
            bit.add(r,-r);
        }
        for(int i=1;i<=n;i++){
            System.out.printf("%d ",ori[i]);
        }
        System.out.printf("\n");
        sc.close();
    }
}

class BIT{
    public long[] bit,val;
    public int n;
    public long sum(int i){
        long res=0;
        while(i>0){
            res+=bit[i];
            i-=i&-i;
        }
        return res;
    }
    public void add(int i,int x){
        val[i]+=i;
        while(i<=n){
            bit[i]+=x;
            i+=i&-i;
        }
    }
    public BIT(int n){
        this.n=n;
        this.bit=new long[n+1];
        this.val=new long[n+1];
        for(int i=1;i<=n;++i){
            add(i,i);
        }
    }
}
  				 	 	 	 	     				 	 	  	