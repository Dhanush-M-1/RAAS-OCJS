import java.util.Scanner;


public class task{
	public static void main(String args[]) {
		Scanner s= new Scanner(System.in);
		String password=(String) s.nextLine();
		int n=(int) s.nextInt();
		boolean first=false,second=false;
		for(int i=0;i<n;i++) {
			String CorrentString= (String) s.next();
			//System.out.println(CorrentString);
			if((char) CorrentString.charAt(0)==(char) password.charAt(1)) second=true;
			if((char) CorrentString.charAt(1)==(char) password.charAt(0)) first=true;
			if(second & first|| CorrentString.equals(password)) {
				System.out.println("YES");
				return;
			}
		}
		if(second & first) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
		
		
	}
}