import java.util.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader=new Scanner(System.in);
	
		int a= reader.nextInt();
		int b= reader.nextInt();
		int c= reader.nextInt();
		int t=a+b+c;
		int tab[]= {a,b,c};
		Arrays.sort(tab);
	   if (tab[0]+tab[1]==tab[2]) {
		   System.out.print("Yes");
	   }
	   else {
		   System.out.print("No");
	   }
		
		
	}
	
	

}