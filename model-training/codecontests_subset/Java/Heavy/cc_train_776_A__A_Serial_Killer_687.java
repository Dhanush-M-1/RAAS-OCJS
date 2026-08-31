import java.util.Scanner;

public class ASerialKiller {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
        String sa = scan.next();
        int n = scan.nextInt();
    	scan.nextLine();
        System.out.println(s+ " " +sa);
        
        int i=0;
        while(i!=n) {
        	String s1 = scan.next();
            String s2 = scan.next();
            if(s1.equals(s)) {
            	System.out.println(s2+ " " +sa);
                s=s2;
                }
            else {
                System.out.println(s+ " " +s2);
                sa=s2;
            }
            i++;
        }
      
	}

}
