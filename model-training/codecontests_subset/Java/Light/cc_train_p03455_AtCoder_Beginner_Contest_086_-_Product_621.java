import java.util.* ;
class Main {
  public static void main(String[] args) {
    
    Scanner scan = new Scanner(System.in);
	int n = scan.nextInt();
    int a = scan.nextInt();

    System.out.println(n*a % 2 == 0? "Even" : "Odd");
  }
}
