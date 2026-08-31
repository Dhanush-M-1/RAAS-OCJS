import java.io.*;
import java.util.*;

import javax.lang.model.type.PrimitiveType;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String l;
        String [] sp;
        int res = 1;
//      boolean f = false;
//      int [] ispre = new int[n + 5];
//      int counter = 0;
//      for (int i = 2; i < n; i++) {
//          res = 1;
//          f = false;
//          ispre = new int[n + 5];
//          ispre[0] = 1;
//          for (int j = 1; j < n - 1; j++) {
//              ispre[j] = (ispre[j - 1] * i) % n;
//          }
//          
//          for (int j = 1; j < ispre.length; j++) {
//              if((ispre[j] - 1) % n == 0){
//                  f = true;
//                  break;
//              }
//          }
//          ispre[n - 1] = (ispre[n-2] * i )% n;
//          if(!f && (ispre[n-1]- 1 ) % n == 0)
//              counter++;
//              
//      }
//      System.out.println(counter % n);
        
        l = br.readLine();
        int a = 0;
        int i = 0;
        for (int j = 0; j < l.length(); j++) {
            if(l.charAt(j) == 'A'){
                a++;
            }else if(l.charAt(j) == 'I')
                i++;
        }
        if(i == 0)
            System.out.println(a);
        else if(i == 1)
            System.out.println(1);
        else 
            System.out.println(0);
    }
}