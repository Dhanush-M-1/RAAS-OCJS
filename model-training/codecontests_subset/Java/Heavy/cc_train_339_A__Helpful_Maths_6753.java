/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HOME
 */
import java.util.*;
import java.io.*;
public class AscendMath {
    public static void main(String[] args) {
      //Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();  // Scanner has functions to read ints, longs, strings, chars, etc.
        
        String[] ss = s.split("\\+");
        int[] sss = new int[ss.length];
        for(int i = 0 ; i <  ss.length ; i++) { 
            sss[i] = Integer.parseInt(ss[i]);
        }
        Arrays.sort(sss);
        
        System.out.print(sss[0]);
        for(int i = 1; i < sss.length ; i++) { 
            System.out.print("+");
            System.out.print(sss[i]);
        }
        System.out.println();
    }
}