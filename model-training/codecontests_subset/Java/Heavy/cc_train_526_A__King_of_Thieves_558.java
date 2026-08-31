
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Al_Deeb
 */
public class ss {
    
    public static void main (String []args)
    {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        String s=sc.next();
      char[] f=s.toCharArray();
      
       // System.out.println(s);
      int max=n/4;
      int ff=1;
        for (int i = 0; i < n; i++) {
            
            if(n-i<5) {ff=0;break;}
            else
            if(f[i]=='*')
            {
                for (int j = i+1; j <= max+i; j++) {
                    int len =j-i;
                    if(j<n&&f[j]=='*')
                    {
                        for (int k = 1; k <= 3; k++) {
                            
                            if((j+len*k)>=n||f[j+len*k]=='.')
                            { 
                                ff=0;
                                break;
                            }
                            else
                                ff=2;
                        }
                        if(ff==2)
                            break;
                    }
                }
                
                if(ff==2)
                            break;
            }
            
        }
  
        if(ff==2)
            System.out.println("yes");
        else
            System.out.println("no");
        
        
    }
    
}
