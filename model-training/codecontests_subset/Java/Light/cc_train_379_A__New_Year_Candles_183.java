import java.util.Scanner;

public class codeforces{

public static void main(String args[]){

	Scanner input=new Scanner(System.in);
	
	int n=input.nextInt();
	
		int p=input.nextInt();
		
		int suma=n;
		
		int arse=0;
		int rest=0;
		
		while(n>=p){
		
		arse=n/p;
		suma+=arse;
		
		
		rest=n-arse*p;
		n=arse+rest;}
		
		System.out.println(suma);
		
		
		
		
	
	
	
	
	}
	
	
	
	
	}
	
	
	