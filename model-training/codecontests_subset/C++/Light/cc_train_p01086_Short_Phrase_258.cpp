#include <bits/stdc++.h>
using namespace std;

bool check(int start, const vector<string> &words) {
	const array<int, 5> num{{5, 7, 5, 7, 7}};

	int idx = 0;
	int sum = 0;
	for(int i = start; i < words.size(); ++i) {
		sum += words[i].size();

		if(sum == num[idx]) {
			if(++idx == 5) return true;
			sum = 0;
		}
		else if(sum > num[idx]) {
			return false;
		}
	}
	return false;
}

int main() {
	cin.tie(nullptr);
	ios::sync_with_stdio(false);

	for(int n; cin >> n && n;) {
		vector<string> words(n);
		for(auto &e : words) cin >> e;

		for(int i = 0; i < n; ++i) {
			if(check(i, words)) {
				cout << i + 1 << endl;
				break;
			}
		}
	}

	return EXIT_SUCCESS;
}