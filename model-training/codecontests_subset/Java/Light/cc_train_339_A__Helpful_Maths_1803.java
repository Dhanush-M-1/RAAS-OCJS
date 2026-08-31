/* IMPORTANT: Multiple classes and nested static classes are supported */

import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;

public class TestClass {
    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int one = 0;
        int two = 0;
        int thr = 0;

        for(int i = 0; i < line.length(); i+=2) {
            if(line.charAt(i)=='1')
                one++;
            else if(line.charAt(i)=='2')
                two++;
            else
                thr++;
        }
        String result="";
        for(int i=0;i<=line.length()/2;i++) {
            
            if(one>0) {
                one--;
                result+="+1";
            } else if (two > 0) {
                two--;
                result+="+2";
            } else {
                result+="+3";
            }
            
        }
        
        System.out.println(result.substring(1));
    }
}