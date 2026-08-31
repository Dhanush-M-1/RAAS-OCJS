#include <iostream>
using namespace std;
int n, a; char c; bool ok[4][13];
int main() {
	scanf("%d", &n);
	for(int i = 0; i < n; i++) {
		cin >> c >> a;
		if(c == 'S') ok[0][a - 1] = true;
		if(c == 'H') ok[1][a - 1] = true;
		if(c == 'C') ok[2][a - 1] = true;
		if(c == 'D') ok[3][a - 1] = true;
	}
	for(int i = 0; i < 4; i++) {
		for(int j = 0; j < 13; j++) {
			if(!ok[i][j]) {
				if(i == 0) printf("S %d\n", j + 1);
				if(i == 1) printf("H %d\n", j + 1);
				if(i == 2) printf("C %d\n", j + 1);
				if(i == 3) printf("D %d\n", j + 1);
			}
		}
	}
	return 0;
}