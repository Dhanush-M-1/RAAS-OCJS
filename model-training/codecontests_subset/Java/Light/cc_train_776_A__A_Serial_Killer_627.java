// CoDE deVELOPed uNDEr AcE proDUcTiONS (enJOY!!!!)
import java.util.*;
public class Ace
{
   public static void main(String[] arga)
   {
   Scanner sc=new Scanner(System.in);
 String dead,rplce,st1=sc.next(),st2=sc.next();
 int i,n=sc.nextInt();
 System.out.println(st1+" "+st2);
 for(i=0;i<n;i++)
 {
     dead=sc.next();
     rplce=sc.next();
     if(dead.equals(st1))
     {   
        st1= rplce;
     }
     else if(dead.equals(st2)) st2=rplce;
     System.out.println(st1+" "+st2);
 }
 
   
   }
}

// CoDE deVELOPed uNDEr AcE proDUcTiONS (enJOY!!!!)