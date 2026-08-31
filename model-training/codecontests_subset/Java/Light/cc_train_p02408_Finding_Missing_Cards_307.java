import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		int n,c;
		String b;
		Scanner scan=new Scanner(System.in);
		n=scan.nextInt();
		int a[][]=new int[4][13];
		for(int i=0;i<n;i++)
		{
		b=scan.next();
		c=scan.nextInt();
		if(b.equals("S"))a[0][c-1]=1;
		else if(b.equals("H"))a[1][c-1]=1;
		else if(b.equals("C"))a[2][c-1]=1;
		else if(b.equals("D"))a[3][c-1]=1;}
		for(int i=0;i<4;i++) {
		for(int j=0;j<13;j++){
		if(a[i][j]==0 && i==0){
		System.out.println("S "+(j+1));}
		else if(a[i][j]==0 && i==1){
		System.out.println("H "+(j+1));}
		else if(a[i][j]==0 && i==2){
		System.out.println("C "+(j+1));}
		else if(a[i][j]==0 && i==3){
		System.out.println("D "+(j+1));}
		   }         
		} 
	}
}