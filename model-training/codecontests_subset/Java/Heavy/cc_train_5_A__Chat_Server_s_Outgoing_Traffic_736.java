


import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;
import javax.print.DocFlavor;



public class aa {
    
 
    
         public static void main(String[] args) {
  
 
          
   
             Vector<String> v=new Vector<String>();
             Scanner sc=new Scanner(System.in);
             
            String s;
            char[]c;
            int n=0;
            while(sc.hasNextLine())
            {
                s=sc.nextLine();
              //  System.out.println("s= "+s);
                c=s.toCharArray();
                
                
                  
                if(c[0]=='+')
                {
                    
                    v.add(String.valueOf(c,1,c.length-1));
                }
                else
                    if(c[0]=='-')
                    {
                        v.remove(String.valueOf(c,1,c.length-1));
                    }
                
                else
                    {
                        String[]k=s.split(":");
                        if(k.length>1)
                        {
                            n=n+(k[1].length()*v.size());
                        }
                        
                        
                    }
                        
              
                
            }
             System.out.println(n);
       
    }
         
}
