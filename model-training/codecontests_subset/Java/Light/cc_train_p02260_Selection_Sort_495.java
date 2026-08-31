import java.util.Scanner;

class Main{
	public static void main(String[] args){
		Scanner stdIn=new Scanner(System.in);
		int a[]=new int[100],n=stdIn.nextInt(),i,j,m,t,s=0;
		for(i=0;i<n;i++)a[i]=stdIn.nextInt();
		for(i=0;i<n;i++){
			m=i;
			for(j=i;j<n;j++)if(a[m]>a[j])m=j;
			if(a[i]!=a[m])s++;
			t=a[i];
			a[i]=a[m];
			a[m]=t;
		}
		for(i=0;i<n-1;i++)System.out.print(a[i]+" ");
		System.out.println(a[n-1]+"\n"+s);
	}
}
