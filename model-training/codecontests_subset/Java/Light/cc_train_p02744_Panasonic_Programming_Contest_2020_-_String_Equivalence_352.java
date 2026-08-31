import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
 
public class Main {
	public static void main(String[] args) {
		char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
		try (Scanner sc = new Scanner(System.in)) {
			int a = sc.nextInt();
			List<String> list = Arrays.asList("a");
			for (int i = 0; i < a - 1; i++) {
				list = list.stream().map(str -> {
					List<String> newStrs = new ArrayList<>();
					for (int j = 0; j<=calcCodePoints(str); j++) {
						newStrs.add(str + chars[j]);
					}
					return newStrs;
				}).flatMap(l -> l.stream()).collect(Collectors.toList());
			}
			list.stream().sorted().forEach(s -> System.out.println(s));
		}
	}
	
	public static int calcCodePoints(String s) {
		return s.chars().mapToObj(c -> (char) c).collect(Collectors.toSet()).size();
	}
}