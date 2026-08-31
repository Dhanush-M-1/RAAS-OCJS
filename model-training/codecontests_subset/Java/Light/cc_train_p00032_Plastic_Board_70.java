import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int recCount = 0;
        int diaCount = 0;
        
        while(sc.hasNext()){
            String abc[] = sc.nextLine().split(",");
            int a = Integer.parseInt(abc[0]);
            int b = Integer.parseInt(abc[1]);
            int c = Integer.parseInt(abc[2]);
            if(rectangle(a,b,c) == true){
                recCount++;
            }
            if(diamond(a,b) == true){
                diaCount++;
            }
        }
        System.out.println(recCount + "\n" + diaCount);
    }
    private static boolean rectangle(int a, int b, int c){
        if(Math.pow(a,2) + Math.pow(b,2) == Math.pow(c,2)){
            return true;
        }
        return false;
    }
    private static boolean diamond(int a, int b){
        if(a == b){
            return true;
        }
        return false;
    }
}
