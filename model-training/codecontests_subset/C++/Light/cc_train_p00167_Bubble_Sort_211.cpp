#include <stdio.h>
#include <iostream>

using namespace std;

int main() {
	int n;
	int k[100];
	int kari;
	int counter;

	while(cin >> n) {
		if (n == 0) {
			break;
		}
		counter = 0;
		for (int i = 0; i < n; i++) {
			cin >> k[i];
		}

		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j< i; j++) {
				if (k[j] > k[j+1]) {
					kari = k[j];
					k[j] = k[j+1];
					k[j+1] = kari;
					counter++;
				}
			}
		}

		cout << counter << endl;
	}
	return 0;
}