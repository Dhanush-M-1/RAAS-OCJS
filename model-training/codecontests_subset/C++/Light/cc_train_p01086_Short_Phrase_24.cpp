#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
	int n;
	while (cin >> n, n) {
		vector<int> w(n);
		for (int i = 0; i < n; ++i) {
			string s; cin >> s;
			w[i] = s.size();
		}
		int ok[] = { 5,7,5,7,7 };
		for (int i = 0; i < n; ++i) {
			int sum = 0, now = 0, j = 0;
			while (now < 5 && sum < ok[now]) {
				sum += w[i + j++];
				if (sum == ok[now]) now++, sum = 0;
			}
			if (now == 5) {
				cout << i + 1 << endl;
				break;
			}
		}
	}

	return 0;
}
