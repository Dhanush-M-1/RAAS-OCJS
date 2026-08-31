import java.util.Scanner;

class Main{
    public static void main(String[] args){
	int i;
	int j;
	int minj;
	int v;
	int count = 0;
	Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
	int A[] = new int[n];

	//Initialize data
        for(i=0 ; i<n ; i++){
            int num = scan.nextInt();
            A[i] = num;
        }
	
	for(i=0 ; i<n ; i++){
	    minj = i;
	    
	    for(j=i ; j<n ; j++){
		if(A[j] < A[minj]){
		    minj = j;
			}
	    }
	    if(A[i] != A[minj]){
	    	v = A[i];
	    	A[i] = A[minj];
	   		A[minj] = v;
	    	count++;
		}	
	}

	for(i=0 ; i<n-1 ; i++){
	    System.out.print(A[i] + " ");
	}
	System.out.println(A[i]);
	System.out.println(count);
	
    }
}

