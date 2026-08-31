import java.util.*;
//import java.lang.String;
//import java.math.*;
/**
* @author lavlesh
*
*/
public class solution {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
      int a=in.nextInt();
      int b=in.nextInt();
     int hr=a;
     while(a>=b)
     {
  	   int temp=a/b;
    	 hr=hr+temp;
    	 a=a/b+a%b;
     }
      System.out.print(hr);

	}
	}