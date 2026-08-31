import java.util.Scanner;

/**
 * Created by underestimatedcoder on 2018-01-16.
 */
public class Garden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int noOfBuckets = scanner.nextInt();
        int gardenLength = scanner.nextInt();
        scanner.nextLine();
        int bucketsThatSatisfyLength = 0;
        for(int i = 0; i < noOfBuckets; i ++){
            int curr = scanner.nextInt();
            if(gardenLength % curr == 0){
                if(bucketsThatSatisfyLength == 0)
                    bucketsThatSatisfyLength = gardenLength/curr ;
                else if(bucketsThatSatisfyLength > gardenLength/curr)
                    bucketsThatSatisfyLength = gardenLength/curr;
            }
        }
        System.out.println(bucketsThatSatisfyLength);
    }


}
