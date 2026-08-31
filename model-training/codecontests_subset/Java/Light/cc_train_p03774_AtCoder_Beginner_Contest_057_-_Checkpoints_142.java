import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    int N = sc.nextInt();
	    int M = sc.nextInt();
	    
	    int [] A = new int [N];
	    int [] B = new int [N];
	    
	    for (int i=0; i<N; i++){
	    	A[i]=sc.nextInt();
	    	B[i]=sc.nextInt();
	    }
	    
	    int [] C = new int [M];
	    int [] D = new int [M];
	    
	    for (int i=0; i<M; i++){
	    	C[i]=sc.nextInt();
	    	D[i]=sc.nextInt();
	    }
	    
	    for (int i=0; i<N; i++){
	    	int a = A[i];
	    	int b = B[i];
	    	int c = C[0];
	    	int d = D[0];
	    	
	    	int min = Math.abs(a-c)+Math.abs(b-d);
	    	int index = 1;
	    	
	    	for (int j=1; j<M; j++){
	    		c = C[j];
	    		d = D[j];
	    		int temp = Math.abs(a-c)+Math.abs(b-d);
	    		
	    		if (temp<min){
	    			index=j+1;
	    			min=temp;
	    		}
	    			
	    	}
	    	System.out.println(index);
	    }
	    sc.close();
	    
	    

	}

}
