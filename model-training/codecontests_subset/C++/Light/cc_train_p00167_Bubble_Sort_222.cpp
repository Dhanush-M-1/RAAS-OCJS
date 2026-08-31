#include <stdio.h>
int n, a[100];
int main() {
	while(true) {
		scanf("%d", &n);
		if(n == 0) break;
		for(int i = 0; i < n; i++) scanf("%d", &a[i]);
		int ret = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(a[i] < a[j]) {
					ret++;
				}
			}
		}
		printf("%d\n", ret);
	}
	return 0;
}