#include <iostream>
using namespace std;
int main() {
	int n;
	cin >> n;
	bool c[4][13] = {};
	for (int i=0; i<n; i++) {
		char m;
		int r;
		cin >> m >> r;
		c[m=='S'?0 : m=='H'?1 : m=='C'?2 : 3][r-1] = true;
	}
	for (int i=0; i<4; i++) {
		for (int j=0; j<13; j++) {
			if (!c[i][j])
				cout << (i==0?'S' : i==1?'H' : i==2?'C' : 'D') << " " << j+1 << endl;
		}
	}
}