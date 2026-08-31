import java.util.*;
import java.io.*;

public class A168WizardsAndDemonstration{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sarr = br.readLine().split(" ");
        int n = Integer.parseInt(sarr[0]);
        int x = Integer.parseInt(sarr[1]);
        int y = Integer.parseInt(sarr[2]);

        double requiredp = n*(y*0.01);
        int required = (int) Math.ceil(requiredp);
        int puppet = required - x;
        
        if(puppet<=0){
            System.out.println(0);
        }else{
            System.out.println(puppet);
        }
    }
}
