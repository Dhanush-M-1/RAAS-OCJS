import java.util.*;
public class Wizards {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		double citizens = s.nextDouble();
		double wizards = s.nextDouble();
		double percentage = s.nextDouble();
		s.close();
		double neededWizards = Math.ceil((citizens/100)*percentage);
		System.out.println((int)Math.max(neededWizards-wizards, 0));
	}
}