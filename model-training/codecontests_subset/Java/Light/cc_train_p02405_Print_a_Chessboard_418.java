import java.util.Scanner;
class Main{
public static void main(String[] args){
Scanner scan=new Scanner(System.in);
while(true){
int A=scan.nextInt();
int B=scan.nextInt();
if(A==0&&B==0)
break;
for(int a=0;a<A;a++){
for(int b=0;b<B;b++){
	if(a%2==0){
	if(b%2==0)
System.out.print("#");
	else
		System.out.print(".");
	}
	else{
		if(b%2==1)
			System.out.print("#");
				else
					System.out.print(".");
				}
}
System.out.println();
}
System.out.println();
}
}
}