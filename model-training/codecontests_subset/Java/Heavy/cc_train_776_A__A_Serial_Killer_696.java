import java.util.*;
import java.util.PriorityQueue;
import jdk.nashorn.internal.objects.NativeArray;

public class JavaApplication7 {
      public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          String s1 = input.next();
          String s2 = input.next();
          int n=input.nextInt();
          Vector<String> vec = new Vector<String>();
          vec.addElement(s1+" "+s2);
          for(int i=1;i<=n;i++)
          {
              String ss = input.next();
              String ss2 = input.next();
             
              if(s1.equals(ss)) s1=ss2;
              else s2=ss2;
              vec.addElement(s1+" "+s2);
          }
          for(int i=0;i<vec.size();i++)
              System.out.println(vec.elementAt(i));
          
          
      }}
