import java.util.Scanner;

class Main{

	public static void main(String[] args){

		Scanner sc =new Scanner(System.in);

		int n=sc.nextInt();
		int a[];
		a=new int [n];

		for(int i=0;i<n;i++)
			a[i]=sc.nextInt();
		
		selectionSort(a,n);

}

	private static void  selectionSort(int a[],int n) {

		int count=0,temp=0,minj;

		for(int i=0;i<n;i++) {
			minj=i;
			for(int j=i;j<n;j++) 
				if(a[j]<a[minj]) 
					minj=j;
				if(minj!=i) {
					temp=a[i];
					a[i]=a[minj];
					a[minj]=temp;
					count++;
				}
		}

		for(int i=0;i<n-1;i++)
			System.out.print(a[i]+" ");
		System.out.println(a[n-1]);
		System.out.println(count);

	}

}
