import java.util.*;

public class Maths {
   public static void main(String args[])
   {
	   Scanner s=new Scanner(System.in);
	   String k=s.nextLine();
	   int len=k.length();
	   
	   int k1=0,k2=0,k3=0;
	   for(int i=0;i<len;i++)
	   {
		   char c=k.charAt(i);
		   if(Character.isDigit(c))
		   {
			   if(c=='1')
				   k1++;
			   else if(c=='2')
				   k2++;
			   else if(c=='3')
				   k3++;
		   }
		   
	   }
	   String m="";
	   for(int i=0;i<k1;i++)
	   {
		   m=m+"1";
		   m=m+"+";
	   }
	
	   
	   for(int i=0;i<k2;i++)
	   {
		   m=m+"2";
		   m=m+"+";
	   }
	   
	   
	   for(int i=0;i<k3;i++)
	   {
		   m=m+"3";
		   m=m+"+";
	   }
	   
	   m=m.substring(0, len);
       System.out.println(m);
   }
}
