//package javaapplication5;
// java.util >> is api

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
//import java.util.Scanner;

import javax.swing.JOptionPane;

public class JavaApplication5 {

    
    public static void main(String[] args) throws IOException {
Scanner in = new Scanner(System.in);
int n = in.nextInt(),sum=0;
ArrayList<Integer> aa = new ArrayList<Integer>(n);
 HashMap<Integer,Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int c1 = in.nextInt();
             aa.add(c1);
             int c2 = in.nextInt();
             hm.put(c2,hm.get(c2)==null?1:hm.get(c2)+1);
            
        }
  for (int i = 0; i < n; i++) {
            if(hm.containsKey(aa.get(i)))
                sum+=hm.get(aa.get(i));
            
        }


        System.out.println(sum);
        
    }

}
