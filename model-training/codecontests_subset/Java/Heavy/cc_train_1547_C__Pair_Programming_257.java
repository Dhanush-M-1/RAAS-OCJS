import java.util.*;
public class Pair{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0){
			int k = sc.nextInt();
			int n =sc.nextInt();
			int m = sc.nextInt();
			int [] a = new int[n];
			int [] b = new int[m];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			for(int i=0;i<m;i++)
				b[i]=sc.nextInt();
			List<Integer> list = new ArrayList<Integer>();
			int i=0,j=0;
			while(i<n || j<m){
				boolean aBoo = false;
				boolean bBoo = false;
				if(i<n){
				if(a[i]>0){
					if(a[i]<=k){
						list.add(a[i]);
						i++;
						continue;
					}else{
						aBoo=true;
					}
				}else{
					list.add(a[i]);
					i++;
					k++;
					continue;
				}
				}
				if(j<m){
				if(b[j]>0){
					if(b[j]<=k){
						list.add(b[j]);
						j++;
						continue;
					}else {
						bBoo=true;
					}
				}else {
					list.add(b[j]);
					j++;
					k++;
					continue;
				}
				}
				if(aBoo||bBoo){
					list.clear();
					list.add(-1);
					break;
				}
				//System.out.println(i+" "+j);
			}
			for(Integer d: list)
				System.out.print(d+" ");
			System.out.println();
		}
	}
}