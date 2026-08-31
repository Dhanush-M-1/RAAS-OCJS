#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <list>
#include <cstdio>
#include <cmath>
#include <cstring>
#include <algorithm>
#define N_MAX 1000

using namespace std;

int cnt = 0;

/* aとbの値を入れ替える */
void swap(int *a, int *b)
{
	int tmp;

	tmp = *a;
	*a = *b;
	*b = tmp;
}

/* バブルソート */
void bubble_sort(int a[], int n)
{
	int i, j;

	for (i = 0; i < n - 1; i++) {
		for (j = 0; j < n - 1 - i; j++) {
			if (a[j] > a[j + 1]) {
				swap(&a[j], &a[j + 1]);
				cnt++;
			}
		}
	}
}

int main()
{
	int n;
	int a[105];

	while (1) {
		cin >> n;
		if (n == 0) break;
		for (int i = 0; i < n; i++) {
			cin >> a[i];
		}
		cnt = 0;
		bubble_sort(a, n);
		cout << cnt << endl;
	}

	

	return (0);
}