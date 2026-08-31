#include <math.h>
#include <iostream>
using namespace std;

int Q;

bool ok(long int n, int c) {
	if (n < 10) {
		cout << c << endl;
		return true;
	}
	return false;
}

int mul(long int n) {
	int t,r = 0;
	int dig = (int)log10(n);
	for (int i = 1; i < dig + 1; i++) {
		t = (n / (int)pow(10,i)) * (n % (int)pow(10,i));
		if (t > r) {
			r = t;
		}
	}
	return r;
}

int main(){
	long int N;
	int c;
	cin >> Q;
	for (int i = 0; i < Q; i++) {
		cin >> N;
		c = 0;
		while (!ok(N, c)) {
			if (c > 10000) {
				cout << -1 << endl;
				break;
			}
			N = mul(N);
			c++;
		}
	}

	return 0;
}