import java.util.*;

public class CodeForces{
   
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0) {
		    int n=sc.nextInt();
		    
		    int[] a=new int[n];
		    for(int i=0;i<n;i++){
		        
		         a[i]=sc.nextInt();
		        
		    }
		    boolean flag=true;
		    for(int i=0;i<n-1;i++){
		        if(Math.min(i,n-i-1)>a[i]){
		            flag=false;
		        }
		    }
		    if(n%2==0&&a[n/2]<=n/2-1&&a[n/2-1]<=n/2-1){
		        flag=false;
		    }
		    
		    System.out.println(flag?"Yes":"No");
			
		}
	}

}