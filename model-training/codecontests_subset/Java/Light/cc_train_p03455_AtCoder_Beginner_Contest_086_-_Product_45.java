
import java.util.Scanner;

class Main {

public static void main(String[] args){
int a,b;
int c;
Scanner sc=new Scanner(System.in);

	a=sc.nextInt();
	b=sc.nextInt();

	c=a*b;
	if(c%2==0) {
		System.out.println("Even");}
	else {
		System.out.println("Odd");
	}

}}
