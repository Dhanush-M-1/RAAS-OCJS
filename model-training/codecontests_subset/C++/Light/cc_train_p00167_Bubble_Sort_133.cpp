#include <stdio.h>

int swap(int *x, int *y)
{
	int tmp = *x;
	*x = *y;
	*y = tmp;

	return (0);
}

int bsort(int *data, int last)
{
	int count = 0;
	for (int i = 0; i < last; i++){
		if (data[i] > data[i + 1]){
			swap(data + i, data + i + 1);
			count++;
		}
	}
	return (count);
}

int main()
{
	int array[128];
	int n, i;

	while (scanf("%d", &n), n){
		for (i = 0; i < n; i++){
			scanf("%d", array + i);
		}
		int sum = 0;
		for (i = 1; i < n; i++){
			sum += bsort(array, n - i);
		}

		printf("%d\n", sum);
	}

	return (0);
}