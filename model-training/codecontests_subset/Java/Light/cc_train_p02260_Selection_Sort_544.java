import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=Integer.valueOf(sc.next());
		int[] arr= new int[n];
		for(int i=0;i<n;i++){
			arr[i]=Integer.valueOf(sc.next());
		}
		sc.close();
		
		int count=0;
		for(int i=0;i<n-1;i++){
			int min=Integer.MAX_VALUE;
			int k=0;
			for(int j=i;j<n;j++){
				if(min>arr[j]){
					min=arr[j];
					k=j;
				}
			}
			if(i!=k){
				arr[k]=arr[i];
				arr[i]=min;
				count++;
			}
		}
		System.out.print(arr[0]);
		for(int i=1;i<n;i++){
			System.out.print(" "+arr[i]);
		}
		System.out.println();
		System.out.println(count);
	}

}