#include <iostream>

int bubblesort(int* a, int n)
{
	int res = 0;
	for (int i=n-1; i>=0; i--) {
		for (int j=0; j<i; j++) {
			if (a[j] > a[j+1]) {
				std::swap(a[j], a[j+1]); res++;
			}
		}
	}
	return res;
}

int main()
{
	int n;
	while (true) {
		std::cin >> n;
		if (n==0) break;
		int* a = new int[n];
		for (int i=0; i<n; i++) std::cin >> a[i];
		std::cout << bubblesort(a, n) << std::endl;
		delete[] a;
	}
	return 0;
}

