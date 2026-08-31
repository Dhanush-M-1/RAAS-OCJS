import java.util.Scanner;

class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int a[] = new int[N];
        for(int i = 0; i < N; i++){
            a[i] = sc.nextInt();
        }
        
    	int minj;
    	int n = 0;
        for(int i = 0; i < N; i++){
        	minj = i;
            for(int j = i; j < N; j++){
                if(a[j] < a[minj]){
                    minj = j;
                }
            	if(j == N-1 && minj != i){
            		n += 1;
            	}
            }
        	int a0;
            a0 = a[i];
            a[i] = a[minj];
            a[minj] = a0;
        }
    	
    	for(int j = 0; j < N; j++){
    		if(j == N-1){
            	System.out.println(a[j]+"");
    		}else{
    			System.out.print(a[j]+" ");
    		}
    	}
    	System.out.println(n);
    }
}
