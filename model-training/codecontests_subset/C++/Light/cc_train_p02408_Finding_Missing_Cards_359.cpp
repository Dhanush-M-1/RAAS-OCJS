#include <iostream>
using namespace std;
#define h for(int i = 1; i < 14; i++)
int S[14], H[14], C[14], D[14];
int main() {
	int a, x;
	char y;
	cin >> a;
	for (int i = 0; i < a; i++) {
	    cin >> y >> x;
	    if (y == 'S') S[x]++;
	    if (y == 'H') H[x]++;
	    if (y == 'C') C[x]++;
	    if (y == 'D') D[x]++;
	}
	h {
	    if (S[i] == 0) cout << "S " << i << endl;
	}
	h {
	    if (H[i] == 0) cout << "H " << i << endl;
	}
	h {
	    if (C[i] == 0) cout << "C " << i << endl;
	}
	h {
	    if (D[i] == 0) cout << "D " << i << endl;
	}
}

