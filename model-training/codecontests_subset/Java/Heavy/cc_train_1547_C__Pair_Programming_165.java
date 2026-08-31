
import java.util.*;
public class B {
	static Scanner sc = null;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- >0){
		    int k = sc.nextInt();
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    int a[] = new int[n];
		    int b[] = new int[m];
		    for(int i=0;i<n;i++)
		    a[i] = sc.nextInt();
		    for(int i=0;i<m;i++)
		    b[i] = sc.nextInt();
		    int aI = 0;
		    int bI = 0;
		    boolean res = true;
		    ArrayList<Integer> ar = new ArrayList<>();
		    while(aI<n && bI<m){
		        boolean r1 = false;
		        boolean r2 = false;
		        if(a[aI]==0){
		            ar.add(a[aI]);
		            aI++;
		            k++;
		        }
		        else{
		            if(a[aI]<=k){
		                ar.add(a[aI]);
		                aI++;
		            }
		            else
		            r1 = true;
		        }
		        if(b[bI]==0){
		            ar.add(b[bI]);
		            bI++;
		            k++;
		        }
		        else{
		            if(b[bI]<=k){
		             ar.add(b[bI]);
		             bI++;
		            }
		            else
		            r2 = true;
		        }
		        if(r1 && r2){
		            res = false;
		            break;
		        }
		    }
		    while(aI<n && res){
		        boolean r1 = false;
		          if(a[aI]==0){
		            ar.add(a[aI]);
		            aI++;
		            k++;
		        }
		        else{
		            if(a[aI]<=k){
		                ar.add(a[aI]);
		                aI++;
		            }
		            else
		            r1 = true;
		        }
		        if(r1){
		            res = false;
		            break;
		        }
		    }
		    while(bI<m && res){
		        boolean r2 = false;
		     if(b[bI]==0){
		            ar.add(b[bI]);
		            bI++;
		            k++;
		        }
		        else{
		            if(b[bI]<=k){
		             ar.add(b[bI]);
		             bI++;
		            }
		            else
		            r2 = true;
		        }
		        if(r2){
		            res = false;
		            break;
		        }   
		    }
		    if(res){
		        for(Integer j : ar)
		        System.out.print(j+" ");
		    }
		    else
		     System.out.print("-1");
		      System.out.println();
		}
	}
}



