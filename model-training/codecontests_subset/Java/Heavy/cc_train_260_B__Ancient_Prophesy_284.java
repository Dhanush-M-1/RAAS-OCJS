
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mamdouh
 */
public class AncientProph {

    /**
     * @param args the command line arguments
     */
    static boolean checkDate(String date)
    {
        int day=Integer.parseInt(date.substring(0,2));
        int month=Integer.parseInt(date.substring(3,5));
        int year = Integer.parseInt(date.substring(6,10));
        if(year<2013||year>2015)
            return false;
        if(month<1||month>12)
            return false;
        if(day<1||day>31)
            return false;
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
        {
            return (day>0&&day<32);
        }
        else if(month==2)
            return day>0&&day<29;
        else
            return day>0&&day<31;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number;
        number=br.readLine();
        String pattern="\\d\\d-\\d\\d-\\d\\d\\d\\d";
        Pattern ptt = Pattern.compile(pattern);
        Matcher mach = ptt.matcher(number);
        Map<String, Integer> hm = new HashMap<String, Integer>();
        int maximum=0;
        String date="";
        int start=0;
        
        while(mach.find(start))
        {
            String found = mach.group();
            Integer n=1;
            start=mach.start()+1;
            if(!checkDate(found)){
                continue;
            }
            if(hm.containsKey(found))
            {
                n=hm.get(found);
                n++;
            }
            if(n>maximum)
            {
                date=found;
                maximum=n;
            }
            hm.put(found, n);
            
        }
        System.out.println(date);
    }
}
