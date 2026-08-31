import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	InputStream in = System.in;
	PrintStream out = System.out;

	void f1() {
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			out.print(c1);

			out.println();
		}

	}

	void f2() {
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			for (char c2 = c1; c2 <= 'b'; c2++) {
				out.print(c1);
				out.print(c2);
				out.println();
			}
		}
	}

	void f3() {
		StringBuffer sb = new StringBuffer();
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			sb.append(c1);
			for (char c2 = 'a'; c2 <= 'b'; c2++) {
				sb.append(c2);
				for (char c3 = 'a'; c3 <= max(c1, c2) + 1; c3++) {
					sb.append(c3);
					out.println(sb.toString());
					sb.deleteCharAt(2);
				}
				sb.deleteCharAt(1);
			}
			sb.deleteCharAt(0);
		}
	}

	void f4() {
		StringBuffer sb = new StringBuffer();
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			sb.append(c1);
			for (char c2 = 'a'; c2 <= 'b'; c2++) {
				sb.append(c2);
				for (char c3 = 'a'; c3 <= max(c1, c2) + 1; c3++) {
					sb.append(c3);
					for (char c4 = 'a'; c4 <= max(c1, c2, c3) + 1; c4++) {
						sb.append(c4);
						out.println(sb.toString());
						sb.deleteCharAt(3);
					}
					sb.deleteCharAt(2);
				}
				sb.deleteCharAt(1);
			}
			sb.deleteCharAt(0);
		}
	}

	void f5() {
		StringBuffer sb = new StringBuffer();
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			sb.append(c1);
			for (char c2 = 'a'; c2 <= 'b'; c2++) {
				sb.append(c2);
				for (char c3 = 'a'; c3 <= max(c1, c2) + 1; c3++) {
					sb.append(c3);
					for (char c4 = 'a'; c4 <= max(c1, c2, c3) + 1; c4++) {
						sb.append(c4);
						for (char c5 = 'a'; c5 <= max(c1, c2, c3, c4) + 1; c5++) {
							sb.append(c5);
							out.println(sb.toString());
							sb.deleteCharAt(4);
						}
						sb.deleteCharAt(3);
					}
					sb.deleteCharAt(2);
				}
				sb.deleteCharAt(1);
			}
			sb.deleteCharAt(0);
		}
	}

	void f6() {
		StringBuffer sb = new StringBuffer();
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			sb.append(c1);
			for (char c2 = 'a'; c2 <= 'b'; c2++) {
				sb.append(c2);
				for (char c3 = 'a'; c3 <= max(c1, c2) + 1; c3++) {
					sb.append(c3);
					for (char c4 = 'a'; c4 <= max(c1, c2, c3) + 1; c4++) {
						sb.append(c4);
						for (char c5 = 'a'; c5 <= max(c1, c2, c3, c4) + 1; c5++) {
							sb.append(c5);
							for (char c6 = 'a'; c6 <= max(c1, c2, c3, c4, c5) + 1; c6++) {
								sb.append(c6);
								out.println(sb.toString());
								sb.deleteCharAt(5);
							}
							sb.deleteCharAt(4);
						}
						sb.deleteCharAt(3);
					}
					sb.deleteCharAt(2);
				}
				sb.deleteCharAt(1);
			}
			sb.deleteCharAt(0);
		}
	}

	void f7() {
		StringBuffer sb = new StringBuffer();
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			sb.append(c1);
			for (char c2 = 'a'; c2 <= 'b'; c2++) {
				sb.append(c2);
				for (char c3 = 'a'; c3 <= max(c1, c2) + 1; c3++) {
					sb.append(c3);
					for (char c4 = 'a'; c4 <= max(c1, c2, c3) + 1; c4++) {
						sb.append(c4);
						for (char c5 = 'a'; c5 <= max(c1, c2, c3, c4) + 1; c5++) {
							sb.append(c5);
							for (char c6 = 'a'; c6 <= max(c1, c2, c3, c4, c5) + 1; c6++) {
								sb.append(c6);
								for (char c7 = 'a'; c7 <= max(c1, c2, c3, c4, c5, c6) + 1; c7++) {
									sb.append(c7);
									out.println(sb.toString());
									sb.deleteCharAt(6);
								}
								sb.deleteCharAt(5);
							}
							sb.deleteCharAt(4);
						}
						sb.deleteCharAt(3);
					}
					sb.deleteCharAt(2);
				}
				sb.deleteCharAt(1);
			}
			sb.deleteCharAt(0);
		}
	}

	void f8() {
		StringBuffer sb = new StringBuffer();
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			sb.append(c1);
			for (char c2 = 'a'; c2 <= 'b'; c2++) {
				sb.append(c2);
				for (char c3 = 'a'; c3 <= max(c1, c2) + 1; c3++) {
					sb.append(c3);
					for (char c4 = 'a'; c4 <= max(c1, c2, c3) + 1; c4++) {
						sb.append(c4);
						for (char c5 = 'a'; c5 <= max(c1, c2, c3, c4) + 1; c5++) {
							sb.append(c5);
							for (char c6 = 'a'; c6 <= max(c1, c2, c3, c4, c5) + 1; c6++) {
								sb.append(c6);
								for (char c7 = 'a'; c7 <= max(c1, c2, c3, c4, c5, c6) + 1; c7++) {
									sb.append(c7);
									for (char c8 = 'a'; c8 <= max(c1, c2, c3, c4, c5, c6, c7) + 1; c8++) {
										sb.append(c8);
										out.println(sb.toString());
										sb.deleteCharAt(7);
									}
									sb.deleteCharAt(6);
								}
								sb.deleteCharAt(5);
							}
							sb.deleteCharAt(4);
						}
						sb.deleteCharAt(3);
					}
					sb.deleteCharAt(2);
				}
				sb.deleteCharAt(1);
			}
			sb.deleteCharAt(0);
		}
	}

	void f9() {
		StringBuffer sb = new StringBuffer();
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			sb.append(c1);
			for (char c2 = 'a'; c2 <= 'b'; c2++) {
				sb.append(c2);
				for (char c3 = 'a'; c3 <= max(c1, c2) + 1; c3++) {
					sb.append(c3);
					for (char c4 = 'a'; c4 <= max(c1, c2, c3) + 1; c4++) {
						sb.append(c4);
						for (char c5 = 'a'; c5 <= max(c1, c2, c3, c4) + 1; c5++) {
							sb.append(c5);
							for (char c6 = 'a'; c6 <= max(c1, c2, c3, c4, c5) + 1; c6++) {
								sb.append(c6);
								for (char c7 = 'a'; c7 <= max(c1, c2, c3, c4, c5, c6) + 1; c7++) {
									sb.append(c7);
									for (char c8 = 'a'; c8 <= max(c1, c2, c3, c4, c5, c6, c7) + 1; c8++) {
										sb.append(c8);
										for (char c9 = 'a'; c9 <= max(c1, c2, c3, c4, c5, c6, c7, c8) + 1; c9++) {
											sb.append(c9);
											out.println(sb.toString());
											sb.deleteCharAt(8);
										}
										sb.deleteCharAt(7);
									}
									sb.deleteCharAt(6);
								}
								sb.deleteCharAt(5);
							}
							sb.deleteCharAt(4);
						}
						sb.deleteCharAt(3);
					}
					sb.deleteCharAt(2);
				}
				sb.deleteCharAt(1);
			}
			sb.deleteCharAt(0);
		}
	}

	void f10() {
		StringBuffer sb = new StringBuffer();
		for (char c1 = 'a'; c1 <= 'a'; c1++) {
			sb.append(c1);
			for (char c2 = 'a'; c2 <= 'b'; c2++) {
				sb.append(c2);
				for (char c3 = 'a'; c3 <= max(c1, c2) + 1; c3++) {
					sb.append(c3);
					for (char c4 = 'a'; c4 <= max(c1, c2, c3) + 1; c4++) {
						sb.append(c4);
						for (char c5 = 'a'; c5 <= max(c1, c2, c3, c4) + 1; c5++) {
							sb.append(c5);
							for (char c6 = 'a'; c6 <= max(c1, c2, c3, c4, c5) + 1; c6++) {
								sb.append(c6);
								for (char c7 = 'a'; c7 <= max(c1, c2, c3, c4, c5, c6) + 1; c7++) {
									sb.append(c7);
									for (char c8 = 'a'; c8 <= max(c1, c2, c3, c4, c5, c6, c7) + 1; c8++) {
										sb.append(c8);
										for (char c9 = 'a'; c9 <= max(c1, c2, c3, c4, c5, c6, c7, c8) + 1; c9++) {
											sb.append(c9);
											for (char c10 = 'a'; c10 <= max(c1, c2, c3, c4, c5, c6, c7, c8, c9)
													+ 1; c10++) {
												sb.append(c10);
												out.println(sb.toString());
												sb.deleteCharAt(9);
											}
											sb.deleteCharAt(8);
										}
										sb.deleteCharAt(7);
									}
									sb.deleteCharAt(6);
								}
								sb.deleteCharAt(5);
							}
							sb.deleteCharAt(4);
						}
						sb.deleteCharAt(3);
					}
					sb.deleteCharAt(2);
				}
				sb.deleteCharAt(1);
			}
			sb.deleteCharAt(0);
		}
	}

	public void _main(String[] args) {
		Scanner sc = new Scanner(in);

		int N = sc.nextInt();

		sc.close();

		switch (N) {
		case 1:
			f1();
			break;
		case 2:
			f2();
			break;
		case 3:
			f3();
			break;
		case 4:
			f4();
			break;
		case 5:
			f5();
			break;
		case 6:
			f6();
			break;
		case 7:
			f7();
			break;
		case 8:
			f8();
			break;
		case 9:
			f9();
			break;
		case 10:
			f10();
			break;
		}

	}

	public static void main(String[] args) {
		new Main()._main(args);
	}

	@SuppressWarnings("unused")
	private char max(char... arr) {
		if (arr == null || arr.length == 0) {
			throw new IllegalArgumentException(Arrays.toString(arr));
		}

		char candidate = arr[0];
		for (int i = 1; i < arr.length; i++) {
			candidate = candidate > arr[i] ? candidate : arr[i];
		}
		return candidate;
	}
}
