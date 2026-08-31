#include <iostream>

using namespace std;

int main() {
	int n;
	char d;
	int p;
	int card[4][13] = {0};
	char q[4] = {'S','H','C','D'};
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> d >> p;
		if (d == 'S') {
			card[0][p-1] = 1;
		} else if (d == 'H') {
			card[1][p-1] = 1;
		} else if (d == 'C') {
			card[2][p-1] = 1;
		} else {
			card[3][p-1] = 1;
		}
	}

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 13; j++) {
			if (card[i][j] == 0) {
				cout << q[i] << ' ' << j+1 << endl;
			}
		}
	}
	return 0;
}