import java.util.*;
public class Task{

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String s[]=sc.next().split("\\+");
        Arrays.sort(s);
        System.out.print(String.join("+",s));

    }
}