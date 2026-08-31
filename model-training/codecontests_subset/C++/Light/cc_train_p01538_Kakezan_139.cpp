#include<iostream>
#include<algorithm>
#include<string>
#include<vector>
#include<map>
#include<queue>
using namespace std;
#define REP(i, a, n) for(int i=a; i<n; i++)
#define INF 1000000000

int main() {
	int Q;
	string N[101];
	cin >> Q;
	REP(i, 0, Q) cin >> N[i];

	REP(i, 0, Q) {
		int cnt = 0;
		string val = N[i];
		while (1) {
			if (val.size() == 1) {
				cout << cnt << endl;
				break;
			}
			if (cnt > 10000) {
				cout << -1 << endl;
				break;
			}

			int maxi = 0;
			REP(j, 1, val.size()) {
				int l = stoi(val.substr(0, j));
				int r = stoi(val.substr(j));
				maxi = max(maxi, l*r);
			}
			val = to_string(maxi);
			cnt++;
		}
	}

	return 0;
}