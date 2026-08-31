import java.util.*;
public class Main {
	Scanner sc = new Scanner(System.in);
	int N;
	int[] A;
	int minj,key;
	int count=0;
	
	public void input(){
		N=sc.nextInt();
		A = new int[N];
		for(int i=0; i<N; i++){
			A[i]=sc.nextInt();
		}
	}
	
	public void selectionsort(){
		for(int i=0; i<N-1; i++){
			minj=i;
			for(int j=i; j<=N-1; j++){
				if(A[j] < A[minj]){
					minj = j;
				}
			}
			key = A[i];
			A[i] = A[minj];
			A[minj] = key;
			if(i != minj) count++;
		}
	}
	
	public void output(){
		System.out.print(A[0]);
		for(int i=1; i<N; i++){
			System.out.print(" "+A[i]);
		}
		System.out.println("\n"+count);
	}
	
	public static void main(String[] args){
		Main obj = new Main();
		obj.input();
		obj.selectionsort();
		obj.output();
	}
}

