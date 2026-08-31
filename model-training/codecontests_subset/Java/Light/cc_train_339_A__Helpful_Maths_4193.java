
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class Main {

   

    public static void main(String[] args) {









Scanner in = new Scanner(System.in);
ArrayList <Integer> arr = new ArrayList();
String str= in.next();
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(ch !='+')
                arr.add(Character.getNumericValue(ch));
        }
        Collections.sort(arr);
        String s="";
        for (int i = 0; i < arr.size(); i++) {
            s+=arr.get(i);
            if(i!=arr.size()-1)
                s+="+";
        }
        System.out.println(s);}}