import java.util.ArrayList;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args)
    {
        Scanner scan=new Scanner(System.in);
        int button=scan.nextInt();
        int bulb=scan.nextInt();
        boolean yes=false;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=1;i<=bulb;i++)
        {
            list.add(i);
        }
        scan.nextLine();
        for(int i=0;i<button;i++)
        {
            int temp;
            int lit=scan.nextInt();
            for(int j=0;j<lit;j++)
            {
                temp=scan.nextInt();
                if(list.contains(temp))
                {
                    list.remove(Integer.valueOf(temp));
                }
                if(list.isEmpty()) yes=true;
            }
            scan.nextLine();
        }
        if(yes) System.out.println("YES");
        else System.out.println("NO");

    }

}
