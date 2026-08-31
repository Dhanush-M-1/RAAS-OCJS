#include <cstdio>
#include <cstring>
int n, l[44]; char c[12];
int main() {
	while (scanf("%d", &n), n) {
		for (int i = 0; i < n; i++) scanf("%s", c), l[i] = strlen(c);
		for (int i = 0; i < n; i++) {
			int s = 0, v = 0;
			for (int j = i; j < n && s < 5; j++) {
				v += l[j];
				if (3 % (s + 1) == 0) {
					if (v > 5) break;
					else if (v == 5) s++, v = 0;
				}
				else {
					if (v > 7) break;
					else if (v == 7) s++, v = 0;
				}
			}
			if (s == 5) {
				printf("%d\n", i + 1); break;
			}
		}
	}
}