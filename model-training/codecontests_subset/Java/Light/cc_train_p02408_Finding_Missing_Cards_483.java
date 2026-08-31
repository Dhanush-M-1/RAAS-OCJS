public class Main {
	public static void main(String[] args) {
		try (java.util.Scanner sc = new java.util.Scanner(System.in)) {
			int cnt = sc.nextInt();
			boolean[][] arr = new boolean[4][13];
			java.util.stream.IntStream.range(0, cnt).forEachOrdered(i -> {
				int pIdx = 0;
				String pattern = sc.next();
				if (pattern.equals("H")) {pIdx = 1;}
				if (pattern.equals("C")) {pIdx = 2;}
				if (pattern.equals("D")) {pIdx = 3;}
				arr[pIdx][sc.nextInt() - 1] = true;
			});

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j <arr[i].length; j++ ) {
					if (!arr[i][j]) {
						String pattern = "S";
						if (i == 1) {pattern = "H";}
						if (i == 2) {pattern = "C";}
						if (i == 3) {pattern = "D";}
						System.out.println(pattern + " "+ (j+1));
					}
				}
			}

		}
	}
}
