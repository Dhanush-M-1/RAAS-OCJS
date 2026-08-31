import java.util.Scanner;
public class Mister_B_and_Book_Reading {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int c=sc.nextInt();int v0=sc.nextInt();int v1=sc.nextInt();int a=sc.nextInt();int l=sc.nextInt();
		int d=0;boolean f=false;
		while(c>0){
			if(f){
				c+=l;
			}
			d++;
			c=c-v0;
			v0=(v0+a>v1)?v1:v0+a;
			f=true;
		}
		System.out.println(d);
	}
}
