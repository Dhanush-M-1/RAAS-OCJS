import java.util.*;
public class tata
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int c= sc.nextInt();
        int max = 0;
        ArrayList<Integer> price = new ArrayList<>();
        for (int i = 0; i < n ; i++) {
        price.add(sc.nextInt());
        }
        for (int i = 0; i < price.size()-1 ; i++) {

            max = Math.max(max,(price.get(i)-price.get(i+1)-c));

        }
        System.out.println(max);




    }

}