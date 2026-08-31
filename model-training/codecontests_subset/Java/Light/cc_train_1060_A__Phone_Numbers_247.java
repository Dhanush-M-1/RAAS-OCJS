import java.util.*;
public class phonenumber
{
  public static void main(String args[])
  {
     Scanner as=new Scanner(System.in);
	 int n=as.nextInt();
	 String s=as.next();
	 if(n<11)
		 System.out.println(0);
	 else
	 {
		 int flag=0;int c=0;
		 for(int i=0;i<n;i++){
			 if(s.charAt(i)=='8'){
				 c++;
			 }
		 }
		 if(c==0)
			 System.out.println(0);
		 else{
			   System.out.println( min(n/11,c));
		         
		 }
	 }
  }
  static int min(int a,int b)
  {
	  if(a<b)
		  return a;
	  else
		  return b;
  }
}
		       
		 