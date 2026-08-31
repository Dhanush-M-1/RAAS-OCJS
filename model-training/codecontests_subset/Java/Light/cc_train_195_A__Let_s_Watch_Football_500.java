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
        int totalData=a*c;
        int toLoad=(totalData+b-1)/b;
        System.out.println(Math.max(0,toLoad-c));
    }
}