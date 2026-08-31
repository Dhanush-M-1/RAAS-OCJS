import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by Александр on 05.04.2017.
 */
public class Vk_cup {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n=in.nextInt();
        String s=in.next();

        String ans=s.replaceAll("a+","a");
         ans=ans.replaceAll("u+","u");
         ans=ans.replaceAll("i+","i");
         ans=ans.replaceAll("y+","y");
         ans=ans.replaceAll("eee+","e");
         ans=ans.replaceAll("ooo+","o");
        System.out.println(ans);



    }
}
