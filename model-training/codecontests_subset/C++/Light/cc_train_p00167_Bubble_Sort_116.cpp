#include<bits/stdc++.h>
using namespace std;

int a[100];
int main() {
	int b;
	while (cin >> b, b) {
		for (int c = 0; c<b; c++)scanf("%d", &a[c]);
		int sum = 0;
		for (int d = 0; d < b - 1; d++) {
			for (int e = d + 1; e < b; e++) {
				if (a[d] > a[e])sum++;
			}
		}
		cout << sum << endl;
	}
}