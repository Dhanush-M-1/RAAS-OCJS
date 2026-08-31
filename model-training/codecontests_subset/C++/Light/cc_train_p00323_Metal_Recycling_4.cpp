#include <bits/stdc++.h>
using namespace std;
int n, a, b, x[200099];
int main() {
	cin >> n;
	while(n--) {
		cin >> a >> b;
		x[a + b]++;
	}
	for(int i = 0; i <= 200029; i++) {
		x[i + 1] += x[i] / 2; x[i] %= 2;
		if(x[i] == 1) cout << i << ' ' << 0 << endl;
	}
}