import java .util.Scanner;
public class Baraa {
 

public static void main(String[] args) {
Scanner in = new Scanner(System.in);
int n=in.nextInt();
String b=in.next();
String v[]=b.split("");
int s=0,j=0,c=1;
boolean e=false;// , m=true;
    for (int i = 0; i < v.length; i++)
    {
     s=0;j=0;c=1;
            if(v[i].equals("*"))
            {   
                j=i;
                for (; j < v.length; j+=c)
                {
                  if(v[j].equals("*"))
                          s++; 
                
                      
                  else
                  {
                  c++;
                  j=i;
                  s=1;
                  }
                   if(s==5)
                           {e=true;break;}
                  //m=false;
                }
            }
             if(e)
                 break;
    }
    
    
    if(e)
            System.out.println("yes");
else
        System.out.println("no");

}}