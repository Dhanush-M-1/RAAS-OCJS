import java.util.Scanner;
import java.util.Arrays;
public class Watermelon {

	
	public static void main(String[] args){
	   Scanner scan=new Scanner(System.in);
int a=scan.nextInt();
int b=scan.nextInt();int i=a;int count=0;
if(a<b){
	System.out.println(a);System.exit(0);
}
  
if(a%b==0){
while(i>=b){
	
	count=count+i/b;
	i=i/b+i%b;
	
}
	
	
	System.out.println(a+count);
}
if(a%b!=0){
	while(i>=b){
		
		count=count+i/b;
		i=i/b+i%b;

	}
System.out.println(a+count);
}
	
	
	
	
	
	}}	
