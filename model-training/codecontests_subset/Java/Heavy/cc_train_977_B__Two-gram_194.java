

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class test2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String s = input.next();
        input.close();

        HashMap<String, Integer> hashMap = new HashMap<>();
        char c1 = s.charAt(0);
        char c2;


        for(int i = 1; i<n; i++) {
            c2 = s.charAt(i);
            String key =  new StringBuilder().append(c1).append(c2).toString();
            try {
                hashMap.put(key, hashMap.get(key) + 1);
            }
            catch (NullPointerException e){
                hashMap.put(key, 1);
            }



            c1 = c2;
        }



        //get max value for eachEntry
        Map.Entry<String, Integer> maxEntry = new Map.Entry<String, Integer>() {
            @Override
            public String getKey() {
                return "high";
            }

            @Override
            public Integer getValue() {
                return -1;
            }

            @Override
            public Integer setValue(Integer value) {
                return null;
            }
        };

        for (Map.Entry<String, Integer> entry : hashMap.entrySet())
        {
            if (entry.getValue().compareTo(maxEntry.getValue()) > 0)
            {
                maxEntry = entry;
            }
        }

        System.out.println(maxEntry.getKey());


    }
}
