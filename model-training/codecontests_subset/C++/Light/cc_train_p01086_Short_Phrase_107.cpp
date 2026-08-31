#include "iostream"
#include "climits"
#include "list"
#include "queue"
#include "stack"
#include "set"
#include "functional"
#include "algorithm"
#include "string"
#include "map"
#include "iomanip"

using namespace std;

const long long int MOD = 1000000007;

long long int N, M, K, H, W, L, R;


int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> N;
	while (N) {
		vector<int>num(N);
		vector<int>sum(N);
		for (int i = 0; i < N; i++) {
			string s;
			cin >> s;
			num[i] = s.size();
		}
		for (int i = 0; i < N; i++) {
			M = 0;
			K = 0;
			for (int j = i; j < N; j++) {
				M += num[j];
				if (M == 5 || M == 12 || M == 17 || M == 24 || M == 31) {
					K++;
				}
			}
			if (K == 5) {
				cout << i + 1 << endl;
				break;
			}
		}
		cin >> N;
	}

	return 0;
}