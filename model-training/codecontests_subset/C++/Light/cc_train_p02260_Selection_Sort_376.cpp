#include <stdio.h>

int main() {
	int n, mini, tmp, swap;
	scanf("%d", &n);

	int arr[n];

	for (int i=0; i<n;i++) {
		scanf("%d", &arr[i]);
	}

	swap = 0;
	for (int i=0; i<n; i++) {
		mini = i;
		for (int j = i; j<n;j++) {
			if (arr[j] < arr[mini]) {
				mini = j;
			}
		}

		tmp = arr[i];
		arr[i] = arr[mini];
		arr[mini] = tmp;
		swap += (mini != i);
	}

	printf("%d", arr[0]);
	for (int i=1; i<n; i++) {
		printf(" %d", arr[i]);
	}
	printf("\n%d\n", swap);
}

