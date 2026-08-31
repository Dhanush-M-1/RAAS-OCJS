import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author Khayyam
 * Xeyyam Quliyev :))
 */
public class A {

    
    public void run(){
        Scanner sc = new Scanner(System.in);
        Set<String> data = new HashSet<String>();
        int ans = 0;
       // int i = 1;
        String temp;
        while(sc.hasNextLine()){
            temp = sc.nextLine();
            //i++;
            if(temp.charAt(0)=='+'){
                data.add(temp.substring(1));
            }
            else if(temp.charAt(0)=='-'){
                data.remove(temp.substring(1));
            }
            else{
                ans += data.size() * temp.substring(temp.indexOf(':') + 1).length();
            }
            
        }
        
        System.out.println(ans);
    }
     
    
    public static void main(String args[]){
        new A().run();
    }
}
