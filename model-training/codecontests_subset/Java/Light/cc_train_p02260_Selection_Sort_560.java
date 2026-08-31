import java.util.Scanner;


public class Main{

	public static void main(String args[]){
	int i,j,k,min,m;
	Scanner sc=new Scanner(System.in);
	int n=Integer.parseInt(sc.next());
	int a[]=new int[n+1];
	for(i=0;i<n;i++){
		a[i]=Integer.parseInt(sc.next());
	}
int count=0;
	for(i=0;i<n;i++){
		min=i;
		m=a[i];
		for(j=i;j<n;j++){
		if(a[j]<a[min]){
		min=j;	
		}
		}
		if(min!=i){
			count++;
		}
		a[i]=a[min];
		a[min]=m;
	}
	
	for(i=0;i<n;i++){
		System.out.print(a[i]);
		System.out.print((i==n-1) ?"\n":" " );
	}
	System.out.println(count);
	}
}