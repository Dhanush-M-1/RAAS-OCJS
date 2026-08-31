
import java.util.*;

public class Practise { 
	
	
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int ta=0;
		int tb=0;
		int suma=0;
		int sumb=0;
		
		if(a>b) {
			int temp =a;
			a=b;
			b= temp;
		}
		while(b-a>0) {
			a++;
			ta++;
			suma = suma + ta;
			
			if(a-b==0) {
				break;
			}
			else {
				b--;
				tb++;
				sumb = sumb+tb;
			}
			
		}
		if(Math.abs(a-b)==1) {
			a++;
			ta++;
			suma = suma + ta;
		}
		System.out.println(suma + sumb);
	}    

}	       
	
	