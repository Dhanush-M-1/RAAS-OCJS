import java.util.Scanner;

class Main{
    
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int A[] = new int[N];
	for(int i = 0;i < N;i++){
	    A[i] = sc.nextInt();
	}
	int cnt = 0, tmp, minj;
	for(int i = 0;i <= N - 1;i++){
	    minj = i;
	    int flag = 0;
	    for(int j = i;j <= N - 1;j++){
		if(A[j] < A[minj]){
		    minj = j;
		}		
	    }
	    tmp = A[i];
	    A[i] = A[minj];
	    A[minj] = tmp;
	    if(i == minj){
		flag = 1;
	    }
	    if(flag == 0){
		cnt++;
		}	   
	}	
	for(int k = 0;k < N;k++){
	    System.out.print(A[k]);
	    if(k == N - 1) break;
	    System.out.print(" ");
	}
	System.out.println("\n" + cnt);
    }
}

