import java.io.*;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;



public class aa {

public static void main(String[] args) {

    
    
    try{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    
    String input="";
    
    int count = 0 ;
    int traf =0;
    String[]s ;
    String mess;
    
    while ((input = br.readLine() )!= null)
    
    {
        if(input.charAt(0)=='+')
        count++;
        else if(input.charAt(0)=='-')
        count--;
        else 
        {
            s=input.split(":");
            if(s.length>1)
            {mess= s[1];
            traf=traf+(mess.length()*count);}
            
        }
        
        
        
        
    }
        System.out.println(traf);
        
        
    }
    catch(IOException e)
    {
        e.printStackTrace();
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}}