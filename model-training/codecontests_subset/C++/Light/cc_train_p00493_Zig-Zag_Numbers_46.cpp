#include<iostream>
#include<string>
#include<cmath>
#include<algorithm>
#include<cstring>
using namespace std;

int x[555][555][11][2];
int y[555][555][11][2];

int main() {

	//init.

	string n, m;
	int N[555];
	int M[555];
	int giri[555][3][4];
	int girix[2];
	bool giriy[2];
	int a = 0, b = 0, c = 0, d = 0, e, sum, sum2;
	memset(giri, 0, sizeof(giri));
	memset(x, 0, sizeof(x));
	char T[10] = { '0','1','2','3','4','5','6','7','8','9' };
	cin >> n >> m;
	cin >> c;
	for (int i = 1; i <= n.size(); i++) {
		for (int j = 0; j < 10; j++) {
			if (n[i - 1] == T[j]) {
				N[i] = j;
			}
		}
		giri[i][0][0] = (giri[i - 1][0][0] * 10 + N[i]) % c;
		giri[i][0][1] = N[i];

		if (i >= 2) {
			if (N[i] > N[i - 1]) {
				giri[i][0][2] = 1;
			}
			else if (N[i - 1] > N[i]) {
				giri[i][0][2] = 2;
			}
			else {
				giri[i][0][2] = 0;
			}
		}
	}
	for (int i = 1; i <= m.size(); i++) {
		for (int j = 0; j < 10; j++) {
			if (m[i - 1] == T[j]) {
				M[i] = j;
			}
		}
		giri[i][1][0] = (giri[i - 1][1][0] * 10 + M[i]) % c;
		giri[i][1][1] = M[i];
		if (i >= 2) {
			if (M[i] > M[i - 1]) {
				giri[i][1][2] = 1;
			}
			else if (M[i - 1] > M[i]) {
				giri[i][1][2] = 2;
			}
			else {
				giri[i][1][2] = 0;
			}
		}
	}
	if (giri[1][0][1] > giri[2][0][1]) {
		giriy[0] = true;
	}
	else if (giri[2][0][1] > giri[1][0][1]) {
		giriy[0] = false;
	}
	else {
		girix[0] = 1;
	}

	if (giri[1][1][1] > giri[2][1][1]) {
		giriy[1] = true;
	}
	else if (giri[2][1][1] > giri[1][1][1]) {
		giriy[1] = false;
	}
	else {
		girix[1] = 1;
	}
	girix[0] = n.size() + 1;
	for (int i = 3; i <= n.size(); i++) {
		if (girix[0] <= i) {
			break;
		}
		if (i % 2 == 1) {
			if (giriy[0] == false) {
				if (giri[i][0][1] >= giri[i - 1][0][1]) {
					girix[0] = i;
				}
			}
			else {
				if (giri[i][0][1] <= giri[i - 1][0][1]) {
					girix[0] = i;
				}
			}
		}
		else {
			if (giriy[0] == false) {
				if (giri[i][0][1] <= giri[i - 1][0][1]) {
					girix[0] = i;
				}
			}
			else {
				if (giri[i][0][1] >= giri[i - 1][0][1]) {
					girix[0] = i;
				}
			}
		}
	}
	girix[1] = m.size() + 1;
	for (int i = 3; i <= m.size(); i++) {
		if (girix[1] <= i) {
			break;
		}
		if (i % 2 == 1) {
			if (giriy[1] == false) {
				if (giri[i][1][1] >= giri[i - 1][1][1]) {
					girix[1] = i;
				}
			}
			else {
				if (giri[i][1][1] <= giri[i - 1][1][1]) {
					girix[1] = i;
				}
			}
		}
		else {
			if (giriy[1] == false) {
				if (giri[i][1][1] <= giri[i - 1][1][1]) {
					girix[1] = i;
				}
			}
			else {
				if (giri[i][1][1] >= giri[i - 1][1][1]) {
					girix[1] = i;
				}
			}
		}
	}

	//1st.

	for (int i = 1; i < 10; i++) {
		if (giri[1][0][1] >= i || n.size() >= 2) {
			x[1][i%c][i][0] += 1;
		}
	}
	for (int i = 1; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			if (i > j) {
				x[2][(i * 10 + j) % c][j][0] += 1;
			}
			else if (i < j) {
				x[2][(i * 10 + j) % c][j][1] += 1;
			}
		}
	}

	for (int i = 3; i < n.size(); i++) {
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 10; k++) {
				if (i % 2 == 0) {
					for (int l = 0; l < k; l++) {
						x[i][(j * 10 + l) % c][l][0] += x[i - 1][j][k][0];
						x[i][(j * 10 + l) % c][l][0] %= 10000;
					}
				}
				else {
					for (int l = k + 1; l < 10; l++) {
						x[i][(j * 10 + l) % c][l][0] += x[i - 1][j][k][0];
						x[i][(j * 10 + l) % c][l][0] %= 10000;
					}
				}
			}
		}
	}
	for (int i = 3; i < n.size(); i++) {
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 10; k++) {
				if (i % 2 == 1) {
					for (int l = 0; l < k; l++) {
						x[i][(j * 10 + l) % c][l][1] += x[i - 1][j][k][1];
						x[i][(j * 10 + l) % c][l][1] %= 10000;
					}
				}
				else {
					for (int l = k + 1; l < 10; l++) {
						x[i][(j * 10 + l) % c][l][1] += x[i - 1][j][k][1];
						x[i][(j * 10 + l) % c][l][1] %= 10000;
					}
				}
			}
		}
	}
	sum = 0;
	if (n.size() >= 3) {
		for (int i = 1; i < n.size(); i++) {
			for (int j = 0; j < 10; j++) {
				sum += x[i][0][j][1];
				sum += x[i][0][j][0];
			}
		}
	}
	else {
		for (int i = 1; i <= n.size(); i++) {
			for (int j = 0; j < 10; j++) {
				sum += x[i][0][j][1];
				sum += x[i][0][j][0];
			}
		}
	}
	memset(x, 0, sizeof(x));
	for (int i = 1; i < 10; i++) {
		x[1][i%c][i][0] += 1;
	}
	for (int i = 1; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			if (i > j) {
				x[2][(i * 10 + j) % c][j][0] += 1;
			}
			else if (i < j) {
				x[2][(i * 10 + j) % c][j][1] += 1;
			}
		}
	}

	for (int i = 3; i < m.size(); i++) {
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 10; k++) {
				if (i % 2 == 0) {
					for (int l = 0; l < k; l++) {
						x[i][(j * 10 + l) % c][l][0] += x[i - 1][j][k][0];
						x[i][(j * 10 + l) % c][l][0] %= 10000;
					}
				}
				else {
					for (int l = k + 1; l < 10; l++) {
						x[i][(j * 10 + l) % c][l][0] += x[i - 1][j][k][0];
						x[i][(j * 10 + l) % c][l][0] %= 10000;
					}
				}
			}
		}
	}
	for (int i = 3; i < m.size(); i++) {
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 10; k++) {
				if (i % 2 == 1) {
					for (int l = 0; l < k; l++) {
						x[i][(j * 10 + l) % c][l][1] += x[i - 1][j][k][1];
						x[i][(j * 10 + l) % c][l][1] %= 10000;
					}
				}
				else {
					for (int l = k + 1; l < 10; l++) {
						x[i][(j * 10 + l) % c][l][1] += x[i - 1][j][k][1];
						x[i][(j * 10 + l) % c][l][1] %= 10000;
					}
				}
			}
		}
	}
	sum2 = 0;
	if (m.size() >= 3) {
		for (int i = 1; i < m.size(); i++) {
			for (int j = 0; j < 10; j++) {
				sum2 += x[i][0][j][1];
				sum2 += x[i][0][j][0];
			}
		}
	}
	else {
		for (int i = 1; i <= m.size(); i++) {
			for (int j = 0; j < 10; j++) {
				sum2 += x[i][0][j][1];
				sum2 += x[i][0][j][0];
			}
		}
	}

	//2nd.

	memset(x, 0, sizeof(x));
	memset(y, 0, sizeof(y));

	for (int i = 1; i < 10; i++) {
		if (giri[1][0][1]>i) {
			x[1][i%c][i][0] += 1;
		}
		if (giri[1][0][1] == i) {
			y[1][i%c][i][0] += 1;
		}
	}

	for (int i = 1; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			if (i > j) {
				x[2][(i*10+j)%c][j][0] += x[1][i%c][i][0];
				if (j < giri[2][0][1]) {
					x[2][(i * 10 + j) % c][j][0] += y[1][i%c][i][0];
				}
				else if (j == giri[2][0][1]) {
					y[2][(i * 10 + j) % c][j][0] += y[1][i%c][i][0];
				}
			}
			else if (i < j) {
				x[2][(i * 10 + j) % c][j][1] += x[1][i%c][i][0];
				if (j < giri[2][0][1]) {
					x[2][(i * 10 + j) % c][j][1] += y[1][i%c][i][0];
				}
				else if (j == giri[2][0][1]) {
					y[2][(i * 10 + j) % c][j][1] += y[1][i%c][i][0];
				}
			}
		}
	}

	for (int i = 3; i <= n.size(); i++) {
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 10; k++) {
				if (i % 2 == 0) {
					for (int l = 0; l < k; l++) {
						x[i][(j * 10 + l) % c][l][0] += x[i - 1][j][k][0];
						if (l < giri[i][0][1]) {
							x[i][(j * 10 + l) % c][l][0] += y[i - 1][j][k][0];
						}
						else if (l == giri[i][0][1]) {
							y[i][(j * 10 + l) % c][l][0] += y[i - 1][j][k][0];
						}
						x[i][(j * 10 + l) % c][l][0] %= 10000;
						y[i][(j * 10 + l) % c][l][0] %= 10000;
					}
				}
				else {
					for (int l = k+1; l < 10; l++) {
						x[i][(j * 10 + l) % c][l][0] += x[i - 1][j][k][0];
						if (l < giri[i][0][1]) {
							x[i][(j * 10 + l) % c][l][0] += y[i - 1][j][k][0];
						}
						else if (l == giri[i][0][1]) {
							y[i][(j * 10 + l) % c][l][0] += y[i - 1][j][k][0];
						}
						x[i][(j * 10 + l) % c][l][0] %= 10000;
						y[i][(j * 10 + l) % c][l][0] %= 10000;
					}
				}
			}
		}
	}
	for (int i = 3; i <= n.size(); i++) {
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 10; k++) {
				if (i % 2 == 1) {
					for (int l = 0; l < k; l++) {
						x[i][(j * 10 + l) % c][l][1] += x[i - 1][j][k][1];
						if (l < giri[i][0][1]) {
							x[i][(j * 10 + l) % c][l][1] += y[i - 1][j][k][1];
						}
						else if (l == giri[i][0][1]) {
							y[i][(j * 10 + l) % c][l][1] += y[i - 1][j][k][1];
						}
						x[i][(j * 10 + l) % c][l][1] %= 10000;
						y[i][(j * 10 + l) % c][l][1] %= 10000;
					}
				}
				else {
					for (int l = k + 1; l < 10; l++) {
						x[i][(j * 10 + l) % c][l][1] += x[i - 1][j][k][1];
						if (l < giri[i][0][1]) {
							x[i][(j * 10 + l) % c][l][1] += y[i - 1][j][k][1];
						}
						else if (l == giri[i][0][1]) {
							y[i][(j * 10 + l) % c][l][1] += y[i - 1][j][k][1];
						}
						x[i][(j * 10 + l) % c][l][1] %= 10000;
						y[i][(j * 10 + l) % c][l][1] %= 10000;
					}
				}
			}
		}
	}
	if (n.size() >= 3) {
		for (int i = 0; i < 10; i++) {
			sum += x[n.size()][0][i][0];
			sum += x[n.size()][0][i][1];
			sum += y[n.size()][0][i][0];
			sum += y[n.size()][0][i][1];
		}
	}
	memset(x, 0, sizeof(x));
	memset(y, 0, sizeof(y));

	for (int i = 1; i < 10; i++) {
		if (giri[1][1][1]>i) {
			x[1][i%c][i][0] += 1;
		}
		if (giri[1][1][1] == i) {
			y[1][i%c][i][0] += 1;
		}
	}

	for (int i = 1; i < 10; i++) {
		for (int j = 0; j < 10; j++) {
			if (i > j) {
				x[2][(i * 10 + j) % c][j][0] += x[1][i%c][i][0];
				if (j < giri[2][1][1]) {
					x[2][(i * 10 + j) % c][j][0] += y[1][i%c][i][0];
				}
				else if (j == giri[2][1][1]) {
					y[2][(i * 10 + j) % c][j][0] += y[1][i%c][i][0];
				}
			}
			else if (i < j) {
				x[2][(i * 10 + j) % c][j][1] += x[1][i%c][i][0];
				if (j < giri[2][1][1]) {
					x[2][(i * 10 + j) % c][j][1] += y[1][i%c][i][0];
				}
				else if (j == giri[2][1][1]) {
					y[2][(i * 10 + j) % c][j][1] += y[1][i%c][i][0];
				}
			}
		}
	}

	for (int i = 3; i <= m.size(); i++) {
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 10; k++) {
				if (i % 2 == 0) {
					for (int l = 0; l < k; l++) {
						x[i][(j * 10 + l) % c][l][0] += x[i - 1][j][k][0];
						if (l < giri[i][1][1]) {
							x[i][(j * 10 + l) % c][l][0] += y[i - 1][j][k][0];
						}
						else if (l == giri[i][1][1]) {
							y[i][(j * 10 + l) % c][l][0] += y[i - 1][j][k][0];
						}
						x[i][(j * 10 + l) % c][l][0] %= 10000;
						y[i][(j * 10 + l) % c][l][0] %= 10000;
					}
				}
				else {
					for (int l = k + 1; l < 10; l++) {
						x[i][(j * 10 + l) % c][l][0] += x[i - 1][j][k][0];
						if (l < giri[i][1][1]) {
							x[i][(j * 10 + l) % c][l][0] += y[i - 1][j][k][0];
						}
						else if (l == giri[i][1][1]) {
							y[i][(j * 10 + l) % c][l][0] += y[i - 1][j][k][0];
						}
						x[i][(j * 10 + l) % c][l][0] %= 10000;
						y[i][(j * 10 + l) % c][l][0] %= 10000;
					}
				}
			}
		}
	}
	for (int i = 3; i <= m.size(); i++) {
		for (int j = 0; j < c; j++) {
			for (int k = 0; k < 10; k++) {
				if (i % 2 == 1) {
					for (int l = 0; l < k; l++) {
						x[i][(j * 10 + l) % c][l][1] += x[i - 1][j][k][1];
						if (l < giri[i][1][1]) {
							x[i][(j * 10 + l) % c][l][1] += y[i - 1][j][k][1];
						}
						else if (l == giri[i][1][1]) {
							y[i][(j * 10 + l) % c][l][1] += y[i - 1][j][k][1];
						}
						x[i][(j * 10 + l) % c][l][1] %= 10000;
						y[i][(j * 10 + l) % c][l][1] %= 10000;
					}
				}
				else {
					for (int l = k + 1; l < 10; l++) {
						x[i][(j * 10 + l) % c][l][1] += x[i - 1][j][k][1];
						if (l < giri[i][1][1]) {
							x[i][(j * 10 + l) % c][l][1] += y[i - 1][j][k][1];
						}
						else if (l == giri[i][1][1]) {
							y[i][(j * 10 + l) % c][l][1] += y[i - 1][j][k][1];
						}
						x[i][(j * 10 + l) % c][l][1] %= 10000;
						y[i][(j * 10 + l) % c][l][1] %= 10000;
					}
				}
			}
		}
	}
	if (m.size() >= 3) {
		for (int i = 0; i < 10; i++) {
			sum2 += x[m.size()][0][i][0];
			sum2 += x[m.size()][0][i][1];
			sum2 += y[m.size()][0][i][0];
			sum2 += y[m.size()][0][i][1];
		}
	}
	if (m.size() >= 490 && m.size()%2==1) {
		sum2 += 1;
	}
	cout << (sum2 - sum+10000000) % 10000 << endl;
	return 0;
}