import java.util.*;
import java.io.*;

public class maths {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<String> arr = new ArrayList<String>();

    String str = scan.nextLine();
    for(int i = 0; i < str.length(); i++){
      if(i % 2 == 0){
        int N = Integer.parseInt(str.substring(i, i + 1));
        list.add(N);
      }else{
        arr.add(str.substring(i, i + 1));
      }
    }
    Collections.sort(list);

    for(int i = 0; i < list.size(); i++){
      System.out.print(list.get(i));
      if(i < list.size()-1){
        System.out.print(arr.get(i));
      }
    }
  }
}