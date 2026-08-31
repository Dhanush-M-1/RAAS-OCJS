#include <iostream>
#include <utility>
#include <vector>
using namespace std;

int main() {
	int N, ans = 0, tmp;
	cin >> N;
	vector<int> A(N);
	for (int& i : A) cin >> i;
	for (int i = 1; i < N; ++i) {
		tmp = i - 1;
		for (int j = i; j < N; ++j) {
			if (A[tmp] > A[j]) tmp = j;
		}
		if (tmp != i - 1) ++ans;
		swap(A[tmp], A[i - 1]);
	}
	for (int i = 1; i < N; ++i) cout << A[i - 1] << ' ';
	cout << A[N - 1] << endl << ans << endl;
}
