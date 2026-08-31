import java.util.Scanner;
public class Main{
public static void main(String[]args){
Scanner scan=new Scanner(System.in);
int a=scan.nextInt();
int b[][]=new int[4][13];
int i=0;
int j=0;
String str="";
int num=0;
int mar=0;
do {
	b[i][j]=0;
	j++;
	if(j==13) {
		
		j=0;i++;
	if(i==4) {break;}	
	}
	
}while(true);
i=0;
j=0;
do {
	if(a==i) {break;}
	str=scan.next();
	num=scan.nextInt();
	num-=1;
	if(str.equals("S")) {mar=0;}
	if(str.equals("H")) {mar=1;}
	if(str.equals("C")) {mar=2;}
	if(str.equals("D")) {mar=3;}
	i++;
	b[mar][num]=1;
	}while(true);
i=0;
do {
	if(b[i][j]==0) {
		if(i==0) {
			System.out.println("S "+(j+1));
			
		}	if(i==1) {
			System.out.println("H "+(j+1));
			
		}	if(i==2) {
			System.out.println("C "+(j+1));
			
		}	if(i==3) {
			System.out.println("D "+(j+1));
			
		}
		}
	j++;
	if(j==13) {	
		j=0;i++;
	if(i==4) {break;}	
	}
	
}while(true);
}
}

