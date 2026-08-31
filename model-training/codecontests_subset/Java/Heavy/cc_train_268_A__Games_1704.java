import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import java.util.Map;


public class Games {

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Integer,Integer> home = new HashMap<>();
        Map<Integer,Integer> away = new HashMap<>();
        int count =0;
        while(n-- > 0)
        {
            String line = br.readLine();
            int homeColor = Integer.parseInt(line.split(" ")[0]);
            int awayColor = Integer.parseInt(line.split(" ")[1]);

            if(home.get(homeColor)!=null)
            {
                home.put(homeColor,home.get(homeColor) +1);

            }else{
                home.put(homeColor,1);
            }

            if(away.get(awayColor) !=null)
                away.put(awayColor,away.get(awayColor) +1);
            else
                away.put(awayColor,1);



           if(home.get(awayColor) !=null )
           {
                count += home.get(awayColor);
           }
           if(away.get(homeColor) !=null)
            count += away.get(homeColor);


        }
        System.out.println(count);
    }
    
}

// 4
// 100 42
// 42 100
// 5 42
// 100 5