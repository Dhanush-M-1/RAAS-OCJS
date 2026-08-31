/**
 * Created by chandu on 6/25/2014.
 */
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        int c=in.nextInt();
        for(int i=0; ;i++)
            if ((i + c) * b >= a * c) {
                System.out.println(i);
                break;
            }
    }
}