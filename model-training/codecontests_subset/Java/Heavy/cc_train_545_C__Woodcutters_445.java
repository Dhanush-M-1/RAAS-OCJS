import java.util.Scanner;



public class P545C {

    public static int max(int v1, int v2) {
        return v1 > v2 ? v1 : v2;
    }
    
	final static int array_Max=100000;
	public static void main(String[] args) {
		int n;
        Scanner sc = new Scanner(System.in);
        int x[] = new int [array_Max];
        int h[] = new int [array_Max];
        n = sc.nextInt();
        
        for( int i=0; i<n; i++){
        	
        	x[i]=sc.nextInt();
        	h[i]=sc.nextInt();
        	
        }
        
        
        

    	int sol_left [] =new int [n];
    	int sol_right [] =new int [n];
    	int sol_stand [] =new int [n];
    	
    	sol_left[0]=1;
    	sol_right[0]=1;
    	sol_stand[0]=0;
    	
    	
    	
    	 		
    	
    	for(int i=1; i<n; i++) // left로 쓰러지는 경우 계산.
		{
    		if(x[i]-x[i-1]>h[i]+h[i-1]){///////구간이 충분히 넓다-> right로 쓰러뜨릴수있음
    			sol_left[i] = max(sol_right[i-1],sol_left[i-1]);
    			sol_left[i] = max(sol_left[i], sol_stand[i-1]);
    			sol_left[i]++;
    		}else if(x[i]-x[i-1]>h[i]){///////////right 제외
    			sol_left[i] = max(sol_stand[i-1],sol_left[i-1]);
    			sol_left[i]++;
    		}else{
    			sol_left[i]=max(sol_left[i-1],sol_stand[i-1]);
    		}
    		
    		if(x[i]-x[i-1]>h[i-1]){////

    			sol_stand[i] = max(sol_right[i-1],sol_left[i-1]);
    			sol_stand[i] = max(sol_stand[i], sol_stand[i-1]);
    		}else{
    			sol_stand[i]=max(sol_stand[i-1],sol_left[i-1]);
    		}
    		
    		if(x[i]-x[i-1]>h[i-1]){////

    			sol_right[i] = max(sol_right[i-1],sol_left[i-1]);
    			sol_right[i] = max(sol_right[i], sol_stand[i-1]);
    			sol_right[i]++;
    		}else {
    			sol_right[i]=max(sol_left[i-1],sol_stand[i-1]);
    			sol_right[i]++;
    		}

    	}
        
    	

        
    	int result = max(sol_left[n-1],sol_right[n-1]);
    	result = max(result,sol_stand[n-1]);
    	System.out.println(result);
        
	}
}
