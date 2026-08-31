import static java.lang.Math.log10;

import java.math.BigDecimal;
import java.util.Scanner;

public class _341DivD{
	public static void main(String[] args) {
		BigDecimal max = null;
		String exp = "";
		Scanner scanner = new Scanner(System.in);
		BigDecimal x = scanner.nextBigDecimal();
		BigDecimal y = scanner.nextBigDecimal();
		BigDecimal z = scanner.nextBigDecimal();
		for (int i = 1; i <= 12; i++) {
			BigDecimal temp = null;
			switch (i) {
			case 1:
				temp = calculateExpression(x, y, z);
				break;
			case 2:
				temp = calculateExpression(x, z, y);
				break;
			case 3:
				temp = calculateExpression(x, y, z, true);
				break;
			case 4:
				temp = calculateExpression(x, z, y, true);
				break;
			case 5:
				temp = calculateExpression(y, x, z);
				break;
			case 6:
				temp = calculateExpression(y, z, x);
				break;
			case 7:
				temp = calculateExpression(y, x, z, true);
				break;
			case 8:
				temp = calculateExpression(y, z, x, true);
				break;
			case 9:
				temp = calculateExpression(z, x, y);
				break;
			case 10:
				temp = calculateExpression(z, y, x);
				break;
			case 11:
				temp = calculateExpression(z, x, y, true);
				break;
			case 12:
				temp = calculateExpression(z, y, x, true);
				break;
			}
			if (max == null || max.compareTo(temp) <= -1) {
				max = temp;
				exp = printExpression(i - 1);
			}
		}
		System.out.println(exp);
		scanner.close();
	}

	private static String printExpression(int index) {
		String exp = "";
		switch (index){
		case 0:
			exp = "x^y^z";
			break;
		case 1:
			exp = "x^z^y";
			break;
		case 2:
			exp = "(x^y)^z";
			break;
		case 3:
			exp = "(x^z)^y";
			break;
		case 4:
			exp = "y^x^z";
			break;
		case 5:
			exp = "y^z^x";
			break;
		case 6:
			exp = "(y^x)^z";
			break;
		case 7:
			exp = "(y^z)^x";
			break;
		case 8:
			exp = "z^x^y";
			break;
		case 9:
			exp = "z^y^x";
			break;
		case 10:
			exp = "(z^x)^y";
			break;
		case 11:
			exp = "(z^y)^x";
			break;
		}
		return exp;
	}

	private static BigDecimal calculateExpression(BigDecimal base, BigDecimal power1, BigDecimal power2) {
		boolean bracket = false;
		return calculateExpression(base, power1, power2, bracket);
	}

	private static BigDecimal calculateExpression(BigDecimal base, BigDecimal power1, BigDecimal power2, boolean bracket) {
		if (bracket) {
			return power2.multiply(power1).multiply(new BigDecimal(log10(base.doubleValue())));
		} else {
			BigDecimal decimalPower = new BigDecimal((power2.doubleValue() * 10) % 10);
			return power1.pow(power2.intValue()).multiply(new BigDecimal(Math.pow(power1.doubleValue(), (decimalPower.intValue() / 10.0)))).multiply(new BigDecimal(log10(base.doubleValue())));
		}
	}
}
