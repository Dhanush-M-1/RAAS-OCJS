import java.util.*;
public class fifth
{ 
    public static void main(String[] args) 
    { 
         Scanner scan = new Scanner(System.in);
 		ArrayList<Integer> a = new ArrayList<Integer>(5);
 	 String s1 = scan.nextLine();
 	 
         for( int i =0 ;i<s1.length();i++) {
        	 if(s1.charAt(i)=='+') {continue;}
        	 a.add( (int)s1.charAt(i));
         }
         a.sort(null);
         String s2 = "";
         for( int i =0 ;i<a.size();i++) {
        	 int a1 = a.get(i);
        	 s2+= (char)a1;
        	 if(i!=(a.size()-1)) {
        		 s2+='+';
        	 }
         }
        	 System.out.println(s2);
         
      


 
}
}
