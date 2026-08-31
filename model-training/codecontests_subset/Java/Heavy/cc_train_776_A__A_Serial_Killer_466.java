import java.util.*;


public class main {
   
 	public static void main(String[] args) {
 	    
		Scanner in = new Scanner(System.in);
	    String s1 = in.next();
	    String s2 = in.next();
	    int n = in.nextInt();
	    System.out.println(s1+ " " + s2);
	    for(int i = 0; i < n ;i++){
	        String s3 = in.next();
	        String s4 = in.next();
	        if(s3.compareTo(s1)==0) {
	            System.out.println(s4 + " " + s2);
	            s1=s4;
	        }
	        else if(s3.compareTo(s2)==0) {
	            System.out.println(s1 + " " + s4);
	            s2=s4;
	        }
	        else if(s4.compareTo(s1)==0) {
	            System.out.println(s3 + " " + s2);
	            s1=s3;
	        }
	        else if(s4.compareTo(s2)==0) {
	            System.out.println(s1 + " " + s3);
	            s2=s3;
	        }
	    }
	    
	}

}
 