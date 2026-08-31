import java.util.*;
import java.util.Map.Entry;
 
 
 class Main {
	 static int mod =  (int) (Math.pow(10,9)+7);
	 static List<ArrayList<Integer>>  list = new ArrayList<ArrayList<Integer>>();
    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);
        String N = sc.next();
        char[] c = N.toCharArray();
        
        int K = sc.nextInt();
        long[][] dp1 = new long[105][7];
        long[][] dp2 = new long[105][7];
        
        dp1[0][1]=1;
        dp2[0][1]=1;
        dp1[1][1]=10;
        dp2[1][1]=1;
        dp2[1][2]=9;
        
        
        for(int i=2;i<105;i++) {
        	for(int j=1;j<5;j++) {
            	dp1[i][j]=dp1[i-1][j]+9*dp2[i-1][j];
            	if(j==1) {
                	dp2[i][j]=1;            		
            	} else {
                	dp2[i][j]=dp1[i][j-1];
                	if(2==j)dp2[i][j]--;
            	}
            	//if(j==1)dp1[i][j]++;        		
        	}
        }
        long sum=0;
        int cnt=0;
        for(int i=N.length()-1;i>=0;i--) {
        	int tmp =Character.getNumericValue(c[N.length()-1-i]);;
        	if(tmp==0) continue;
        	sum=sum+dp1[i][Math.max(0,K-cnt)];
        	sum=sum+(tmp-1)*dp2[i][Math.max(0,K-cnt)];
        	cnt++;
        }
     
        System.out.println(sum);        	
                		
    }
    
    
}