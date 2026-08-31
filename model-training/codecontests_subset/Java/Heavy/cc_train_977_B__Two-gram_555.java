import java.util.*;
public class Gramos
{
    // 977A
    public static void main(String [] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String cad = "";
        n = n -(n-1);
        while(n>=0){
            cad = in.nextLine();
            n -- ;
        }
        
        
        String s = "";
        Integer max = 0;
        String act = "";
        Integer can ;
        for(int i = 0;i<cad.length()-1;i++){
            can = 0;
            act = cad.substring(i, i+2);
            for(int j = 0;j<cad.length()-1;j++){
                String com = cad.substring(j,j+2);
                if(act.equals(com)) can++;
            }
            if(can > max) {
                max = can;
                s = act;
            }
        }
        System.out.println(s);
    }
}
