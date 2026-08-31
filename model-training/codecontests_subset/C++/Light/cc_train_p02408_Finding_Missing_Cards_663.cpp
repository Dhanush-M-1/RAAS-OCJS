#include<iostream>
using namespace std;

bool arr[4][55];
int n, m;
int id(char c) {
	if (c == 'S') return 0;
	if (c == 'H') return 1;
	if (c == 'C') return 2;
	if (c == 'D') return 3;
}
char mrk[] = {'S', 'H', 'C', 'D'}, c;

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> c >> m;
		arr[id(c)][m] = true;
	}

	for (int i = 0; i < 4; i++) for (int j = 1; j <= 13; j++) {
		if (!arr[i][j]) cout << mrk[i] << " " << j << endl;
	}
	return 0;
}

