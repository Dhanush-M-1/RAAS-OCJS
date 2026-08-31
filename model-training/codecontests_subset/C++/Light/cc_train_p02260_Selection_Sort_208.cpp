#include<iostream>
using namespace std;
int main() {
	int n;
	cin >> n;
	int a[n];
	for (int i = 0; i < n; i++) {
		cin >> a[i];
	}
	int swapCount = 0;
	for (int i = 0; i < n; i++) {
		int mini = i;
		for (int j = i; j < n; j++){
			if (a[j] < a[mini]) mini = j;
		}
		if (mini != i) {
			int tmp = a[i];
			a[i] = a[mini];
			a[mini] = tmp;
			swapCount++;
		}
	}
	for (int i = 0; i < n - 1; i++) {
		cout << a[i] << ' ';
	}
	cout << a[n - 1] << '\n' << swapCount << '\n';
}
