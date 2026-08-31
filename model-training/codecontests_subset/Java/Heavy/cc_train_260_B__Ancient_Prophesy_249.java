import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {

    /**
     * @param args
     * @throws IOException 
     */
    //static <T> List<T> nCopies(int n, T o) 
    static Scanner cin = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        Pattern pattern = Pattern.compile("(0[1-9]|[1-3]\\d)-(0[1-9]|1[0-2])-201[3-5]");
        Matcher matcher = pattern.matcher(cin.next());
        
        //while(matcher.find()) System.out.println(matcher.group());
        ArrayList<String> dates = new ArrayList<String> ();
        if(matcher.find()) {
            if(check(matcher.group(1), matcher.group(2)))
                dates.add(matcher.group());//System.out.println(matcher.group());
        }
        
        while(matcher.find(matcher.start() + 1)) {
            if(check(matcher.group(1), matcher.group(2)))
                dates.add(matcher.group());//System.out.println(matcher.group());
        }
        HashSet<String> uniq = new HashSet<String>(dates);
        int max = -1;
        String ans = null;
        
        for(String d : uniq) {
            int tmp = Collections.frequency(dates, d);
            if(tmp > max) {
                max = tmp;
                ans = d;
            }
        }
        System.out.println(ans);
    }//0012-10-2012-10-2012

    static boolean check(String _day, String _month) {

        int day = Integer.valueOf(_day);
        int month = Integer.valueOf(_month);
        //System.out.println(day + " " + month);
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(days[month - 1] < day) return false;
        
        return true;
    }

}