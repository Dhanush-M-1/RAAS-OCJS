#include<iostream>
using namespace std;

int main() {
	int n;
	cin >> n;
	bool arry[4][13] = { false };
	int rearr[100];
	char k;
	int num;
	while (1) {
		for (int i = 1; i <= n; i++) {
			cin >> k >> num;
			int m = k == 'S' ? 0 : k == 'H' ? 1 : k == 'C' ? 2 : k == 'D' ? 3 : NULL;
			arry[m][num-1] = true;
		}

		for (int j = 0; j < 4; j++) {
			for (int l = 0; l < 13; l++) {
				if (arry[j][l] == 0) {
					char q = j == 0 ? 'S' : j == 1 ? 'H' : j == 2 ? 'C' : j == 3 ? 'D' : NULL;
					cout << q << " " << l+1  << endl;
				}
			
			}

		}
		break;
	}

}

