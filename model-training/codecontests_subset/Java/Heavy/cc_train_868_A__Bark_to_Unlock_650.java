import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        boolean _ability = false;
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int n = sc.nextInt();
        String[] arr = new String[n];
        sc.nextLine();
        for(int i = 0; i < n && !_ability; i++ )
        {
            arr[i] = sc.nextLine();;
            if(arr[i].contains(input))
                _ability = true;
        }
        if (_ability) System.out.print("YES");
        else
        {
            boolean is_first = false;
            for(int i = 0; i < n && !is_first; i++)
                if(arr[i].charAt(1) == input.charAt(0))
                    is_first = true;

            if(is_first)
            {
                boolean is_second = false;
                for(int i = 0; i < n && !is_second; i++)
                    if(arr[i].charAt(0) == input.charAt(1))
                        is_second = true;

                if(is_second) _ability = true;
            }
            if(_ability) System.out.print("YES");
            else System.out.print("NO");
        }
    }
}