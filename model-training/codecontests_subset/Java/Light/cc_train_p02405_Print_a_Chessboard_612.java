import java.util.Scanner;
class Main{
    public static void main(String[] args){
	final Scanner sc=new Scanner(System.in);
	while(true){
	int a=sc.nextInt();
	int b=sc.nextInt();
	if(a==0 && b==0) break;
	for(int i=0;i<a;i++){
	    for(int j=0;j<b;j++){
		if((i+j)%2==0) System.out.print("#");
		else System.out.print(".");
	    }
	    System.out.println("");
	}
	System.out.println("");
	}
    }
}