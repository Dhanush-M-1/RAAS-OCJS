import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int length = in.nextInt();
	    int counter = 0;
	    String str = in.next();
	    for (int i = 0; i < length; i++) {
	    	if (str.charAt(i) == '0')
	    		counter--;
	    	else
	    		counter++;
		}
		if (counter != 0) {
			System.out.println(1);
			System.out.println(str);
		} else {
			System.out.println(2);
			System.out.print(str.substring(0,1)+' ');
			System.out.println(str.substring(1));
		}
    }
}