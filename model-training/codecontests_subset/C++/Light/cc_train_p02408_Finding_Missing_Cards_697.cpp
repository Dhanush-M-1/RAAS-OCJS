#include <iostream>
#include <stdio.h>

using namespace std;

int main() {
	int n, tmp2 = 0;
	char tmp1;
	bool array[4][13] = {};
	int mark[64] = {};
	mark['S' - 64] = 0;
	mark['H' - 64] = 1;
	mark['C' - 64] = 2;
	mark['D' - 64] = 3;
	char cards[4] = { 'S', 'H', 'C', 'D' };

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> tmp1;
		cin >> tmp2;
		array[mark[tmp1-64]][tmp2-1] = true;
	}

	for (int i = 0; i < 4; i++) {
		for (int j = 0; j < 13; j++) {
			if (array[i][j] != true) { cout << cards[i] << " " << j + 1 << endl; }
		}
	}

	cin >> n;
	return 0;
}
