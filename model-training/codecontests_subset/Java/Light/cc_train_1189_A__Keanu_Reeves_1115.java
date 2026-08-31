import java.util.Scanner;
public class keanu_reeves {
	public static void main(String[] args) {
	       Scanner sc = new Scanner(System.in);
	       int n=sc.nextInt();
	       int count1=0,count2=0;
	       String s=sc.next();
	       for(int i=0;i<s.length();i++)
	       {
	    	   if(s.charAt(i)=='0')
	    		   count1++;
	    	   else if(s.charAt(i)=='1')
	    		   count2++;
	       }
	       if(count1!=count2)
	       {
	    	   System.out.println("1");
	    	   System.out.println(s);
	       }
	    	   
	       else
	       {
	    	   System.out.println("2");
	    	   System.out.print(s.charAt(0)+" ");
	    	   for(int i=1;i<s.length();i++)
		    	   System.out.print(s.charAt(i));
	    	   
	       }
	    	   
	}
}
