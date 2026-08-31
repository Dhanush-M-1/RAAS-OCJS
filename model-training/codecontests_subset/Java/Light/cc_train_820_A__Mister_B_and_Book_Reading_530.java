
import java.util.Scanner;

public class test {
	public static void main(String[] args) {  
		
		Scanner s= new Scanner(System.in);
	
	int c=s.nextInt();
	
	int v0=s.nextInt();
	int v1=s.nextInt();
	int a=s.nextInt();
	int l=s.nextInt();
	
	int page=0;
	int i=0,k=0;
	
	while(true){
		
		if((v0+(i*a))<=v1){
		page=page+v0+(i*a);
		}
		else{
		page=page+v1;
		}
		
		
		i++;
		k++;
		if(page>=c){
	     break;
		}
		page=page-l;
	}
	System.out.print(k);
}
}