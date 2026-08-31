import java.util.*;
import java.lang.*;
import java.io.*;
 
/* Name of the class has to be "Main" only if the class is public. */
public final class Ideone
{
    public static boolean divide(String st1,String st2){
        int len = st1.length();
        // System.out.println(st1+" "+st2);
        if(len%2==1){
            if(st1.equals(st2))
            return true;
            else
            return false;
        }
        else{
            if(st1.equals(st2))
            return true;
            else{
                String st11 = st1.substring(0,len/2);
                String st12 = st1.substring(len/2,len);
                String st21 = st2.substring(0,len/2);
                String st22 = st2.substring(len/2,len);
                if((divide(st11,st22)&&divide(st12,st21))||(divide(st11,st21)&&divide(st12,st22))){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner ob = new Scanner(System.in);
		String st1 = ob.next();
		String st2 = ob.next();
		
		if(divide(st1,st2))
		System.out.println("YES");
		else
		System.out.println("NO");
	}
}