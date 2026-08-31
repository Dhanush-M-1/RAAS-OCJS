/**
 * 1547c_PairProgramming
 */
import java.util.*;
public class PairProgramming {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){                             
            // System.out.println("running..."+t);
            int k = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            int a[]=new int[n];
			int b[]=new int[m];
			int c[]=new int[n+m];
			boolean vis = true;
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			for(int i=0;i<m;i++)
				b[i]=sc.nextInt();
			int i=0,j=0;
			for(int z=0;z<n+m;z++) {
				if(i<n&&a[i]<=k) {
					if(a[i]==0)
						k++;
					c[z]=a[i];
					i++;
				}else if(j<m&&b[j]<=k) {
					if(b[j]==0)
						k++;
					c[z]=b[j];
					j++;
				}else {
                    vis = false;
				}
			}
			if(vis == false){
                System.out.println(-1);
            }
            else{
                for(int z=0;z<n+m;z++)
                    System.out.print(c[z]+" ");
                System.out.println();
            }
        }
    }
        

}
