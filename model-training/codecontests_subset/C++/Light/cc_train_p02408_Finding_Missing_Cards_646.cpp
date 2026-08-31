#include <iostream>
using namespace std;

int main() {
	const int n = 13;
	const int m = 4;
	char mark[4] = {'S', 'H', 'C', 'D'};
	
	int q;
	cin >> q;
	bool card[m][n] = {{}};
	while (q--) {
		char c;
		int num;
		cin >> c >> num;
		for (int i = 0; i < 4; i++) {
			if (mark[i] == c) {
				card[i][num - 1] = true;
			}
		}
	}
	
	for (int i = 0; i < m; i++) {
		for (int j = 0; j < n; j++) {
			if (not card[i][j]) {
				cout << mark[i] << ' ' << j + 1 << endl;
			}
		}
	}
	
	return 0;
}
