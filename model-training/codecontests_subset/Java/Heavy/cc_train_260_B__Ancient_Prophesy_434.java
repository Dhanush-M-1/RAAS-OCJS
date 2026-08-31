import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.*;

public class apcalypse {

    

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
         Scanner s = new Scanner(System.in);
        String pattern = s.nextLine();
        int indx1  =0;
        int count = 0;
        int l = pattern.length();
        String aMax = "" ; int max =0;
        Map correctDate = new HashMap();
        
        while(true)
        {
            if(count>=l) break;
            int indx2 = pattern.indexOf( '-', count );
            count = indx2+1;
            //System.out.println(indx2+" "+count);
            if(indx2>=2 && l - indx2>=8)
            {
                
                String t = pattern.substring(indx2-2,indx2+8);
                //System.out.println(t);
            
                boolean isCorrect = checkDate(t);
                //System.out.println(isCorrect);
                
                if(isCorrect == true)
                {
                    
                    //System.out.println(correctDate.get(t));
                    if(correctDate.get(t)==null)
                    {   
                        //ystem.out.println("before "+correctDate.get(t)+" "+ t);
                        correctDate.put(t,1);
                        //System.out.println(correctDate.get(t));
                        if(max<1){ max = 1; aMax = t;}
                        
                    }
                    
                    else{
                        //System.out.println("jkljkl");
                        correctDate.put(t,(Integer)correctDate.get(t)+1);
                        if(max<(Integer)correctDate.get(t))
                            {
                            //System.out.println("jkljkl");
                            max =  (Integer)correctDate.get(t);
                            aMax = t;
                            }
                      }
                }
        }           
        else
        {
           break;
        }
            

    }
        System.out.println(aMax);
    }
    
    public static boolean checkDate(String date)
    {
        if(date.charAt(5)!='-') return false;
        int a, b, c;
        try
        {
         a = Integer.parseInt(date.substring(0, 2));
         //System.out.println(a);
        
        }
        catch(NumberFormatException nfe)
        {
        return false;
        }
        
        try
        {
            b = Integer.parseInt(date.substring(3, 5));
            //System.out.println(b);
        }
        catch(NumberFormatException nfe)
        {
        return false;
        }
        
        try
        {
            c = Integer.parseInt(date.substring(6, 10));
            //System.out.println(c);
        }
        catch(NumberFormatException nfe)
        {
        return false;
        }
        //System.out.println(b);
        if(c<2013||c>2015) return false;
        if(b<1||b>12) return false;
        if(a<1) return false;
        if(a>28&&b==2) return false;
        if(a>30&&(b==2||b==4||b==6||b==9||b==11)) return false;
        if(a>31&&(b==1||b==3||b==5||b==7||b==8||b==10||b==12)) return false;
        return true;
        
        
        
    }

}
