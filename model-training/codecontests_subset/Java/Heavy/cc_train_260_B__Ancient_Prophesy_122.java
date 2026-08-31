
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        TreeMap<String, Integer> count = new TreeMap<String, Integer>();
        for (int i = 0; i < input.length()-9; i++) {
            String substr = input.substring(i, i+10);
            if(isValid(substr)){
                String key =(substr);
                if(count.containsKey(key)) count.put(key, count.get(key)+1);
                else count.put(key, 1);
            }
        }
        Set<String> keys = count.keySet();
        int max = -1;
        String out = "";
        for (Iterator i = keys.iterator(); i.hasNext();) {
            String key = (String) i.next();
            if(count.get(key)>max){
                max = count.get(key);
                out = key;
            }
        }
        System.out.print(out);
    }
    
    private static int key(String str){
        int day = Integer.parseInt(str.substring(0,2));
        int month = Integer.parseInt(str.substring(3,5));
        int year = Integer.parseInt(str.substring(6));
        return year*400+month*31*day;
    }
    
    private static String fromKey(int key){
        int year = key/400;
        int month = (key-year*400)%31;
        int day = (key-400*year-31*month)%31;
        return String.format("%2d-%2d-%4d", day, month, year);
    }
    
    private static Boolean isValid(String str) {
        try{
            if((str.charAt(2) != '-') || (str.charAt(5) != '-')){
                return false;
            }
            int day = Integer.parseInt(str.substring(0,2));
            int month = Integer.parseInt(str.substring(3,5));
            int year = Integer.parseInt(str.substring(6));
            
            if((year < 2013) || (year > 2015)) return false;
            if((month<1) || (month>12)) return false;
            if((day<1) || ((month < 8)&&(month%2==1)&&(day>31)) || ((month < 8)&&(month%2==0)&&(day>30))
                     || ((month >= 8)&&(month%2==0)&&(day>31)) || ((month >= 8)&&(month%2==1)&&(day>30))) return false;
            if((month==2)&&(day>28)) return false;
            
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
