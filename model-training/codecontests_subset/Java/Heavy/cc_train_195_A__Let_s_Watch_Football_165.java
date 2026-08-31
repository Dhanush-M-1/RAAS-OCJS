import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

public class Sourcecode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int dataneedpersecond = input.nextInt();
        int datadownloadpersecond=input.nextInt();
        int videolength=input.nextInt();
        getanswer(dataneedpersecond,datadownloadpersecond,videolength);

   
    }

    private static void getanswer(int a,
            int b, int c) {
        for(int t=0;t<a*c;t++){
            int ok=1;
            for(int t0=t;t0<=t+c;t0++){
                if(b*t0<a*(t0-t)){
                    ok=0;
                    break;
                }
                
            }
            
            if(ok==1){
                System.out.println(t);
                break;
            }
            
        }
    }
}


    
