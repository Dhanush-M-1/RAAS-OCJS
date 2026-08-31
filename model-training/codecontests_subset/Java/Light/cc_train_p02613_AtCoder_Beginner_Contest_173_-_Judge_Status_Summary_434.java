import java.util.*;
public class Main{
  public static void main(String[] args)
  {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    HashMap<String,Integer> map=new HashMap<String,Integer>();
    LinkedList<String> s1=new LinkedList<String>();
    map.put("AC",0);
    s1.add("AC");
    
    map.put("WA",0);
     s1.add("WA");
     map.put("TLE",0);
     s1.add("TLE");
     map.put("RE",0);
     s1.add("RE");
	for(int i=0;i<t;i++)
    {
      String s=sc.next();
      

        map.put(s,map.get(s)+1);
     
    }
    for(int k=0;k<map.size();k++)
    {
      System.out.println(s1.get(k)+" x "+map.get(s1.get(k)));
    }
  }
}