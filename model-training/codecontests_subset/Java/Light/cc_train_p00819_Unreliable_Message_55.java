import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int N = sc.nextInt();
		for (int i = 0; i < N; ++i) {
			char[] mut = sc.next().toCharArray();
			char[] mes = sc.next().toCharArray();
			int L = mes.length;
			for (int j = mut.length - 1; j >= 0; --j) {
				char tmp;
				switch (mut[j]) {
				case 'J':
					tmp = mes[L - 1];
					for (int k = L - 1; k > 0; --k) {
						mes[k] = mes[k - 1];
					}
					mes[0] = tmp;
					break;
				case 'C':
					tmp = mes[0];
					for (int k = 0; k < L - 1; ++k) {
						mes[k] = mes[k + 1];
					}
					mes[L - 1] = tmp;
					break;
				case 'E':
					for (int k = 0; k < L / 2; ++k) {
						tmp = mes[k];
						mes[k] = mes[(L + 1) / 2 + k];
						mes[(L + 1) / 2 + k] = tmp;
					}
					break;
				case 'A':
					for (int k = 0; k < L / 2; ++k) {
						tmp = mes[k];
						mes[k] = mes[L - 1 - k];
						mes[L - 1 - k] = tmp;
					}
					break;
				case 'P':
					for (int k = 0; k < L; ++k) {
						if (Character.isDigit(mes[k])) {
							if (mes[k] == '0') {
								mes[k] = '9';
							} else {
								mes[k]--;
							}
						}
					}
					break;
				case 'M':
					for (int k = 0; k < L; ++k) {
						if (Character.isDigit(mes[k])) {
							if (mes[k] == '9') {
								mes[k] = '0';
							} else {
								mes[k]++;
							}
						}
					}
					break;
				}
			}
			System.out.println(String.valueOf(mes));
		}
	}

}