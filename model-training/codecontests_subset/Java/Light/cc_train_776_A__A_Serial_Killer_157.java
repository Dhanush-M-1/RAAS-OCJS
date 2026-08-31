
import java.util.Scanner;

public class A778 {
	public static void main(String args[]){
	Scanner scan=new Scanner(System.in);
	String s,t,input1,input2;
	s=scan.next();
	t=scan.next();
	int n=scan.nextInt();
	System.out.println(s+" "+t);
	scan.nextLine();
	for(int i=0;i<n;i++){
		input1=scan.next();
		
		input2=scan.next();
		scan.nextLine();
		if(s.compareTo(input1)==0){
			
			s=input2;
		}else
			t=input2;
		System.out.println(s+" "+t);
		
	}
	}

}
