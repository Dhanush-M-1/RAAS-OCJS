
    import static java.lang.System.exit;
    import java.util.ArrayList;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Scanner; 
    import java.util.*;
    /**
     *
     * @author abdelmagied
     */
    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.Comparator;
    import java.util.HashMap;
    import java.util.LinkedList;
    import java.util.List;
    import java.util.Map;
    import java.util.Scanner;




    
public class JavaApplication1 { 
    
   
      public static void main(String[] arg){   
          Scanner sc = new Scanner(System.in); 
          int r1 = sc.nextInt() , r2 = sc.nextInt() , c1 = sc.nextInt() , c2 = sc.nextInt() , d1 = sc.nextInt() , d2 = sc.nextInt();
          
          for(int i = 1 ; i < 10 ; i++){
              int x = i;
              int w = r1 - x;
              int y = c1 - x;
              int z = c2 - w;
              if(x+z == d1 && w+y == d2 && y + z == r2 && x + w == r1 && x!= y && z!=w && x!=z && y!=w && x!=w && y!=z && w < 10 && z < 10 && y <10 && w!=0 && y!=0 && z!=0){
                  System.out.println(x + " " + w);
                  System.out.println(y + " " + z);
                  exit(0);
              }
          }
          System.out.println(-1);
      }
}


 