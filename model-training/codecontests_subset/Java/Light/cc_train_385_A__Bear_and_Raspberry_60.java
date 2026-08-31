import java.util.Scanner;
public class Main
{
public static void main(String[]args)
{
Scanner scan =new Scanner(System.in);
int n = scan.nextInt();
int c=scan.nextInt();
int[] array = new int[n];
for (int i=0 ; i<n;i++){
	array[i]=scan.nextInt();
}
int[] a = new int[n-1];
for(int i=0;i<n-1;i++){
	a[i]=array[i]-array[i+1]-c;
}
int m=a[0];
for(int i=1;i<n-1;i++){
	if(a[i]>m)
		m=a[i];
}
if(m>=0)
	System.out.println(m);
else
	System.out.println("0");
}
}


