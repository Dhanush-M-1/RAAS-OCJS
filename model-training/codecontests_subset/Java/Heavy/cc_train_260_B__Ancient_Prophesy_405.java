import java.util.*;

public class AncientProphesy {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        
        StringBuffer sb = new StringBuffer(sc.nextLine());
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        
        for (int i=0; i<sb.length()-9; i++)
        {
            int d = parseInt(sb.substring(i,   i+2));
            int m = parseInt(sb.substring(i+3, i+5));
            int y = parseInt(sb.substring(i+6, i+10));
            
            if (sb.charAt(i+2)=='-' && sb.charAt(i+5)=='-' && isMonth(m) && isYear(y) && d>=1 && d<=days[m])
            {
                String dt = addZero(d)+"-"+addZero(m)+"-"+y;
                if (hm.containsKey(dt))
                    hm.put(dt, hm.get(dt)+1);
                else 
                    hm.put(dt, 1);
            }
        }

        String date = "";
        int max = 0;
        for (Map.Entry<String, Integer> e : hm.entrySet()) {
            if (max<e.getValue()) {
                max  = e.getValue();
                date = e.getKey();
            }
        }
        System.out.println(date);
    }
    
    static String addZero(int i) {
        return i>9 ? String.valueOf(i) : "0"+i;
    }
    
    static int parseInt(String s) {
        int i=0;
        try {
            i = Integer.parseInt(s);
        } catch (Exception e) {}
        return i;
    }
    
    static boolean isMonth(int m) {
        return m>=1 && m<=12;
    }
    
    static boolean isYear(int y) {
        return y>=2013 && y<=2015;
    }
    
}