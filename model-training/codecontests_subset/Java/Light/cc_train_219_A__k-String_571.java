import java.math.BigInteger;
import java.util.*;



public class Test {

    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();s.nextLine();
        char[] inp = s.nextLine().toCharArray();
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<inp.length;i++) {
            char c = inp[i];
            if(map.containsKey(c)){
                int val = map.get(c);
                map.put(c,val+1);
            } else {
                map.put(c,1);
            }
        }

        boolean non = false;
        StringBuffer sb = new StringBuffer();

        for (Map.Entry<Character, Integer> entry : map.entrySet())
        {
            if((entry.getValue() % k) != 0) {
                non = true;
                break;
            } else {
                int no = entry.getValue() / k;
                for(int i=0;i<no;i++) {
                    sb.append(entry.getKey());
                }
            }
        }

       if(non) {
           System.out.println(-1);
       } else {
           String temp = sb.toString();
           for(int i=1;i<k;i++) {
               sb.append(temp);
           }
           System.out.println(sb.toString());
       }

    }
}