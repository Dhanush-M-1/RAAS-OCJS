import java.util.*;
 class Main
{
  public static void main(String args[])
   {
     Scanner sc=new Scanner(System.in); 
       int n=sc.nextInt();
     HashMap<String,Integer> hm=new HashMap<String,Integer>();
     hm.put("AC",0);
     hm.put("WA",0);
     hm.put("TLE",0);
     hm.put("RE",0);
     while(n-->0)
     {
       String s=sc.next();
      
          hm.put(s,1+hm.get(s));
     }
   System.out.println("AC"+" x "+hm.get("AC"));
   System.out.println("WA"+" x "+hm.get("WA"));
System.out.println("TLE"+" x "+hm.get("TLE"));
 System.out.println("RE"+" x "+hm.get("RE"));
   }
}