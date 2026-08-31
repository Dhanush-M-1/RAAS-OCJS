import java.util.Scanner;

public class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x,y,z,count1,count2;
		count1 = count2 = 0;
		
		while(sc.hasNext()){
			String[] integer = sc.next().split(",",0);
			
			x = Integer.parseInt(integer[0]);
			y = Integer.parseInt(integer[1]);
			z = Integer.parseInt(integer[2]);
			
			if((x * x) + (y * y) == (z * z))count1++;
			if(x == y)count2++;
		}
		System.out.println(count1);
		System.out.println(count2);
		
		sc.close();
	}
}