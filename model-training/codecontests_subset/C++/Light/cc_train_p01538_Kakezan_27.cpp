#include <iostream>

using namespace std;

int f(int n) {
	if (n < 10) return 0;
	int next = 0;
	for (int k = 10; n / k >= 1; k *= 10) {
		next = max(next, (n / k) * (n % k));
	}
	return f(next) + 1;
}

int main() {
	int Q; cin >> Q;
	for (int t = 0; t < Q; ++t) {
		int N; cin >> N;
		cout << f(N) << endl;
	}
}