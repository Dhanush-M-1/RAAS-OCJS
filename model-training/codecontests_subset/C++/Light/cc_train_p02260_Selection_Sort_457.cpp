#include <bits/stdc++.h>

using namespace std;

int main() {
	int N;
	cin >> N;

	vector<int> arr(N);
	for (auto &a: arr) {
		cin >> a;
	}

	int swaps = 0;
	for (int i = 0; i < N-1; ++i) {
		int minj = i;
		for (int j = i+1; j < N; ++j) {
			if (arr[j] < arr[minj]) {
				minj = j;
			}
		}
		if (i != minj) {
			swap(arr[i], arr[minj]);
			++swaps;
		}
	}

	cout << arr[0];
	for (int i = 1; i < N; ++i) {
		cout << ' ' << arr[i];
	}
	cout << '\n';
	cout << swaps << endl;
}
