import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len=0;
        int no_participants=0;
        while(in.hasNextLine()){
            String str=in.nextLine();
            
            if(str.charAt(0)=='+'){
                no_participants++;                    
            }
            else if( str.charAt(0)=='-'){
                no_participants--;
            }
            else{
                int str_len= str.length()-(str.indexOf(':')+1);
                len += no_participants*str_len;
            }
        }
    System.out.println(len);    
        
    }
}
