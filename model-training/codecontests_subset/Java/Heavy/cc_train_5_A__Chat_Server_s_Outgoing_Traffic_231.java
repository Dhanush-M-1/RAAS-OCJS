
import java.util.*;


public class Test {
 
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<String> a= new ArrayList<>();
        int p = 0;
        while(scan.hasNext()){
            a.add(scan.nextLine());
        }
        
        int o = 0;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i).charAt(0) == '+'){
                p++;
            }
            else if(a.get(i).charAt(0) == '-'){
                p--;
            }
            else
            {
                int ci = a.get(i).indexOf(":");
                String c = a.get(i).substring(ci+1);
                o += c.length() * p;
            }
        }
        System.out.print(o);
        
        
        
        
        
        
        
    }
    
}