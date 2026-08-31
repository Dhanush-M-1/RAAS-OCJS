
import java.util.*;
public class A_Serial_Killer {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		String name1 = input.next();
		String name2 = input.next();
		int n = input.nextInt();
		System.out.println(name1+" "+name2);
		for(int i=0;i<n;i++){
			String name3 = input.next();
			String name4 = input.next();
			if(name3.equals(name1)){
				name1 = name2;
				name2 = name4;
				System.out.println(name1+" "+name2);
				}
			else{
				name2 = name4;
				System.out.println(name1+" "+name2);
			}
			
		}
		input.close();
	}
}