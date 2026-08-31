

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author placement
 */
public class JavaApplication8 {
    
    static String p = "";
   // static ArrayList<String> p = new ArrayList();
    static int ctr = 0;
    static HashMap<Integer, Integer> start = new HashMap();
    static HashMap<Integer, Integer> stop = new HashMap();
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int m = sc.nextInt();
       int i;
       int n = sc.nextInt();
       for(i=0;i<n;i++) p = p + 'E';
       sc.nextLine();
       while(m>0) {
           String line = sc.nextLine();
           String[] tmp = line.split(" "); 
           if(line.contains("alloc")) { 
               System.out.println(alloc(Integer.valueOf(tmp[1])));
           } else if(line.contains("erase")) {
               String r = erase(Integer.valueOf(tmp[1]));
               if(!r.equals("OK")) {
                   System.out.println(r);
               }
           } else {
               defragment();
           }
          //  System.out.println(p);
            //System.out.println(start);
             //System.out.println(stop);
           m--;
       }
       
    }
    
    static String alloc(int n) {
        int i;
        String s = "";
        for(i=0;i<n;i++) {
            s = s + 'E';
        }
        int index = p.indexOf(s);
        if(index!=-1) {
            ctr++;
            for(i=index;i<index+n;i++) {
                StringBuilder p1 = new StringBuilder(p);
                p1.setCharAt(i, 'F');
                p = new String(p1);
            }
            start.put(ctr, index);
            stop.put(ctr, index+n);
            return String.valueOf(ctr);
        } else {
            return "NULL";
        }
    }
    
    static String erase(int n) {
        int i;
        if(start.containsKey(n)) {
            int s = start.get(n);
            int e = stop.get(n);
            for(i=s;i<e;i++) {
              StringBuilder p1 = new StringBuilder(p);
                p1.setCharAt(i, 'E');
                p = new String(p1);
            }
            start.remove(n);
            stop.remove(n);
            return "OK";
        } else {
            return "ILLEGAL_ERASE_ARGUMENT";
        }
    }
    
    static void defragment() {
        int i;
        int j = p.indexOf('E'),k,l;
        for(k=1;k<=ctr;k++) {
            if(start.containsKey(k)&&stop.containsKey(k)) {
            i = start.get(k);
            l = stop.get(k);
            int s1 = j;
            while(i<l&&i>j&&j!=-1) {
                 StringBuilder p1 = new StringBuilder(p);
                 char tmp = p.charAt(j);
                 p1.setCharAt(j, p.charAt(i));
                 p1.setCharAt(i, tmp);
                 p = new String(p1);
                 j++;
                 i++;
            }
            int e1 = j;
            if(s1!=e1) {
            start.put(k, s1);
            stop.put(k, e1);
            }
            }
        }
        
    }
}
