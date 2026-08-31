import java.io.*;
import java.math.*;
public class B
{
	public static void main(String args[]) throws IOException
	{
	
	   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	   BigInteger ax,ay,bx,by,cx,cy,AB,BC,CD,DE,EF,FG;
	   
	   String s[]=br.readLine().trim().split(" ");
	   
	   ax=new BigInteger(s[0]);
	   ay=new BigInteger(s[1]);
	   bx=new BigInteger(s[2]);
	   by=new BigInteger(s[3]);
	   cx=new BigInteger(s[4]);
	   cy=new BigInteger(s[5]);
	   
	   
	   AB=ax.subtract(bx).multiply(ax.subtract(bx));
	   BC=ay.subtract(by).multiply(ay.subtract(by));
	   AB=AB.add(BC);
	   CD=cx.subtract(bx).multiply(cx.subtract(bx));
	   DE=cy.subtract(by).multiply(cy.subtract(by));
	   CD=CD.add(DE);
	   
	   DE=by.subtract(ay);
	   BC=cx.subtract(bx);
	   EF=cy.subtract(by);
	   FG=bx.subtract(ax);
	   
	   
	   if(AB.compareTo(CD)==0)
	   {
		   if(DE.multiply(BC).compareTo(EF.multiply(FG))==0)
			   System.out.println("No");
		   else
			   System.out.println("Yes");
	   }
	   else
		   System.out.println("No");
	   
	   
    }
}