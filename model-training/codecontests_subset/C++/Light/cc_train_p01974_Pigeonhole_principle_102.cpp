#include <cstdlib>
#include <iostream>
#include <vector>
using namespace std;

int main() {
	int N, i, j;
	cin >> N;
	vector<int> a(N);
	for (int& k : a) cin >> k;
	for (i = 0; i < N - 1; ++i) {
		for (j = 1 + i; j < N; ++j) {
			if (0 == abs(a[i] - a[j]) % (N - 1)) break;
		}
		if (N != j) break;
	}
	cout << a[i] << ' ' << a[j] << endl;
}
