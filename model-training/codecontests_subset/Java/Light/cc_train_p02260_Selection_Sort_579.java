import java.util.*;
public class Main{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int N,num=0,mini=0;
		N=sc.nextInt();
		int[] A=new int[N];
		for(int i=0;i<N;i++){
			A[i]=sc.nextInt();
		}
		for(int i=0;i<N-1;i++){
			mini=i;
			for(int j=i+1;j<N;j++){
				if(A[j]<A[mini]){
					mini=j;
				}
			}
			if(mini!=i){
				int tmp=A[i];
				A[i]=A[mini];
				A[mini]=tmp;
				num++;
			}
		}
		for(int i=0;i<N;i++){
			if(i==N-1){
				System.out.println(A[i]);
			}
			else{
				System.out.print(A[i]+" ");
			}
		}
		System.out.println(num);
	}
}
