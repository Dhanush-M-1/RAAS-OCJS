#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <tuple>
#include <queue>
#include <stack>
#include <set>
#include <map>

using namespace std;

class Solver {
};
int main() {
	while (true) {
		int n;
		cin >> n;
		if (n == 0)break;

		vector<int> lens;
		for (int i = 0; i < n; i++) {
			string s;
			cin >> s;
			lens.emplace_back(s.size());
		}

		vector<int> cnts{ 5,7,5,7,7 };
		int start = -1;
		for (int i = 0; i < n; i++) {
			int now = 0;
			int tmp = 0;
			for (int j = i; j < n; j++) {
				tmp += lens[j];
				if (tmp > cnts[now])break;

				if (tmp == cnts[now]) {
					now++;
					tmp = 0;
					if (now == 5) {
						start = i;
						break;
					}
				}
			}

			if (start >= 0)break;
		}
		cout << start + 1 << endl;
	}
}
