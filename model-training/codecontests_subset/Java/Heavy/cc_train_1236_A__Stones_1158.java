/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/
import java.util.*;
import java.lang.*;
public class Stones
{
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=sc.nextInt();
	    int i,j,a,b,c,s=0;
	    for(i=0;i<t;i++)
	    { a=sc.nextInt();
	    b=sc.nextInt();
	    c=sc.nextInt();
	    s=0;
	        if(b==0)
	        s=0;
	        else
	        { while(b>0)
	            {  if(c>1)
	                { s=s+3;
	                    b--;
	                    c=c-2;
	                }
	                else if(a>0&&b>1)
	                { s=s+3;
	                    a--;
	                    b=b-2;
	                }
	                else
	                break;
	            }
	        }
	        	System.out.println(s);
	    }
	
	}
}
