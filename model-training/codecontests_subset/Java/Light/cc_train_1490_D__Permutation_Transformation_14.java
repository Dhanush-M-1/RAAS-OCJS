import java.util.*;
public class Main {
    public static int[] a=new int[105];
    public static int[] b=new int[105];

    public static void solve(int num,int l,int r){
        if(l>r)
            return;
        int i,maxn=l;
        for(i=l+1;i<=r;i++){
            if(a[i]>a[maxn]){
                maxn=i;
            }
        }
        b[maxn]=num;
        solve(num+1,l,maxn-1);
        solve(num+1,maxn+1,r);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int t=scanner.nextInt();
            while (t>0){
                int n=scanner.nextInt();
                for(int i=1;i<=n;i++)
                    a[i]=scanner.nextInt();
                Arrays.fill(b,0);
                solve(0,0,n);
                for(int i=1;i<n;i++)
                    System.out.print(b[i]+" ");
                System.out.println(b[n]);
                t--;
            }
        }
    }
}
		 	      		   	 				 	 	  	