/**
 * Created by Omar on 3/26/2016.
 */

import java.util.*;
import java.io.*;

public class Ancient {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);


       int[] numberOfDays = {0,31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String line=br.readLine();

        String answer = "";
        String date;
        int count = 0;

        for (int y=2013;y<=2015;y++){
            for (int m=1; m<=12;m++){
                for (int d=1; d<=numberOfDays[m]; d++){

                      date = String.format("%02d-%02d-%04d", d, m, y);
                   // System.out.println("TEST: "+ date);
                    int c = 0;
                    for (int i = line.indexOf(date, 0); i >= 0; i = line.indexOf(date, i+1)){
                        c++; //System.out.println("date: "+ date);
                    }
                    if (c > count){
                        count = c;
                        answer = date;
                    }





                }





            }



        }
        System.out.println(answer);
        pw.close();
        br.close();
    }
}
