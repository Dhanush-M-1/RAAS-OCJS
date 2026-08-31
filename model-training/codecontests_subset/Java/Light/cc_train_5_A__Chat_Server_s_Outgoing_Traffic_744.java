

import java.util.*;

public class D {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        long total=0;
        long ppl =0;
        while(sc.hasNextLine()){
            String temp = sc.nextLine();
            if(temp.charAt(0)=='+')ppl++;
            else if(temp.charAt(0)=='-')ppl--;
            else{
                total+=ppl*(temp.length()-temp.indexOf(':')-1);
            }

        }
            
        System.out.print(total);
        System.exit(0);
    }
}
