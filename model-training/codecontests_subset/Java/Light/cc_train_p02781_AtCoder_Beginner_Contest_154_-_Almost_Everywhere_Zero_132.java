import java.util.*;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
 
		char[] n = sc.next().toCharArray();
	    int k = sc.nextInt();

	    int l = n.length;
	    int dp0[][] = new int[l+1][k+1];
	    int dp1[][] = new int[l+1][k+1]; //確定小於N
	    
	    dp0[0][0] = 1;

	    for(int i=0;i<l;i++){
	        for(int j=0;j<=k;j++){
	            if(dp0[i][j]==1){
	                for(int h=0;h<=n[i]-'0';h++){
	                    if(h+'0' == n[i]){
	                        if(n[i]=='0'){
	                            dp0[i+1][j] = 1;
	                        }
	                        else{
	                            if(j+1<=k)
	                                dp0[i+1][j+1] = 1;
	                        }
	                    }
	                    else{
	                        if(h==0){
	                            dp1[i+1][j] += 1;
	                        }
	                        else{
	                            if(j+1<=k)
	                                dp1[i+1][j+1] += 1;
	                        }
	                    }
	                }
	            }

	            dp1[i+1][j] += dp1[i][j];
	            if(j+1<=k)
	                dp1[i+1][j+1] += 9*dp1[i][j];
	        }
	    }


	    System.out.println(dp0[l][k]+dp1[l][k]);
	}
}