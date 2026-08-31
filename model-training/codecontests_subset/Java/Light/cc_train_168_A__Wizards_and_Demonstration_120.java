import java.util.Scanner;

public class Main {
 public static void main(String[] args){
	 Scanner sc = new Scanner(System.in);
	 double n=sc.nextDouble();
	 int x=sc.nextInt();
	 double y=sc.nextDouble();int c=0;double key=(y*n)/100;
	 while(x<key){
		 x++;
		 c++;
	 }
	
	System.out.println(c);
 }
}
