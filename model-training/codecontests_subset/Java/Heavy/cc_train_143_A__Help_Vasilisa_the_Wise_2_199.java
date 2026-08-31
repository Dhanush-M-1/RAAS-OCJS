import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class HelpVasilisaTtheWise2 {
	public static void main(String[] args) throws IOException {
	  Scanner sc = new Scanner(System.in);
		
	  //READ----------------------------------------------------
    int r1 = sc.nextInt(), r2 = sc.nextInt(), c1 = sc.nextInt(), c2 = sc.nextInt(), d1 = sc.nextInt(), d2 = sc.nextInt();
    
    String res = "-1";
    
    label : for (int i = 1; i <= 9 && res.equals("-1"); i++){
      for (int j = 1; j <= 9; j++){
        if(j==i)
          continue;
        for (int k = 1; k <= 9; k++){
          if(k==i || k==j)
            continue;
          for (int l = 1; l <= 9; l++){
            if(l==i || l==j || l==k)
              continue;
            if(i+j==r1 && k+l==r2 && i+k==c1 && j+l==c2 && i+l==d1 && j+k==d2){
              res = i + " " + j + "\n" + k + " " + l;
              continue label;
            }
          }
        }
      }
    }
		
    System.out.println(res);
    
    //CLOSE----------------------------------------------------
    sc.close();
	}
}