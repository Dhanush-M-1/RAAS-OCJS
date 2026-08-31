import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class Wizards {
	public static void main(String[] args) throws IOException {
	  Scanner s = new Scanner(System.in);
		
	  //READ----------------------------------------------------
    int n = s.nextInt(), x = s.nextInt(), y = s.nextInt();
    
		//SOLVE----------------------------------------------------
    int l = 0;
    int r = 1000000;
    while(r>l+1){
      int m = (l+r)/2;
      //System.out.println(m);
      if((m+x)*100>=y*n)
        r =m;
      else
        l =m;  
    }
		long res = r;
		if((l+x)*100>=y*n)
		  res=l;
		else if((l+1+x)*100>=y*n)
      res=l+1;
		
		
    //CLOSE----------------------------------------------------
    System.out.println(res);
    s.close();
	}
}