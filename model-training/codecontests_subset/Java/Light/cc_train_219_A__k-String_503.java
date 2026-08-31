import java.util.*;

public class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc=new Scanner(System.in);
        int k=Integer.parseInt(sc.nextLine());
        int a[]=new int[26];
        String s=sc.nextLine();
        for(int i=0;i<s.length();i++)
        	a[s.charAt(i)-'a']++;
        
        int Flag=0;
        String t="";
        for(int i=0;i<26;i++){
        	if(a[i]%k==0){
        		int x=a[i]/k;
        		for(int j=0;j<x;j++)
        			t=t+(char)(i+'a');
        	}
        	else
        	{Flag=1;break;}
        }
        String u="";
        if(Flag==0)
        {
        	for(int i=0;i<k;i++)
        		u=u+t;
        	System.out.println(u);}
        else
        	System.out.println("-1");
        
    }
}
