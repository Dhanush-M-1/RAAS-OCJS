import java.util.*;
import java.io.*;
public class Main{
   static Scanner sc;// = new Scanner(System.in);
 static PrintStream ps;
 public static void main(String[] args) throws FileNotFoundException {
  sc = new Scanner( System.in );
  ps = System.out;
  int num = 0, ans = 0;
  while ( sc.hasNext() ) {
   String cmd = sc.nextLine();
   if ( cmd.startsWith("+") ) {
    num++;
   } else if ( cmd.startsWith("-") ) {
    num--;
   } else {
    ans += num * cmd.substring( cmd.indexOf(':')+1 ).length();
   }
  }
  ps.println( ans );
 }
}