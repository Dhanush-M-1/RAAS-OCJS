import java.util.Scanner;
public class Main {
public static void main(String[] args) {
  Scanner in = new Scanner(System.in)
	  .useDelimiter("[^0-9]+");
  int cho = 0, daia = 0;
  while (in.hasNext()) {
	long a = in.nextLong();
	long b = in.nextLong();
	long c = in.nextLong();
	if (a == b) {
	  daia++;
	} else if (a * a + b * b == c * c) {
	  cho++;
	}
  }
  System.out.println(cho);
  System.out.println(daia);
}
}