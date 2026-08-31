import java.util.Scanner;
class Main {
 public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   int a = sc.nextInt();
   int b = sc.nextInt();
   int com = a*b;
  if(com%2==0) {
    System.out.println("Even");
  }else{
    System.out.println("Odd");
  }
 }
}