	import java.util.*;
	import java.util.Map.Entry;
	 
	 
	 class Main {
//		 static int mod =  (int) (Math.pow(10,9)+7);
		 static int mod =  (int) 998244353;
		 static List<ArrayList<Integer>>  list = new ArrayList<ArrayList<Integer>>();
	    public static void main(String[] args) {
	    	
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();	
	        long[] a = new long[N];
	        int[][] f = new int[N][10];
	        int[][] p = new int[N][11];
	        for (int i=0 ; i<N; i++) {
	        	for(int j=0;j<10;j++) {
		            f[i][j] = Integer.parseInt(sc.next());	        		
	        	}
	        }
	        for (int i=0 ; i<N; i++) {
	        	for(int j=0;j<11;j++) {
		            p[i][j] = Integer.parseInt(sc.next());	        		
	        	}
	        }
	        long ans=-1001001001;
	        for(int i=1;i<(2<<9);i++) {
		        int[] fcnt = new int[N];
	        	for(int j=0;j<10;j++) {
	        		int t = (i>>j)&1;
	        		if(t==1) {
	        			for(int k=0;k<N;k++) {
	        				if(f[k][j]==1) {
	        					fcnt[k]++;
	        				}
	        			}
	        		}
	        	}
		        int sum = 0;
		        for(int j=0;j<N;j++) {
		        	sum = sum + p[j][fcnt[j]];
		        }
		        ans=Math.max(ans, sum);
	        }
	        
	        System.out.println(ans);
	        

	    }
	    
	    

	}