import java.util.Scanner;
public class first {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String s = scnr.next();
		String one ="";
		String two ="";
		String three="";
		boolean hasOne=false;
		boolean hasTwo = false;
		for (int i=0; i<s.length(); i=i+2){
			if (s.charAt(i)=='1'){
				if (one.equals("")){
					System.out.print("1");
					hasOne = true;
					one = "1";
					
				}
				else {
					System.out.print("+1");
				}
				
				
			}
		}
		if (hasOne==false){
		
		for (int i=0; i<s.length(); i=i+2){
			if (s.charAt(i)=='2'){
				if (two.equals("")){
					System.out.print("2");
					hasTwo = true;
					two="2";
					
				}
				else {
					System.out.print("+2");
				}
				
				
			}
		}
		}
		else {
			for (int i=0; i<s.length(); i=i+2){
				if (s.charAt(i)=='2'){
					System.out.print("+2");
			}
		}
		}
		if (hasOne == false && hasTwo == false){
		for (int i=0; i<s.length(); i=i+2){
			if (s.charAt(i)=='3'){
				if (three.equals("")){
					System.out.print("3");
					three = "3";
					
				}
				else {
					System.out.println("+3");
				}
				
				
			}
		}
		}
		else{
			for (int i=0; i<s.length(); i=i+2){
				if (s.charAt(i)=='3'){
					System.out.print("+3");
				}
			}
		}
	}

}
