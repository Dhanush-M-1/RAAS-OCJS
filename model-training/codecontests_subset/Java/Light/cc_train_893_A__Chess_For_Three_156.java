  import java.util.Scanner ;           
public class AccessModifires {
  

    public static void main(String[] args) {
        Scanner o = new Scanner (System.in) ; 
        int n = o.nextInt()   ;
        int y = 3 ; 
        boolean flag = true ; 
        while(n-- > 0  ){
            int x = o.nextInt();
            if(x == y )
                flag = false ;
            else 
                y = 6 - x - y ; 
            }
        System.out.println(flag == true ? "Yes" : "NO");
        }
      
        
}
