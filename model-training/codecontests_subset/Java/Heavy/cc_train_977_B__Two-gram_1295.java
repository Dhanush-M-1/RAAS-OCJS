
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author moham
 */
public class NewMain20 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner input =new Scanner(System.in);
        HashMap<String,Integer> hs = new HashMap<>();
        int n = input.nextInt();
        String s = input.next();
        for(int i=0;i<n-1;i++){
            if(hs.containsKey(s.substring(i, i+2))){
                hs.put(s.substring(i, i+2),hs.get(s.substring(i, i+2))+1);
            }else{
                hs.put(s.substring(i, i+2),0);
            }
        }
        int maxkey = 0;        
        String ans ="";
        for(Map.Entry<String, Integer> entry : hs.entrySet()) {           
            if(entry.getValue()>=maxkey){
                maxkey=entry.getValue();
                ans = entry.getKey();
            }
        }
        System.out.println(ans);
    }    
}