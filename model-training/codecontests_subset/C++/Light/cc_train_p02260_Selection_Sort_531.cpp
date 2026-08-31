#include<iostream>

using namespace std;

int main() {
	int n;
	cin >> n;
	int* a = new int[n];
	for (int i = 0;i < n;i++) {
		cin >> a[i];
	}
	int count = 0;
	int minj;
	for (int i = 0;i < n - 1;i++) {
		minj = i;
		for (int j = i + 1;j < n;j++) {
			if (a[j] < a[minj])minj = j;
		}
		if (minj != i) {
			count++;
			swap(a[i], a[minj]);
		}
	}
	for (int i = 0;i < n - 1;i++) {
		cout << a[i] << " ";
	}
	cout << a[n - 1] << endl << count << endl;
}
