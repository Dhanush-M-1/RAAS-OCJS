import java.io.*;
import java.util.ArrayList;

class Main{
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str1 = br.readLine();
    String[] str2 = str1.split(" ");
    int n = Integer.parseInt(str2[0]);

    ArrayList<String> list1 = new ArrayList<String>();
    for (int i = 0; i < n; i++){
      list1.add(br.readLine());
    }
    for(int i = 1; i <= 13; i++){
      if (list1.contains("S " + i) == false)
        System.out.println("S " + i);
    }
    for(int i = 1; i <= 13; i++){
      if (list1.contains("H " + i) == false)
        System.out.println("H " + i);
    }
    for(int i = 1; i <= 13; i++){
      if (list1.contains("C " + i) == false)
        System.out.println("C " + i);
    }
    for(int i = 1; i <= 13; i++){
      if (list1.contains("D " + i) == false)
        System.out.println("D " + i);
    }
  }
}