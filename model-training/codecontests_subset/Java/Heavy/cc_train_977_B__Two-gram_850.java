 import java.util.*;
        import java.io.*;
        public class abc
        {
            public static void main(String args[])
            {
                String a="",b="",c="";
            int max=0,count=0,x,y;
            Scanner sc=new Scanner(System.in);
           int l=sc.nextInt();
	    String s=sc.next();
            for(x=0;x<(l-1);x++)
            {
                b=s.substring(x,x+2);
                count=0;
                for(y=0;y<(l-1);y++)
                {
                    c=s.substring(y,y+2);
                    if(b.equals(c))count++;
                }
                if(count>max)
		{

                a=b;
		max=count;
		}
            }
            System.out.println(a);
            
        }
        }
