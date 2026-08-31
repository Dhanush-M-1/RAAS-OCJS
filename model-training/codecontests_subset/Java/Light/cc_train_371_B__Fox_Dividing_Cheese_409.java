import java.util.Scanner;


public class B371 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Scanner sc =new Scanner(System.in);
int n = sc.nextInt();
int m=sc.nextInt();
int a[]=new int[3];
int b[]=new int[3];

a[0]=method(n,2);
a[1]=method(n,3);
a[2]=method(n,5);

b[0]=method(m,2);
b[1]=method(m,3);
b[2]=method(m,5);

if(n==m)
	System.out.println(0);
else if(method1(n,a)!=method1(m,b))
	System.out.println(-1);
else 
	System.out.println(Math.abs(a[0]-b[0])+Math.abs(a[1]-b[1])+Math.abs(a[2]-b[2]));

	}
static int method(int x, int y){
	int count=0;
	while(x%y==0){
		x=x/y;
		count++;
	}
	return count;
	
	
}
static int method1(int x, int[] y){
	
	return (int) (x/(Math.pow(2, y[0])*Math.pow(3, y[1])*Math.pow(5, y[2])));
	
	
}


}
