#include<iostream>
#include<string>
using namespace std;

int k[5] = { 5,7,5,7,7 };
int main() {
	int a;
	while (cin >> a, a) {
		int b[40];
		for (int c = 0; c < a; c++) {
			string d; cin >> d;
			b[c] = d.length();
		}
		for (int i = 0; i < a; i++) {
			int x = 0, y = 0;
			for (int j = i; j < a; j++) {
				if (y + b[j] > k[x])break;
				else if (y + b[j] < k[x])y += b[j];
				else { 
					x++; y = 0;
				if (x == 5) { cout << i + 1 << endl; goto l; }
				}
			}
		}
	l:;
	}
}