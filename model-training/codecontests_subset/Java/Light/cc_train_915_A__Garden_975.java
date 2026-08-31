import java.util.*;

public class Garden {
    public static void main(String[] args)
    {
        Scanner scan1 = new Scanner(System.in);
        int input1  = scan1.nextInt();
        int input2 = scan1.nextInt();
        int[] arr = new int[input1];
        int bestFactor = 1;

        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = scan1.nextInt();
        }

        for (int j = arr.length-1; j >= 0; j--)
        {
            if (input2%(arr[j])== 0 && arr[j] > bestFactor)
            {
                bestFactor = arr[j];
            }

        }
        System.out.println(input2/bestFactor);

    }
}
