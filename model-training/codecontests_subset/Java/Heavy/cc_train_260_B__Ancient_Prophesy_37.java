import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;
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
        HashMap<String, Integer> cnt = new HashMap<String, Integer> ();
        
        
        if(matcher.find()) {
            if(check(matcher.group(1), matcher.group(2))) {
                String key = matcher.group();
                if(cnt.containsKey(key)) cnt.put(key, cnt.get(key) + 1);
                else cnt.put(key, 1);
            }
        }
        
        while(matcher.find(matcher.start() + 1)) {
            if(check(matcher.group(1), matcher.group(2))){
                String key = matcher.group();
                if(cnt.containsKey(key)) cnt.put(key, cnt.get(key) + 1);
                else cnt.put(key, 1);
            }
        }
        Map.Entry<String, Integer> ans = null;
        
        Set<Map.Entry<String, Integer>> set = cnt.entrySet();
        for(Iterator<Entry<String, Integer>> it = set.iterator();it.hasNext();) {
            Map.Entry<String, Integer> entry = it.next();
            if(ans == null || entry.getValue() > ans.getValue()) {
                ans = entry;
            }
        }
        System.out.println(ans.getKey());
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