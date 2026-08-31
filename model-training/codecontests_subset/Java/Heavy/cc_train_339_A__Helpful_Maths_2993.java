import java.util.Scanner;

public class HelpfulMaths {

	
	 public static void main(String[] args) {
		
	      Scanner sc=new Scanner(System.in);
	      
	      String str=sc.nextLine();
	      String str2="";
	      int c[]=new int[4];
	      
	      if(str.length()==1)
	      {
	    	  System.out.println(str);
	    	  return;
	      }
	      
	      for(int i=0;i<str.length();i=i+2)
	      {
	    	 c[str.charAt(i)-48]++;
	    	 
	    	 
	      }
		 
	      
	      
	      for(int i=0;i<c[1];i++)
	    	  str2+="1+";
	      for(int i=0;i<c[2];i++)
	    	  str2+="2+";
	      for(int i=0;i<c[3];i++)
	    	  str2+="3+";
	      
	      
	      
	      str2=str2.substring(0,str2.length()-1);
	      
	      
	      
          System.out.println(str2);
	      
	      
	}
	
}
