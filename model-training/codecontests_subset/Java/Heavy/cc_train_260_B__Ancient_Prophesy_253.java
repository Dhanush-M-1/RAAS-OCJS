import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {
    
    public static void main(String[] args) throws Exception {
        
        Scanner scn = new Scanner(System.in);
        int[] days = new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
        String reg = "(\\d{2})-(\\d{2})-(\\d{4})";
        Pattern pattern = Pattern.compile(reg);
        String str = scn.nextLine();
        Matcher matcher = pattern.matcher(str);
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        int mx = 0;
        String soln = "";
        int ind = 0;
        while(matcher.find(ind)) {
            String tem = matcher.group();
            ind = matcher.end()-7;
            //System.out.println(tem);
            
            if (Main.isOK(tem)) {
                if (map.containsKey(tem)) {
                    int val = map.get(tem);
                    val++;
                    if (mx < val) {
                        mx = val;
                        soln = tem;
                    }
                    map.put(tem, val);
                }
                else {
                    map.put(tem, 1);
                    if (mx == 0) {
                        mx = 1;
                        soln = tem;
                    }
                }
                //System.out.println("tem : " + tem);
            }
        }
        
        System.out.println(soln);
    }
    
    public static boolean isOK(String str) {
        int[] arr = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};
        String[] temp = str.split("-");
        int day = Integer.valueOf(temp[0]);
        int month = Integer.valueOf(temp[1]);
        int year = Integer.valueOf(temp[2]);
        if (year != 2013 && year != 2014 && year != 2015) {

            return false;
        }
        if (month < 1 || month > 12) {

            return false;
        }
        if (day < 1 || day > arr[month-1]) {
    
            return false;
        }
            
            
        return true;
            
    }

}
