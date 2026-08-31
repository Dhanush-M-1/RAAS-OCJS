import java.util.Arrays;
import java.util.Scanner;
class Main{
	public static void main(String[] args){
	Scanner x=new Scanner(System.in);
        while(x.hasNext()){
            int m=x.nextInt();
            int[] A=new int[m];
            for(int i=0;i<m;i++){
                A[i]=x.nextInt();
            }
			int count=0;
            int n =A.length;
			for(int i=0;i<n;i++){
				int lowest = i;
				for(int j=i;j<n;j++){
					if(A[j]<A[lowest]){
						lowest = j;					
					}
				}
				if(lowest!=i){
					int temp =A[i];
				    A[i] = A[lowest];
				    A[lowest] = temp;
				    count++;
				}
			}
			Show(A);
			System.out.println(count);
			break;
		}
	}	
	public static void Show(int[] A){
	    int i;
		for(i=0;i<A.length-1;i++){
			System.out.print(A[i]+" ");
		}
		System.out.println(A[i]);
	}
}	

