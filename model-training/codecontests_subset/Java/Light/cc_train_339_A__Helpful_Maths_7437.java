import java.util.*;
public class MyClass {
    public static void main(String args[]) {
        Scanner s=new Scanner(System.in);
        String[] s1=s.next().split("[+]");
        String s2="";
        Arrays.sort(s1);
        for(int i=0;i<s1.length;i++)
        {   if(i!=s1.length-1) 
            s2+=s1[i]+"+";
            else
             s2+=s1[i];
        }
        System.out.println(s2);
         
    }
}