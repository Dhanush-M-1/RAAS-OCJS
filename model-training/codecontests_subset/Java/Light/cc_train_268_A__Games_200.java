import java.util.ArrayList;
import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> homeDress = new ArrayList<>();
        ArrayList<Integer> uniformDress = new ArrayList<>();
        int count = 0;
        while(n-- >= 1){
            homeDress.add(sc.nextInt());
            uniformDress.add(sc.nextInt());
            
        
        }
        for(int i=0; i<homeDress.size(); i++){
            for(int j=0; j<uniformDress.size(); j++){
                if(uniformDress.get(j) == homeDress.get(i)){
                    count++;
                }
            }
            
        }
        System.out.println(count);
    }
}
