import java.util.Scanner;

/**
 * Created by ghw on 4/22/2017.
 */
public class games {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        Integer tshirt[] = new Integer[n*2];
        int i;
        int total=0;
        for(i=0;i<n*2;i++){
            tshirt[i]=sc.nextInt();
        }

        for(i=0;i<n*2-2;i++)
        {
                if(i%2==0) {
                    for (int j = i + 3; j < n*2; j += 2) {
                        if (tshirt[i] == tshirt[j]) total++;
                    }
                }
                else
                {
                    for (int j = i + 1; j < n*2; j += 2) {
                        if (tshirt[i] == tshirt[j]) total++;
                    }

                }


        }

        System.out.println(total);
    }

}


