#include<cstdio>
int main() {
	int i, j, n, minj, tmp, a[100], count = 0;
	scanf("%d", &n);
	for (i = 0; i < n; i++) {
		scanf("%d", &a[i]);
	}
	for (i = 0; i < n; i++) {
		minj = i;
		for (j = i; j < n; j++) {
			if (a[j] < a[minj])minj = j;
		}
		if (a[i] != a[minj]) {
			count++;
		}
		tmp = a[i];
		a[i] = a[minj];
		a[minj] = tmp;
	}
	printf("%d", a[0]);
	for (i = 1; i < n; i++) {
		printf(" %d", a[i]);
	}
	printf("\n%d\n", count);
	return 0;
}
