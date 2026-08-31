/**
 * Created by Eesaa on 10/5/2017.
 */

//import com.sun.tools.javac.util.StringUtils;

import java.util.*;

public class A_868 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        ArrayList <String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(in.next());
        }
        if(n==1) {
            list.add(list.get(0));
            list.add(list.get(0));
        }
        for (int i = 0; i < n; i++) {
            if(list.get(i).contains(s))
            {
                System.out.println("YES");return;
            }
            if(list.get(i).endsWith(Character.toString(s.charAt(0))))
            {
                for (int j = 0; j < n; j++) {
                    if(list.get(j).startsWith(Character.toString(s.charAt(s.length()-1))))
                    {
                        System.out.println("YES");return;
                    }

                }
            }

        }
        System.out.println("NO");
    }
}
