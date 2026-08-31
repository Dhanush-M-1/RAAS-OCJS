import java.util.Scanner;
import java.util.TreeSet;


public class A {
    public static void main(String[] args) {
        Scanner sanat  = new Scanner(System.in);
        int n =sanat.nextInt();
        String s = sanat.next();
        int []x = new int[s.length()+1];
        int k = 0;
        TreeSet<Integer> ts1 = new TreeSet<Integer>();
        TreeSet<Integer> ts2 = new TreeSet<Integer>();
        for (int i = 1; i <= s.length(); i++) {
            if(s.substring(i-1, i).equals("*")){
                x[++k]=i;
                ts1.add(i);
            }
        }
        for (int i = 1; i <k; i++) {
            for (int j = i+1; j <=k; j++) {
                ts2.add(Math.abs(x[i]-x[j]));
            }
        }
        for (int i =1; i <= k; i++) {
            for (Integer in : ts2){ 
                int cnt = 0;
                int d = x[i];
                while(ts1.contains(d+in)){
                    d+=in;
                    cnt++;
//                  System.out.println(d);
                    if(cnt>=4){
                        System.out.println("yes");
                        return;
                    }
                }
            }
        }
        System.out.println("no");
//      for (int l =1; l<k-1; l++) {
//          for (int i=l+1; i<k; i++) {
//              int cnt = 0;
//              int d = x[i]-x[l];
//              System.out.println(d+" mee");
//              for (int j =i+1; j<=k; j++) {
//                  if(d==x[j]-x[j-1]){
//                      cnt++;
//                      System.out.println(cnt);
//                      if(cnt>=4){
//                          System.out.println("yes");
//                          return;
//                      }
//                  } else{
//                      cnt = 0;
//                      
//                      break;
//                  }
//              }       
//          }
//      }
    }
}
