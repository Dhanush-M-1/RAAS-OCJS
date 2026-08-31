import java.util.Scanner;

class Main{
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int n=scan.nextInt(),m=scan.nextInt(),a[]=new int[50],b[]=new int[50],c[]=new int[50],d[]=new int[50],t1,t2=0,i,j;
		for(i=0;i<n;i++) {
			a[i]=scan.nextInt();
			b[i]=scan.nextInt();
		}
		for(i=0;i<m;i++) {
			c[i]=scan.nextInt();
			d[i]=scan.nextInt();
		}
		scan.close();
		for(i=0;i<n;i++) {
			t1=Integer.MAX_VALUE;
			for(j=0;j<m;j++) {
				if(t1>Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j])) {
					t1=Math.abs(a[i]-c[j])+Math.abs(b[i]-d[j]);
					t2=j;
				}
			}
			System.out.println(t2+1);
		}
	}
}