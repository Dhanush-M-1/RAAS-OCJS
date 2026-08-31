import java.util.*;

public class AgainTwentyFive{
  public static void main(String[] args){
    Scanner gd = new Scanner(System.in);
    int g = 0;
    IO.pl("25");
  }
}

// Template
class IO{
  static Scanner gd = new Scanner(System.in);
  public static long rl(){
    return gd.nextLong();
  }
  public static int ri(){
    return gd.nextInt();
  }
  public static String rs(){
    return gd.next();
  }
  public static int[] rai(int len){
    int[] temp = new int[len];
    for(int i=0;i<len;i++){
      temp[i] = gd.nextInt();
    }
    return temp;
  }
  public static long[] ral(int len){
    long[] temp = new long[len];
    for(int i=0;i<len;i++){
      temp[i] = gd.nextLong();
    }
    return temp;
  }
  public static void pf(String format,Object... args){
    System.out.printf(format,args);
  }
  public static void pl(Object data){
    System.out.println(data);
  }
  public static void pai(int arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.printf("%d ",arr[i]);
    }
    System.out.println();
  }
  public static void pal(long arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.printf("%d ",arr[i]);
    }
    System.out.println();
  }
  public static void pas(String arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.printf("%s ",arr[i]);
    }
    System.out.println();
  }
}

