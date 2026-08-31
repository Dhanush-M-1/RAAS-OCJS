#include <stdio.h>
#include <iostream>

using namespace std;

int main() {
	int v[100];
	int n;
	int kari;
	int counter;
	
	while (cin >> n) {
		if (n == 0) {
			break;
		}
		counter = 0;
		for (int i = 0; i < n; i++) {
			cin >> v[i];
		}
		for (int i = n-1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (v[j] > v[j+1]) {
					kari = v[j];
					v[j] = v[j+1];
					v[j+1] = kari;
					counter++;
				}
			}
		}
		cout << counter << endl;
	}
	return 0;
}