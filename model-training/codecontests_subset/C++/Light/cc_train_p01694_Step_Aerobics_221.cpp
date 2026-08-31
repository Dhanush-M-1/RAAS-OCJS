#include <iostream>
#include <map>
#include <cmath>

using namespace std;

int main() {
	int n;
	while ( cin >> n, n ) {
		map<string, int> conv;
		conv["lu"] = 0;
		conv["ru"] = 1;
		conv["ld"] = 0;
		conv["rd"] = 1;
		int cnt[2] = {0};

		for (int i = 0; i < n; ++i) {
			string str; cin >> str;
			cnt[conv[str]]++;
			if (abs(cnt[0] - cnt[1]) >= 2) {
				int v = min(cnt[0], cnt[1]);
				cnt[0] = v;
				cnt[1] = v;
			}
		}
		cout << min(cnt[0], cnt[1]) << endl;
	}
}