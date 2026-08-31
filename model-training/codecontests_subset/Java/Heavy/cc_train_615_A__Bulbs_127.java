import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CodeForces{
    
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        
        ArrayList <Integer> list = new ArrayList<Integer>();
        for(int i=1;i<=m;i++){
            list.add(i);
        }
        
        for(int i=1;i<=n;i++){
        
            int x1 = s.nextInt();
        for(int j=1;j<=x1;j++){
            
            int x2 = s.nextInt();
            if(list.contains(x2)) {list.remove(list.indexOf(x2));}
        }
        
        }
        
    
        if(list.size()==0) System.out.println("YES");else System.out.println("NO");
}
}