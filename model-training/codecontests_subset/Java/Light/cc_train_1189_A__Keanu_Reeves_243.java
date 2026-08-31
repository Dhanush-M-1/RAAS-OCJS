import java.util.Scanner;

public class KeanuReaves {

	public static void main(String[] args) {

		 Scanner sc = new Scanner(System.in);
	        int n = sc.nextInt();
	        String s = sc.next();
	        int o = 0;
	        int z = 0;
	        for (char c : s.toCharArray()) {
	            if (c == '0')
	                z++;
	            else
	                o++;
	        }
	 
	        if (o != z) {
	            System.out.println(1);
	            System.out.println(s);
	        }
	        else{
	            System.out.println(2);
	            System.out.println(s.charAt(0) + " " + s.substring(1));
	        }
         sc.close();

	}

}
