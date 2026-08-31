import java.util.*;

public class B {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int tests = input.nextInt();
    int[] answers = new int[tests];

    for (int i = 0; i < tests; i++) {
      long number = input.nextInt();

      if (number == 1) {
        answers[i] = 0;
      } else if (number == 6) {
        answers[i] = 1;
      } else if (number < 6) {
        long dist = (long) Math.sqrt(6 / number);
        if (number * Math.pow(2, dist) / 6 == 1) {
          answers[i] = (int) dist + 1;
        } else {
          answers[i] = -1;
        }
      } else if (number > 6) {
        int count = 0;

        while (number >= 6) {
          count++;

          if (number == 0) {
            count = -1;
            break;
          }

          if (number % 6 == 0) {
            number /= 6;
          } else if (number % 6 == 3) {
            number *= 2;
          } else {
            count = -1;
            break;
          }
        }

        if (number == 1) {
          answers[i] = count;
        } else if (number > 0 && number < 6) {
          long dist = (long) Math.sqrt(6 / number);

          if (number * Math.pow(2, dist) / 6 == 1) {
            count += (int) dist + 1;
          } else {
            count = -1;
          }
        }

        answers[i] = count;
      }
    }

    for (int answer : answers) {
      System.out.println(answer);
    }
  }
}
