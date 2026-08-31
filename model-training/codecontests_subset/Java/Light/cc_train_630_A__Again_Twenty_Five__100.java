/**
 * @(#)AgainTwentyFive.java
 *
 * The HR manager was disappointed again. The last applicant failed the interview the same way as 24
 * previous ones. "Do I give such a hard task?" � the HR manager thought. "Just raise number 5 to the
 * power of n and get last two digits of the number. Yes, of course, n can be rather big, and one
 * cannot find the power using a calculator, but we need people who are able to think, not just follow
 * the instructions."
 *
 * Could you pass the interview in the machine vision company in IT City?
 *
 * @author Mariella L. Fernandez AND Kristine Mae Viloria
 * @version 1.00 2016/8/24
 */

import java.util.*;
public class AgainTwentyFive {
    public static void main(String[] args) {
		Scanner kbd = new Scanner(System.in);

		long n = kbd.nextLong();


		if ( Math.round(Math.pow(5,n)%100) == 0 ) {
			System.out.print("25");
		} else {
			System.out.print(Math.round(Math.pow(5,n)%100));
		}
    }
}
