import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static String format(int d, int m, int y) {
        String ans = "";
        ans += (d < 10) ? "0" : "";
        ans += String.valueOf(d) + "-";
        ans += (m < 10) ? "0" : "";
        ans += String.valueOf(m) + "-";
        ans += String.valueOf(y);
        return ans;
    }
    
    public static String find(ArrayList<String> ll){
        Calendar date = new GregorianCalendar(2013, 1, 1);
        Calendar dateMax = new GregorianCalendar(2013, 1, 1);       
        String ans = "", d= "",m= "",y= "";
        String[] s;
        for (int i = 0; i < ll.size(); i++) {
            s = ll.get(i).split("-");
            date.set(Integer.parseInt(s[2]),Integer.parseInt(s[1]),Integer.parseInt(s[0]));
            if(date.compareTo(dateMax)>=0){
                dateMax = (GregorianCalendar)date.clone();
                d = s[0];
                m = s[1];
                y = s[2];
            }
        }
        ans = format(Integer.parseInt(d), Integer.parseInt(m), Integer.parseInt(y));
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;
        int t = 0;
        int[] days = { 21, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        do {
            line = br.readLine();
            if (line == null || line.length() == 0)
                break;
            //while (!line.replaceAll("--", "-").equals(line))
                //line = line.replaceAll("--", "-");
            ArrayList<String> ll = new ArrayList<String>();
            HashMap<String, Integer> hm = new HashMap<String, Integer>();           
            String[] dates = line.split("-");
            int d = 0, m = 0, y = 0, max = 0;
            int dmax = 0, mmax = 0, ymax = 2013;
            for (int i = 0; i < dates.length - 2; i++) {
                if (dates[i].length() >= 2 && dates[i + 1].length() >= 2) {
                    d = Integer
                            .parseInt(dates[i].substring(dates[i].length() - 2));
                    m = Integer.parseInt(dates[i + 1].substring(dates[i + 1]
                            .length() - 2));
                    if (m >= 1 && m <= 12 && d <= days[m - 1] && d > 0
                            && dates[i + 2].length() >= 4) {
                        y = Integer.parseInt(dates[i + 2].substring(0, 4));
                        if (y >= 2013 && y <= 2015) {
                                dmax = d;
                                mmax = m;
                                ymax = y;
                                String temp = format(dmax, mmax, ymax);
                                if(!hm.containsKey(temp)){
                                    hm.put(temp, 1);
                                    if(1>max){
                                        max = 1;
                                    }
                                }else{
                                    int aux = hm.get(temp);
                                    hm.put(temp, aux+1);
                                    if(aux+1>max){
                                        max = aux+1;
                                    }
                            }
                        }
                    }
                }
            }
             Set s = hm.entrySet();
             Iterator i = s.iterator();
             while (i.hasNext()) {
                 String[] aux =  i.next().toString().split("=");
                 if(Integer.parseInt(aux[1])==max){
                     ll.add(aux[0]);
                 }
             }
            sb.append(((t++==0)?"":"\n")+find(ll));
        } while (!line.equals("") && line != null);
        System.out.println(sb);
    }
}